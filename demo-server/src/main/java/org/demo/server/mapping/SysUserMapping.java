package org.demo.server.mapping;


import org.demo.api.entity.dto.TbSysUserEntityDto;

/**
 * 查询用户相关信息
 * @author gcwu
 * @date 2017年3月3日 下午5:18:02
 * @version 1.0
 * @parameter
 * @return
 */
public interface SysUserMapping {
	/**
	 * 获取用户信息
	 * @param tbSysUserEntityDto
	 * @return
	 * @throws Exception
	 */
	public TbSysUserEntityDto getUserInfo(TbSysUserEntityDto tbSysUserEntityDto) throws Exception;
}
