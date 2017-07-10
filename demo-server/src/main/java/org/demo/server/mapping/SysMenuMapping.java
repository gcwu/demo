package org.demo.server.mapping;

import java.util.List;

import org.demo.api.entity.dto.TbSysMenuEntityDto;
import org.demo.api.entity.dto.TbSysUserEntityDto;

public interface SysMenuMapping {

	List<TbSysMenuEntityDto> getMenuList(TbSysUserEntityDto userInfo) throws Exception;
	
}
