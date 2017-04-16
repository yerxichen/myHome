package com.wx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView query() {
		JSONObject rtObj = JSONObject.fromObject(cpuService.queryCpu());
		ModelAndView model = new ModelAndView();
		model.addObject(rtObj);
		model.setViewName("test");
		return model;
	}
}
