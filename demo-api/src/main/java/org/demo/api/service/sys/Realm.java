package org.demo.api.service.sys;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.demo.api.entity.dto.TbSysUserEntityDto;
import org.demo.api.util.EncryptUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class Realm extends AuthorizingRealm {

	@Autowired
	private SysUserService sysUserService;

	public Realm() {
		super();

	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		/* 这里编写授权代码 */
		Set<String> roleNames = new HashSet<String>();
		Set<String> permissions = new HashSet<String>();
		roleNames.add("admin");
		permissions.add("/in/hello");
		permissions.add("test");
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roleNames);
		info.setStringPermissions(permissions);
		return info;

	}

	/**
	 * 认证回调函数，登录信息和用户验证信息验证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
			throws AuthenticationException {
		/* 这里编写认证代码 */
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		TbSysUserEntityDto user = new TbSysUserEntityDto();
		user.setLoginName(token.getUsername());
		// 通过帐号查找用户信息
		try {
			user = (TbSysUserEntityDto) sysUserService.getUserInfo(user);
			
			user.setPassword(EncryptUtils.encryptMD5(user.getPassword()));
			System.out.println("###################1"+String.valueOf(token.getPassword()));
			System.out.println("###################2"+EncryptUtils.encryptMD5(user.getPassword()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (user != null) {
			//比较用户名密码是否一样等操作
			if(user.getPassword().equals(String.valueOf(token.getPassword()))){
				return new SimpleAuthenticationInfo(user.getLoginName(), user.getPassword(), getName());
			}
		}
		SecurityUtils.getSubject().logout();
		throw null;
	}

	public void clearCachedAuthorizationInfo(String principal) {
		SimplePrincipalCollection principals = new SimplePrincipalCollection(principal, getName());
		clearCachedAuthorizationInfo(principals);
	}

}
