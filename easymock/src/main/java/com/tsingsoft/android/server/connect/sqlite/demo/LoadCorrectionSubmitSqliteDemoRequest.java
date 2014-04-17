package com.tsingsoft.android.server.connect.sqlite.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;

import android.content.Context;

import com.alibaba.fastjson.JSONObject;
import com.tsingsoft.android.entity.db.dao.LoadCorrectionDao;
import com.tsingsoft.android.server.connect.http.HttpConnectRequest;
import com.tsingsoft.android.server.connect.sqlite.demo.helper.LoadCorrectSubmitHelper;
import com.tsingsoft.android.server.exception.SearchException;
import com.tsingsoft.android.server.search.ServerSearch;
import com.tsingsoft.android.server.search.ServerSearchCondition;

public class LoadCorrectionSubmitSqliteDemoRequest extends HttpConnectRequest {

	public <T> T search(ServerSearch<T> search, Context context)
			throws SearchException {

		
		ServerSearchCondition condition = search.buildSearchCondition();
		List<NameValuePair> pairList = condition.getPairList();
		Map<String,String> map=new HashMap<String,String>();
		for(NameValuePair pnv:pairList){
			map.put(pnv.getName(),pnv.getValue());
		}
		LoadCorrectSubmitHelper help=new LoadCorrectSubmitHelper();
		Object result =help.process(map,context);
		return (T) buildClientEntity(result);
	}
	
	private String buildClientEntity(Object obj) {
		JSONObject json = assertReturnData(obj);
		return getStringJSONObject(json, "msg");
	}
	
	/**
	 * 获取要上报的数据
	 * @param context
	 * @param fcNO
	 * @param ymd
	 * @return
	 */
	private String getFcLoads(Context context,String netId,String caliberId,String ymd){
		LoadCorrectionDao dao = new LoadCorrectionDao(context);
		List<Double> loadList = dao.getFcSubmit(netId,caliberId, ymd);
		String loads = "";
		if(null ==loadList || loadList.isEmpty()){
			return null;
		}
		for(Double d :loadList){
			loads +=","+d;
		}
		return loads.substring(1);
	}

}
