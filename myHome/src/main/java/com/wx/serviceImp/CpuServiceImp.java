package com.wx.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wx.dao.CpuDao;
import com.wx.pojo.Cpu;
import com.wx.service.CpuService;

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
	public JSONObject queryCpu() {
		Cpu pc_cpu = cpuDao.queryCpu();
		return null;
	}

}
