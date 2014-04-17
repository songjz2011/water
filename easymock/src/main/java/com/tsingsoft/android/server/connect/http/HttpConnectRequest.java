/*
 * HttpConnectRequest.java
 * Copyright: Copyright TsingSoft (c) 2013
 * Company: 北京清软创新科技有限公司
 */
package com.tsingsoft.android.server.connect.http;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

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
import com.tsingsoft.android.entity.User;
import com.tsingsoft.android.entity.db.dao.UserDao;
import com.tsingsoft.android.server.ServerSearchConstant;
import com.tsingsoft.android.server.connect.ConnectRequest;
import com.tsingsoft.android.server.exception.SearchException;
import com.tsingsoft.android.util.FileStreamUtil;
import com.tsingsoft.android.util.LoggerUtil;
import com.tsingsoft.android.util.MD5Util;
import com.tsingsoft.android.util.NumberUtil;
import com.tsingsoft.android.util.StringUtil;

/**
 * <pre>
 * http协议 - 连接服务器端的请求接口
 * </pre>
 * 
 * @author songjz
 * @time 2013-12-9
 */
public abstract class HttpConnectRequest implements ConnectRequest {

	/** 编码格式 */
	protected String chartset = "UTF-8";

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
	protected Object postWithHttpClient(String action,
			List<NameValuePair> params, Context context) throws SearchException {
		HttpResponse httpResponse = null;
		User user = assertUserEmpty(context);
		try {
			// 第一步，创建HttpPost对象
			HttpPost httpPost = new HttpPost(action);
			// 增加用户信息
			params.add(new BasicNameValuePair("username", user.getUserName()));
			params.add(new BasicNameValuePair("password", MD5Util.toMD5(user
					.getPassWord())));
			// 第二步，设置httpPost请求参数
			httpPost.setEntity(new UrlEncodedFormEntity(params, chartset));
			httpResponse = new DefaultHttpClient().execute(httpPost);
			// 第三步，使用getEntity方法活得返回结果
			if (httpResponse.getStatusLine().getStatusCode() == 200) {
				String result = EntityUtils.toString(httpResponse.getEntity(),
						chartset);
				return result;
			}
		} catch (Exception e) {
			LoggerUtil.debug(getClass(), e);
			throw new SearchException(
					ServerSearchConstant.getMessage("connect.error"));
		}
		return null;
	}

