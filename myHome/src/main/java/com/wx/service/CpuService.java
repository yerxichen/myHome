package com.wx.service;

import java.util.Map;

import net.sf.json.JSONObject;

/**
 * @author 作者 :陈曦
 * @date 创建时间:2017年4月17日 上午9:56:21
 * @version 1.0
 * @parameter
 * @since
 * @return
 */
public interface CpuService {

	/**
	 * 查询cpu列表
	 * 
	 * @param page
	 *            当前页
	 * @param size
	 *            每页显示数
	 * @return
	 */
	public JSONObject queryCpu(int page, int size);

	/**
	 * 查询cpu品牌，接口类型，支持内存，核心类型
	 *
	 * @return
	 */
	public Map<String, Object> queryCpuInfo();

}
