package com.wx.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wx.service.CpuService;

import net.sf.json.JSONObject;

/**
 * @author 作者 :陈曦
 * @date 创建时间:2017年4月14日 下午5:03:44
 * @version 1.0
 * @parameter
 * @since
 * @return
 */
@Controller
@RequestMapping("/cpu")
public class CpuController {
	@Autowired
	private CpuService cpuService;

	@RequestMapping("/query.do")
	@ResponseBody
	public JSONObject query(HttpServletRequest request, HttpServletResponse response) {
		int page = Integer.parseInt(request.getParameter("page"));
		int size = Integer.parseInt(request.getParameter("size"));
		page *= size;
		JSONObject rtObj = cpuService.queryCpu(page, size);
		return rtObj;
	}
}
