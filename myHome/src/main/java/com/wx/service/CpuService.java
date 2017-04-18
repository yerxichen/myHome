package com.wx.service;

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

}
