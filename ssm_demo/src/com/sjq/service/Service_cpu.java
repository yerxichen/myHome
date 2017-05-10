package com.sjq.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.sjq.util.ConnectionFactory;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author 作者 :陈曦
 * @date 创建时间:2017年3月21日 下午2:36:26
 * @version 1.0
 * @parameter
 * @since
 * @return
 */
@Service
public class Service_cpu {
	private Connection conn = null;

	/**
	 * 查询cpu列表
	 * 
	 * @return
	 */
	public JSONObject cpu_list(int pageSize, int pageNumber) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		JSONObject rtObj = new JSONObject(), resObj = null;
		JSONArray jsonArr = new JSONArray();
		String sql = "SELECT xxzjbh,cpu_mc,cpu_cj,cpu_jg,cpu_xn from pz_cpu limit " + pageSize + "," + pageNumber;
		System.out.println(sql);
		try {
			conn = ConnectionFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				resObj = new JSONObject();
				resObj.put("xxzjbh", rs.getString("xxzjbh"));
				resObj.put("cpu_mc", rs.getString("cpu_mc"));
				resObj.put("cpu_cj", rs.getString("cpu_cj"));
				resObj.put("cpu_jg", rs.getString("cpu_jg"));
				resObj.put("cpu_xn", rs.getString("cpu_xn"));
				jsonArr.add(resObj);
				System.out.println(jsonArr.toString());
				rtObj.put("rows", jsonArr);
				rtObj.put("status", 1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeAll(rs, pstmt, conn);
		}
		rtObj.put("total", pz_cpu_size());
		return rtObj;
	}

	/**
	 * 查询出数据总条数
	 * 
	 * @return
	 */
	public int pz_cpu_size() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT count(*) from pz_cpu";
		int size = 0;
		try {
			conn = ConnectionFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				size = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeAll(rs, pstmt, conn);
		}

		return size;
	}

	/**
	 * 行内编辑
	 * 
	 * @return
	 */
	public JSONObject cpu_list_edit(String field, String newVal, String xxzjbh) {
		PreparedStatement pstmt = null;
		String sql = "update pz_cpu set " + field + "='" + newVal + "' where xxzjbh='" + xxzjbh + "'";
		System.out.println(sql);
		JSONObject rtObj = new JSONObject();
		rtObj.put("status", 0);
		try {
			conn = ConnectionFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			int count = pstmt.executeUpdate();
			rtObj.put("status", count);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeAll(pstmt, conn);
		}

		return rtObj;
	}
}