	/**
	 * post请求方式获取数据
	 * 
	 * @param action
	 *            ：请求的action路径(包含服务地址和上下文)<br>
	 *            例如：http://localhost:8080/huzhou/androidAction
	 * @param param
	 *            ：请求的参数，类似form提交的数据
	 * @return
	 * @throws ConnectRequestException
	 */
	protected Object post(String action, String param, Context context)
			throws SearchException {
		User user = assertUserEmpty(context);

		HttpURLConnection connection = null;
		DataOutputStream dataOutputStream = null;
		BufferedReader reader = null;
		StringBuilder result = new StringBuilder();
		try {
			connection = buildPostHttpURLConnection(action);
			// 连接服务器
			connection.connect();
			// 设置发送参数
			StringBuilder postParam = new StringBuilder();
			if (!StringUtil.isEmpty(param)) {
				postParam.append(param).append("&");
			}
			postParam.append("username=").append(user.getUserName());
			postParam.append("&password=").append(
					MD5Util.toMD5(user.getPassWord()));

			dataOutputStream = new DataOutputStream(
					connection.getOutputStream());
			dataOutputStream.writeBytes(postParam.toString());
			dataOutputStream.flush();

			// 下面开始做接收工作
			reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream(), chartset));
			String readLine = null;
			while ((readLine = reader.readLine()) != null) {
				result.append(readLine);
			}
		} catch (Exception e) {
			LoggerUtil.debug(getClass(), e);
			throw new SearchException(
					ServerSearchConstant.getMessage("connect.error"));
		} finally {
			FileStreamUtil.closeOutputStream(dataOutputStream);
			FileStreamUtil.closeReader(reader);
			closeHttpURLConnection(connection);
		}
		return result.toString();
	}

	/**
	 * 构造post请求的连接
	 * 
	 * @param action
	 * @return
	 * @throws IOException
	 */
	protected HttpURLConnection buildPostHttpURLConnection(String action)
			throws IOException {
		URL url = new URL(action);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		// 设置输入流采用字节流
		connection.setDoInput(true);
		// 设置输出流采用字节流
		connection.setDoOutput(true);
		// 设置请求方式为 POST
		connection.setRequestMethod("POST");
		// 设置缓存
		connection.setUseCaches(false);
		// 采用form形式的请求方式
		connection.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded");
		// 设置编码格式
		connection.setRequestProperty("Chartset", chartset);
		return connection;
	}

	/**
	 * 关闭HttpURLConnection请求连接
	 * 
	 * @param connection
	 */
	protected void closeHttpURLConnection(HttpURLConnection connection) {
		if (connection != null) {
			connection.disconnect();
		}
	}

	/**
	 * 检测用户信息
	 * 
	 * @param user
	 */
	private User assertUserEmpty(Context context) {

		/*UserDao dao = new UserDao(context);
		User user = dao.findDefalutUser();

		if (user == null) {
			throw new SearchException(
					ServerSearchConstant.getMessage("user.error"));
		}*/
		return testUser();
	}

	private User testUser() {
		User user = new User();
		user.setPassWord("tsingsoft");
		user.setUserName("admin");
		return user;
	}

	/**
	 * 检测返回的数据
	 * 
	 * @param data
	 * @return
	 */
	protected JSONObject assertReturnData(Object data) {
		assertEmpty(data);
		JSONObject json = JSONObject.parseObject(data.toString());
		assertServerErrorMessage(json);
		return json;
	}
	
	protected JSONArray assertReturnArray(Object data){
		assertEmpty(data);
		JSONArray json = JSONObject.parseArray(data.toString());
		return json;
	}

	/**
	 * 检测返回数据是否为空
	 */
	private void assertEmpty(Object returnData) {
		if (StringUtil.isEmpty(returnData)) {
			throw new SearchException(
					ServerSearchConstant.getMessage("obtain.data.error"));
		}
	}

	/**
	 * 检验从服务器端获取的错误信息
	 * 
	 * @param object
	 */
	private void assertServerErrorMessage(JSONObject object) {
		Object error = object.get(ServerSearchConstant.SERVERERRORMESSAGEKEY);
		if (!StringUtil.isEmpty(error)) {
			throw new SearchException(error.toString());
		}
	}

	/**
	 * 获取json对象中的数据
	 * 
	 * @param object
	 * @param key
	 * @return
	 */
	protected String getStringJSONObject(JSONObject object, String key) {
		
		if(object==null){
			return "";
		}else{
			Object value = object.get(key);
			return StringUtil.trim(value);
		}
		
	}

	/**
	 * 获取json对象中的数据
	 * 
	 * @param object
	 * @param key
	 * @return
	 */
	protected Double getDoubleJSONObject(JSONObject object, String key) {
		if(object==null){
			return null;
		}else{
			Object value = object.get(key);
			return NumberUtil.convertToDouble(value);
		}
		
	}

	/**
	 * 获取json对象中的数据
	 * 
	 * @param object
	 * @param key
	 * @return
	 */
	protected List<Double> getDoubleList(JSONObject object, String key) {
		List<Double> result = new ArrayList<Double>();
		if(object==null){
			return result;
		}
		Object value = object.get(key);
		if (StringUtil.isEmpty(value)) {
			return result;
		}
		if (value instanceof JSONArray) {
			JSONArray valueArray = (JSONArray) value;
			for (Object obj : valueArray) {
				result.add(NumberUtil.convertToDouble(obj));
			}
		}
		return result;
	}

	protected List<List<Double>> getDoubleListArr(JSONObject object, String key) {
		List<List<Double>> result = new ArrayList<List<Double>>();
		if(object==null){
			return result;
		}
		Object value = object.get(key);
		if (StringUtil.isEmpty(value)) {
			return result;
		}
		if (value instanceof JSONArray) {
			JSONArray valueArray = (JSONArray) value;
			for (Object obj : valueArray) {
				if (obj instanceof JSONArray) {
					JSONArray _valueArray = (JSONArray) obj;
					List<Double> list = new ArrayList<Double>();
					for (Object _obj : _valueArray) {
						list.add(NumberUtil.convertToDouble(_obj));
					}
					result.add(list);
				}
			}
		}
		return result;
	}

	/**
	 * 获取json对象中的数据
	 * 
	 * @param object
	 * @param key
	 * @return
	 */
	protected List<String> getStringList(JSONObject object, String key) {
		List<String> result = new ArrayList<String>();
		if(object==null){
			return result;
		}
		Object value = object.get(key);
		if (StringUtil.isEmpty(value)) {
			return result;
		}
		if (value instanceof JSONArray) {
			JSONArray valueArray = (JSONArray) value;
			for (Object obj : valueArray) {
				result.add(StringUtil.trim(obj));
			}
		}
		return result;
	}

	/**
	 * 根据时刻点的json数据，构造成map形式的数据格式
	 * 
	 * @param pointTimeJson
	 * @return
	 */
	protected TreeMap<String, Double> buildPointTimeMap(Object pointTimeValue) {
		TreeMap<String, Double> result = new TreeMap<String, Double>();
		if (StringUtil.isEmpty(pointTimeValue)) {
			return result;
		}
		if (pointTimeValue instanceof JSONObject) {
			JSONObject json = (JSONObject) pointTimeValue;
			for (String key : json.keySet()) {
				result.put(key, NumberUtil.convertToDouble(json.get(key)));
			}
		}
		return result;
	}

	protected String getUrlAction(Context context) {
		String ip = "";
		String port = "";
		String server_name = "";
		// http://192.168.0.238:8089/huzhouserver/android
		StringBuilder url = new StringBuilder();
		url.append("http://");
		url.append(ip);

		if (port != null && !"".equals(port)) {
			url.append(":" + port);
		}
		if (server_name != null && !"".equals(server_name)) {
			url.append("/" + server_name);
		}

		url.append("/android");

		return url.toString();
	}

}
