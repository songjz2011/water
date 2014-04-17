/*
 * UserValidateHttpConnectRequest.java
 * Copyright: Copyright TsingSoft (c) 2013
 * Company: 北京清软创新科技有限公司
 */
package com.tsingsoft.android.server.connect.http;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import android.content.Context;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tsingsoft.android.entity.LfCtrlNet;
import com.tsingsoft.android.entity.UserValidate;
import com.tsingsoft.android.server.ServerSearchConstant;
import com.tsingsoft.android.server.exception.SearchException;
import com.tsingsoft.android.server.search.ServerSearch;
import com.tsingsoft.android.util.LoggerUtil;
import com.tsingsoft.android.util.MD5Util;

/**
 * <pre>
 * 用户验证 - http协议 - 连接服务器端的请求
 * 目前把获取用户默认的数据放在了此逻辑，后续若不合适，则可单独把用户默认数据提取出来
 * </pre>
 * 
 * @author songjz
 * @time 2013年12月17日
 */
public class UserValidateHttpConnectRequest extends HttpConnectRequest {

	@SuppressWarnings("unchecked")
	public <T> T search(ServerSearch<T> search, Context context) throws SearchException {
		String urlAction = getUrlAction(context);
		Map<String, String> map = search.buildSearchCondition().getAssistInfo();
		String username = map.get("username");
		String password = map.get("password");
		List<NameValuePair> pairList = new ArrayList<NameValuePair>();
		pairList.add(new BasicNameValuePair("username", username));
		pairList.add(new BasicNameValuePair("password", MD5Util.toMD5(password)));
		pairList.add(new BasicNameValuePair("command", "UserValidate"));
		Object result = postWithHttpClient(urlAction, pairList, context);
		return (T) buildClientEntity(result, username, password);
	}

	private UserValidate buildClientEntity(Object obj, String username, String password) {
		UserValidate userValidate = new UserValidate();
		userValidate.setUserName(username);
		userValidate.setPassWord(password);
		userValidate.setSuccess(true);
		try {
			JSONObject json = assertReturnData(obj);
			userValidate.setNetList(buildLfCtrlNetList(json.get("netList")));
		} catch (SearchException e) {
			userValidate.setSuccess(false);
			userValidate.setErrorMessage(e.getMessage());
		}
		return userValidate;
	}

	/**
	 * 构造电网信息集合
	 */
	private List<LfCtrlNet> buildLfCtrlNetList(Object value) {
		List<LfCtrlNet> result = new ArrayList<LfCtrlNet>();
		if (!(value instanceof JSONArray)) {
			return result;
		}
		JSONArray valueArray = (JSONArray) value;
		for (int i = 0; i < valueArray.size(); i++) {
			JSONObject obj = (JSONObject) valueArray.get(i);
			LfCtrlNet net = new LfCtrlNet();
			net.setNetId(obj.getString("netId"));
			net.setNetName(obj.getString("netName"));
			net.setUpNetId(obj.getString("upNetId"));
			net.setNetLevel(obj.getInteger("netLevel"));
			result.add(net);
		}
		return result;
	}

	/**
	 * <pre>
	 * 采用apache封装好的http链接方式，进行获取远程数据
	 * 例子：
	 * 
	 * </pre>
	 * 
	 * @param action
	 *            ：请求的action路径(包含服务地址和上下文)<br>
	 *            例如：http://localhost:8080/huzhou/androidAction
	 * @param params
	 *            ：请求参数，类似form提交的数据
	 * @param context
	 * @return
	 * @throws SearchException
	 */
	protected Object postWithHttpClient(String action, List<NameValuePair> params, Context context)
			throws SearchException {
		HttpResponse httpResponse = null;
		try {
			// 第一步，创建HttpPost对象
			HttpPost httpPost = new HttpPost(action);
			// 第二步，设置httpPost请求参数
			httpPost.setEntity(new UrlEncodedFormEntity(params, chartset));
			httpResponse = new DefaultHttpClient().execute(httpPost);
			// 第三步，使用getEntity方法活得返回结果
			if (httpResponse.getStatusLine().getStatusCode() == 200) {
				String result = EntityUtils.toString(httpResponse.getEntity(), chartset);
				return result;
			}
		} catch (Exception e) {
			LoggerUtil.debug(getClass(), e);
			throw new SearchException(ServerSearchConstant.getMessage("connect.error"));
		}
		return null;
	}

}
