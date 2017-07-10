package org.demo.server.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.demo.api.entity.dto.TbSysMenuEntityDto;
import org.demo.api.entity.dto.TbSysUserEntityDto;
import org.demo.api.service.sys.SysMenuService;
import org.demo.server.mapping.SysMenuMapping;

public class SysMenuServiceImpl implements SysMenuService {
	@Resource
	private SysMenuMapping sysMenuMapping;
	
	@Override
	public List<TbSysMenuEntityDto> getMenuList(TbSysUserEntityDto userInfo) throws Exception {
		
		return sysMenuMapping.getMenuList(userInfo);
	}

}
