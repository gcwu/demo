package org.demo.web.sys.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.demo.api.constant.SysConstant;
import org.demo.api.entity.dto.TbSysUserEntityDto;
import org.demo.api.service.redis.RedisService;
import org.demo.api.service.sys.SysUserService;
import org.demo.api.util.EncryptUtils;
import org.demo.web.base.controller.WebBaseController;
import org.demo.web.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "login")
public class LoginController extends WebBaseController{
	
	@Resource
	private SysUserService sysUserService;
	
	@Resource
	private RedisService redisService;
	/*
	 * @Autowired User user;
	 */
	/**
	 * 用户登录
	 * 
	 * @param user
	   *           　登录用户
	 * @return
	 */
	@RequestMapping(value = "")
	public ModelAndView login(TbSysUserEntityDto user,HttpSession session, HttpServletRequest request) {

		ModelAndView modelView = new ModelAndView();
		Subject currentUser = SecurityUtils.getSubject();
		//用户名和密码
		UsernamePasswordToken token = new UsernamePasswordToken(
				user.getLoginName(), EncryptUtils.encryptMD5(user.getPassword()));
		token.setRememberMe(user.isRememberMe());
		try {
			currentUser.login(token);
		} catch (AuthenticationException e) {
			modelView.addObject("message", "login errors");
			modelView.setViewName("login");
			e.printStackTrace();
			
		}
		if(currentUser.isAuthenticated()){
			TbSysUserEntityDto userInfo=null;
			try {
				 userInfo = sysUserService.getUserInfo(user);
			} catch (Exception e) {
				e.printStackTrace();
			}
			setCurrentUserInfo(request, userInfo);
			//保存登录信息到redis
			redisService.set(userInfo.getLoginName(), JsonUtil.objectToJsonStr(userInfo));
			modelView.setViewName("redirect:/index");
		}else{
			modelView.addObject("message", "login errors");
			modelView.setViewName("login");
		}
		return modelView;
	}

	/**
	 * 退出登录
	 * 
	 * @return
	 */
	@RequestMapping(value = "logout")
	public String logout() {
		Subject currentUser = SecurityUtils.getSubject();
		try {
			currentUser.logout();
		} catch (AuthenticationException e) {
			e.printStackTrace();

		}
		return "/login";
	}

	
	@RequiresPermissions("test")
	@RequestMapping(value = "test")
	public ModelAndView login3() {
		System.out.println("sss");
		ModelAndView modelView = new ModelAndView();
		modelView.addObject("message", "登录成功!");
		modelView.setViewName("test");
		return modelView;
	}
	
	
	@RequestMapping(value = "unauthorized")
	public ModelAndView unauthorized() {
		System.out.println("unauthorized");
		ModelAndView modelView = new ModelAndView();
		modelView.addObject("message", "登录成功!");
		modelView.setViewName("unauthorized");
		return modelView;
	}
}
