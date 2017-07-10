package org.demo.web.base.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.demo.api.constant.SysConstant;
import org.demo.api.entity.dto.TbSysUserEntityDto;




public class WebBaseController {
protected HttpServletRequest request;
	
	protected HttpServletResponse response;
	
	protected HttpSession session;

	/** 分页参数：起始页 */
	protected final String START_ROW = "startRow";
	/** 分页参数：结束页 */
	protected final String END_ROW = "endRow";
	/** 总记录数 */
	protected final String ALL_RECORDERS = "allRecorders";
	/** 总页数 */
	protected final String PAGE_COUNT = "pageCount";
	/** 当前页 */
	protected final String PAGE_NO = "pageNo";
	/** 每页数据条数 */
	protected final String PAGE_SIZE = "pageSize";
	protected void setCommParameters(HttpServletRequest request, Map<String, Object> map){
		//排序字段名称。
		String sort=request.getParameter("sort");
		//排序顺序
		String sortOrder=request.getParameter("order");
		//当前第几页
		String page=request.getParameter("page");
		//每页显示的记录数
		String rows=request.getParameter("rows"); 
		//当前页  
        int currentPage = Integer.parseInt((page == null || page == "0") ? "1":page);  
        //每页显示条数  
        int pageSize = Integer.parseInt((rows == null || rows == "0") ? "10":rows);  
        //每页的开始记录  第一页为1  第二页为number +1   
        int startRow = (currentPage-1)*pageSize;  
        map.put(START_ROW, startRow);
		map.put(END_ROW, pageSize);
		map.put("sortName", sort);
		map.put("sortOrder", sortOrder);
	}
	/**
	 * 设置当前用户信息
	 * @return
	 */
	protected TbSysUserEntityDto setCurrentUserInfo(HttpServletRequest request,TbSysUserEntityDto userInfo){
		session=request.getSession();
		session.setAttribute(SysConstant.USER_INFO, userInfo);
		return userInfo;
	}
	
	/**
	 * 获取当前用户信息
	 * @return
	 */
	protected TbSysUserEntityDto getCurrentUserInfo(HttpServletRequest request){
			session=request.getSession();
			TbSysUserEntityDto userInfo = (TbSysUserEntityDto) session.getAttribute(SysConstant.USER_INFO);
		return userInfo;
	}
}
