package com.lmning.graphs;

/**
 * <pre>
 * 顶点对象
 * </pre>
 * 
 * @author songjz
 * @time 2014年4月14日
 */
public class Vertex {

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 是否已经访问过
	 */
	private boolean wasVisited;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isWasVisited() {
		return wasVisited;
	}

	public void setWasVisited(boolean wasVisited) {
		this.wasVisited = wasVisited;
	}

}
