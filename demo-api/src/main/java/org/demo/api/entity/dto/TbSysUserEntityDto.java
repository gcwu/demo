package org.demo.api.entity.dto;

import org.demo.api.entity.TbSysUserEntity;

public class TbSysUserEntityDto extends TbSysUserEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4660109703911840122L;

	
	private boolean rememberMe;


	public boolean isRememberMe() {
		return rememberMe;
	}


	public void setRememberMe(boolean rememberMe) {
		this.rememberMe = rememberMe;
	}
	
}
