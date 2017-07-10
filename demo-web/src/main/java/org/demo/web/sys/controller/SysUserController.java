package org.demo.web.sys.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.demo.api.entity.dto.TbSysUserEntityDto;
import org.demo.api.service.sys.SysUserService;
import org.demo.web.base.controller.WebBaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "sysUser")
public class SysUserController extends WebBaseController {
	private static Logger logger = Logger.getLogger(SysUserController.class);  
	@Autowired
	private SysUserService SysUserService;
	
	@RequestMapping(value = "getUserInfo")
	public ModelAndView getUserInfo(HttpServletRequest request) {
		ModelAndView modelView = new ModelAndView();
		TbSysUserEntityDto userInfo = getCurrentUserInfo(request);
		try {
			TbSysUserEntityDto test = SysUserService.getUserInfo(userInfo);
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("获取用户信息出错"+e.getMessage());
		}
		modelView.addObject("userInfo",userInfo);
		modelView.setViewName("");
		return modelView;
	}
}
