package com.sjq.controller;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sjq.service.Service_cpu;

import net.sf.json.JSONObject;

/**
 * @author 作者 :陈曦
 * @date 创建时间:2017年3月21日 下午3:11:17
 * @version 1.0
 * @parameter
 * @since
 * @return
 */
@Controller
@RequestMapping("/cpu")
public class Controller_cpu {
	@Autowired
	private Service_cpu service_cpu;

	/**
	 * 显示cpu列表
	 * 
	 * @param req
	 * @param res
	 * @throws IOException
	 */
	@RequestMapping("/list")
	public void cpu_list(HttpServletRequest req, HttpServletResponse res) throws IOException {
		System.out.println("111");
		req.setCharacterEncoding("utf-8");
		res.setContentType("application/json;charset=utf-8");
		res.setHeader("Cache-Control", "no-cache");
		OutputStream out = res.getOutputStream();
		int pageSize = Integer.parseInt(req.getParameter("pageSize"));
		int pageNumber = Integer.parseInt(req.getParameter("pageNumber"));
		System.out.println(pageSize + "==" + pageNumber);
		JSONObject jsonObject = service_cpu.cpu_list(pageNumber, pageSize);
		out.write(jsonObject.toString().getBytes("UTF-8"));
		out.flush();
		out.close();
	}

	/**
	 * cpu列表行内编辑
	 * 
	 * @param req
	 * @param res
	 * @throws IOException
	 */
	@RequestMapping("/edit")
	public void cpu_list_edit(HttpServletRequest req, HttpServletResponse res) throws IOException {
		System.out.println("111");
		req.setCharacterEncoding("utf-8");
		res.setContentType("application/json;charset=utf-8");
		res.setHeader("Cache-Control", "no-cache");
		OutputStream out = res.getOutputStream();
		String field = req.getParameter("field");
		String newVal = req.getParameter("newVal");
		String xxzjbh = req.getParameter("xxzjbh");
		System.out.println(field + "==" + newVal);
		JSONObject jsonObject = service_cpu.cpu_list_edit(field, newVal, xxzjbh);
		out.write(jsonObject.toString().getBytes("UTF-8"));
		out.flush();
		out.close();
	}

}
