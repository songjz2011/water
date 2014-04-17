/*
 * ServerSearch.java
 * Copyright: Copyright TsingSoft (c) 2013
 * Company: 北京清软创新科技有限公司
 */
package com.tsingsoft.android.server.search;

/**
 * <pre>
 * 请求服务器端的查询接口，用于客户端向服务器端请求查询数据
 * </pre>
 * 
 * @author songjz
 * @time 2013-12-9
 */
public interface ServerSearch<T> {

	/** 构造查询条件的语句 */
	ServerSearchCondition buildSearchCondition();

}
