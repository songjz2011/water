package com.tsingsoft.android.server.connect.http;

import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.content.Context;

import com.alibaba.fastjson.JSONObject;
import com.tsingsoft.android.entity.db.dao.LoadCorrectionDao;
import com.tsingsoft.android.server.exception.SearchException;
import com.tsingsoft.android.server.search.ServerSearch;
import com.tsingsoft.android.server.search.ServerSearchCondition;

/**
 * 负荷修正上报
 * 
 * @author F.Liu
 * 
 */
public class CorrectionSubmitRequest extends HttpConnectRequest {

	public <T> T search(ServerSearch<T> search, Context context)
			throws SearchException {

		String urlAction = getUrlAction(context);
		ServerSearchCondition condition = search.buildSearchCondition();
		List<NameValuePair> pairList = condition.getPairList();
		pairList.add(new BasicNameValuePair("command", "LodCorrectionSubmit"));
		Object result = postWithHttpClient(urlAction, pairList, context);
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
