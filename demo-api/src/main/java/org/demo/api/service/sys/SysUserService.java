package org.demo.api.service.sys;

import org.demo.api.entity.dto.TbSysUserEntityDto;

public interface SysUserService {

	public TbSysUserEntityDto getUserInfo(TbSysUserEntityDto userInfo) throws Exception;
}
