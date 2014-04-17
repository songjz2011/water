package com.tsingsoft.android.server.connect;

/**
 * <pre>
 * 连接服务器端的请求类型的枚举
 * </pre>
 * 
 * @author songjz
 * @time 2013-12-9
 */
public enum ConnectRequestEnum {

	LOADMONITOR("1", "数据监控"), USERVALIDATE("2", "用户验证"), LOADCORRECTION("3", "负荷修正"), LOADANALYZE(
			"4", "负荷分析"), WEATHER("5", "气象"),CORRECTIONSUBMIT("6","负荷上报"),SYSDATE("7","获取系统时间");

	private String id;

	private String name;

	private ConnectRequestEnum(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
