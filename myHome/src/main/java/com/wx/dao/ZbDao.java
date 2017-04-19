package com.wx.dao;

import java.util.List;
import java.util.Map;

/**
 * @author 作者 :陈曦
 * @date 创建时间:2017年4月19日 下午5:12:45
 * @version 1.0
 * @parameter
 * @since
 * @return
 */
public interface ZbDao {

	/**
	 * 查询主板结构
	 * 
	 * @param cclx
	 *            插槽类型
	 * @return
	 */
	public List<Map<String, Object>> queryZbZbjg(String cclx);

	/**
	 * 查询主板芯片
	 * 
	 * @param cclx
	 *            插槽类型
	 * @return
	 */
	public List<Map<String, Object>> queryZbZbxp(String cclx);
}
