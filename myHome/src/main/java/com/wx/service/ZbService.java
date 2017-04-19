package com.wx.service;

import java.util.Map;

/**
 * @author 作者 :陈曦
 * @date 创建时间:2017年4月19日 下午6:22:57
 * @version 1.0
 * @parameter
 * @since
 * @return
 */
public interface ZbService {
	/**
	 * 查询主板结构，主板芯片
	 *
	 * @return
	 */
	public Map<String, Object> queryZbInfo();
}
