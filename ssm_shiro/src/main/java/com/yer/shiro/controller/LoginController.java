package com.yer.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 作者 :陈曦
 * @date 创建时间:2017年5月10日 上午11:35:31
 * @version 1.0
 * @parameter
 * @since
 * @return
 */
@Controller
@RequestMapping("/shiro")
public class LoginController {

	@RequestMapping("/login")
	public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
		Subject currentUser = SecurityUtils.getSubject();
		if (!currentUser.isAuthenticated()) {
			// 把用户名和密码封装成
			UsernamePasswordToken upToken = new UsernamePasswordToken(username, password);
			upToken.setRememberMe(true);
			try {
				// 执行登录
				currentUser.login(upToken);
			} catch (AuthenticationException e) {
				// TODO: handle exception
				System.out.println("登录失败！" + e.getMessage());
			}
		}
		return "redirect:/list.jsp";
	}
}
