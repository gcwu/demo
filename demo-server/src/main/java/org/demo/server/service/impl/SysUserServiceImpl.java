package org.demo.server.service.impl;


import javax.annotation.Resource;

import org.demo.api.entity.dto.TbSysUserEntityDto;
import org.demo.api.service.sys.SysUserService;
import org.demo.server.mapping.SysUserMapping;


/**
 * @author gcwu
 * @date 2017年3月6日 上午10:28:07
 * @version 1.0
 * @parameter
 * @return
 */
public class SysUserServiceImpl implements SysUserService {

	/* (non-Javadoc)
	 * @see com.demo.dao.UserInfoService#getUserInfo(com.demo.entity.UserInfo)
	 */
	@Resource
	private SysUserMapping sysUserMapping;

	@Override
	public TbSysUserEntityDto getUserInfo(TbSysUserEntityDto userInfo) throws Exception {
		return sysUserMapping.getUserInfo(userInfo);
	}
}
