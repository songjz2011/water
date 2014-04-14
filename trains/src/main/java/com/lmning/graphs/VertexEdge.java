package com.lmning.graphs;

/**
 * <pre>
 * 顶点边
 * </pre>
 * 
 * @author songjz
 * @time 2014年4月14日
 */
public class VertexEdge {

	/**
	 * 开始顶点索引
	 */
	private int start;

	/**
	 * 结束顶点索引
	 */
	private int end;

	/**
	 * 权重
	 */
	private int weight;

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}


}
