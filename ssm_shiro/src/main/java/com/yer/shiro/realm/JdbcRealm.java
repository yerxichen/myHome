package com.yer.shiro.realm;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

/**
 * @author 作者 :陈曦
 * @date 创建时间:2017年5月10日 上午10:38:41
 * @version 1.0
 * @parameter
 * @since
 * @return
 */
public class JdbcRealm extends AuthorizingRealm {

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 1.先把AuthenticationToken 转换成UsernamePasswordToken
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		// 获取UsernamePasswordToken的用户名
		String username = upToken.getUsername();
		// 从数据库获取username
		System.out.println("从数据库获取数据===");
		// 根据情况，决定认证通过或抛出异常
		if ("unknown".equals(username)) {
			// System.out.println("进异常unknown");
			throw new UnknownAccountException("用户不存在");
		}
		// System.out.println("异常unknown未跳出");
		if ("monster".equals(username)) {
			throw new LockedAccountException("用户被锁定");
		}

		// 以下数据模拟数据库的数据
		// 1.principal：认证的实体信息，可以是username，也可以是数据库的结果
		Object principal = username;
		// 2.credentials : 密码
		Object credentials = "";
		if ("user".equals(username)) {
			credentials = "098d2c478e9c11555ce2823231e02ec1";
		} else if ("admin".equals(username)) {
			credentials = "038bdaf98f2037b31f1e75b5b4c9b26e";
		}
		// 3.realmName 调用父类的getName()方法
		String realmName = getName();
		// 4.盐值
		ByteSource credentialsSalt = ByteSource.Util.bytes(username);
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, credentialsSalt,
				realmName);
		return info;
	}

	public static void main(String[] args) {
		String algorithmName = "MD5";
		Object credentials = "123456";
		Object salt = ByteSource.Util.bytes("zhang");
		int hashIterations = 1024;
		Object result = new SimpleHash(algorithmName, credentials, salt, hashIterations);
		System.out.println(result);
	}

	// 授权回调接口
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		System.out.println("授权回调");
		// 从principalCollection 中获取登录用户的信息
		Object principal = principalCollection.getPrimaryPrincipal();
		// 根据当前的用户信息，来获取其角色和权限，（可能需要查询数据库获取权限的set集合）
		Set<String> roles = new HashSet<String>();
		roles.add("user");
		if ("zhang".equals(principal)) {
			roles.add("admin");
		}
		// 给SimpleAuthorizationInfo设置roles
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);
		return info;
	}
}
