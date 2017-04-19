package com.wx.serviceImp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wx.dao.CpuDao;
import com.wx.service.CpuService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author 作者 :陈曦
 * @date 创建时间:2017年4月17日 上午9:55:48
 * @version 1.0
 * @parameter
 * @since
 * @return
 */
@Service
public class CpuServiceImp implements CpuService {
	@Autowired
	private CpuDao cpuDao;

	@Override
	public JSONObject queryCpu(int page, int size) {
		List<Map<String, Object>> pc_cpu = cpuDao.queryCpu(page, size);
		JSONArray arr = JSONArray.fromObject(pc_cpu);
		JSONObject obj = new JSONObject();
		obj.put("result", arr);
		return obj;
	}

	@Override
	public Map<String, Object> queryCpuInfo() {
		Map<String, Object> objMap = new HashMap<String, Object>();
		List<Map<String, Object>> cpuPp = cpuDao.queryCpuPp();
		List<Map<String, Object>> cpuHxlx = cpuDao.queryCpuHxlx();
		List<Map<String, Object>> cpuJklx = cpuDao.queryCpuJklx();
		List<Map<String, Object>> cpuZcnc = cpuDao.queryCpuZcnc();
		objMap.put("cpuPp", cpuPp);
		objMap.put("cpuHxlx", cpuHxlx);
		objMap.put("cpuJklx", cpuJklx);
		objMap.put("cpuZcnc", cpuZcnc);
		return objMap;
	}

	@Override
	public Map<String, Object> searchCpu(String name, String pp, String jklx, String hxlx, String zcnc) {
		Map<String, Object> objMap = new HashMap<String, Object>();
		List<Map<String, Object>> SearchCpuRes = cpuDao.searchCpu(name, pp, jklx, hxlx, zcnc);
		System.out.println(SearchCpuRes.toString());
		objMap.put("result", SearchCpuRes);
		return objMap;
	}

}
