package com.tsingsoft.android.server.connect.sqlite.demo.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import android.content.Context;

import com.alibaba.fastjson.JSON;
import com.tsingsoft.android.entity.db.dao.StFc96LcSubmitDao;

public class LoadCorrectSubmitHelper {
	String netId;
	private String caliberId;
	private String ymd;

	private String load;

	public String process(Map<String, String> req, Context context) {
		String result=null;
		init(req);
		String[] arrLoads = load.split(",");
		List<String> loads = new ArrayList<String>();
		for (int i = 0; i < arrLoads.length; i++) {
			loads.add(arrLoads[i]);
		}
		StFc96LcSubmitDao service = new StFc96LcSubmitDao(context);
		TreeMap<String, Object> temMap = new TreeMap<String, Object>();
		try {

			service.updateFcSubmit(netId, caliberId, ymd, loads);

			temMap.put("msg", "保存成功!!!");
			temMap.put("re", "success");
			result=	JSON.toJSONString(temMap);
		} catch (Exception e) {
			temMap.put("msg", "保存失败，请重试...");
			result=	JSON.toJSONString(temMap);
			e.printStackTrace();
		}
		return result;
	}

	private void init(Map<String, String> req) {
		netId = req.get("netId");
		caliberId = req.get("caliberId");
		ymd = req.get("ymd");
		load = req.get("loads");
	}
}
