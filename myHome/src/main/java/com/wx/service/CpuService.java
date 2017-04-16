package com.wx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wx.dao.CpuDao;
import com.wx.pojo.Cpu;

/**
 * @author 作者 :陈曦
 * @date 创建时间:2017年4月14日 下午2:00:18
 * @version 1.0
 * @parameter
 * @since
 * @return
 */
@Service
public class CpuService {
	@Autowired
	private CpuDao cpuDao;

	public Cpu queryCpu() {
		Cpu pc_cpu = cpuDao.queryCpu();
		return pc_cpu;
	}
}
