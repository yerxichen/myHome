package com.yer.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;

/**
 * @author 作者 :陈曦
 * @date 创建时间:2017年5月10日 下午3:07:59
 * @version 1.0
 * @parameter
 * @since
 * @return
 */
public class SecondRealm extends AuthenticatingRealm {

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("进入SecondRealm");
		// 转换token
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		// 获取UsernamePasswordToken中的username
		String username = upToken.getUsername();
		// 通过username获取数据库中的信息（数据库的密码为加密过，salt==用户名，次数==1024）
		// 1.principal (返回数据库查询的结果，如用户名 对应的 手机号码 邮箱 等等信息 也可以直接返回用户名 )
		Object principal = username;
		// 2.hashedCredentials (返回的数据库中加密的密码)
		Object hashedCredentials = "2823ef8d65a3b6ba7b1da8b2aa63eff5";
		// 3.credentialsSalt(盐值)
		ByteSource credentialsSalt = ByteSource.Util.bytes(username);
		// 4.realmName(直接调用父类的getName()方法)
		String realmName = getName();
		AuthenticationInfo info = null;
		System.out.println("测试对比");
		info = new SimpleAuthenticationInfo(principal, hashedCredentials, credentialsSalt, realmName);
		System.out.println("比对正常！");

		return info;
	}

}
