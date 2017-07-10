package org.demo.api.entity.dto;

import java.util.List;

import org.demo.api.entity.TbSysMenuEntity;

public class TbSysMenuEntityDto extends TbSysMenuEntity{
	private static final long serialVersionUID = -2176671153983888631L;
	/**
	 * 子菜单
	 */
	private List<TbSysMenuEntityDto> childMenus;
	public List<TbSysMenuEntityDto> getChildMenus() {
		return childMenus;
	}
	public void setChildMenus(List<TbSysMenuEntityDto> childMenus) {
		this.childMenus = childMenus;
	}
	
	
}

