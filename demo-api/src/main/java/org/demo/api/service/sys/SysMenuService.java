package org.demo.api.service.sys;

import java.util.List;

import org.demo.api.entity.dto.TbSysMenuEntityDto;
import org.demo.api.entity.dto.TbSysUserEntityDto;

/**
 * 系统菜单服务
 * @author Administrator
 *
 */
public interface SysMenuService {

	public List<TbSysMenuEntityDto> getMenuList(TbSysUserEntityDto userInfo) throws Exception;
}
