package com.wx.dao;

import java.util.List;
import java.util.Map;

/**
 * @author 作者 :陈曦
 * @date 创建时间:2017年4月14日 下午1:50:38
 * @version 1.0
 * @parameter
 * @since
 * @return
 */
public interface CpuDao {

	/**
	 * 查询cpu列表
	 * 
	 * @return
	 */
	public List<Map<String, Object>> queryCpu(int page, int size);
}
