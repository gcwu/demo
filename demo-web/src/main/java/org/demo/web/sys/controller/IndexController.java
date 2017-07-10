
package org.demo.web.sys.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.demo.api.entity.dto.TbSysMenuEntityDto;
import org.demo.api.service.sys.SysMenuService;
import org.demo.api.service.sys.SysUserService;
import org.demo.web.base.controller.WebBaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 权限管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "index")
public class IndexController extends WebBaseController{
	private final Gson gson = new GsonBuilder().disableHtmlEscaping().create();
	@Resource
	private SysMenuService SysMenuService;
	/**
	 * 跳转主页
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "")
	public ModelAndView index(HttpServletRequest request) throws Exception {
		ModelAndView modelView = new ModelAndView();
		//查询用户信息
		modelView.addObject("userInfo",getCurrentUserInfo(request));
		//用户所拥有的菜单
		List<TbSysMenuEntityDto> rootMenu = SysMenuService.getMenuList(getCurrentUserInfo(request));
		List<TbSysMenuEntityDto> menuList = new ArrayList<>();
		for (int i = 0; i < rootMenu.size(); i++) {
	        // 一级菜单没有parentId
	        if (StringUtils.isBlank(rootMenu.get(i).getParentId()==null?"":rootMenu.get(i).getParentId().toString())) {
	            menuList.add(rootMenu.get(i));
	        }
	    }
		
		 // 为一级菜单设置子菜单，getChild是递归调用的
	    for (TbSysMenuEntityDto menu : menuList) {
	        menu.setChildMenus(getChild(menu.getId(), rootMenu));
	    }
		modelView.addObject("menuList",menuList);
		return modelView;
	}
	/**
	 * 递归查找子菜单
	 * 
	 * @param id
	 *            当前菜单id
	 * @param rootMenu
	 *            要查找的列表
	 * @return
	 */
	private List<TbSysMenuEntityDto> getChild(Integer id, List<TbSysMenuEntityDto> rootMenu) {
	    // 子菜单
	    List<TbSysMenuEntityDto> childList = new ArrayList<>();
	    for (TbSysMenuEntityDto menu : rootMenu) {
	        // 遍历所有节点，将父菜单id与传过来的id比较
	        if (StringUtils.isNotBlank(menu.getParentId()==null?"":menu.getParentId().toString())) {
	            if (menu.getParentId()==id) {
	                childList.add(menu);
	            }
	        }
	    }
	    // 把子菜单的子菜单再循环一遍
	    for (TbSysMenuEntityDto menu : childList) {// 没有url子菜单还有子菜单
	        if (StringUtils.isBlank(menu.getUrl())) {
	            // 递归
	            menu.setChildMenus(getChild(menu.getId(), rootMenu));
	        }
	    } // 递归退出条件
	    if (childList.size() == 0) {
	        return null;
	    }
	    return childList;
	}
}
