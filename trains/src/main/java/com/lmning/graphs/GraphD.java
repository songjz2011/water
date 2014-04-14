package com.lmning.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * <pre>
 * 基于邻接矩阵的有向图
 * </pre>
 * 
 * @author songjz
 * @time 2014年4月14日
 */
public class GraphD {

	/**
	 * 顶点集合
	 */
	private List<Vertex> vertexList = new ArrayList<Vertex>();

	/**
	 * 边界矩阵
	 */
	private List<VertexEdge> vertexEdgeList = new ArrayList<VertexEdge>();

	/**
	 * 邻接矩阵
	 */
	private int[][] adjustMatrix;

	/**
	 * 堆栈（深度搜索用），先进后出
	 */
	private Stack<Integer> thestack = new Stack<Integer>();

	/**
	 * 添加顶点
	 * 
	 * @param vertex
	 */
	public void addVertex(Vertex vertex) {
		if (vertex == null) {
			return;
		}
		vertexList.add(vertex);
	}
	
	/**
	 * 添加顶点
	 * 
	 * @param name
	 */
	public void addVertex(String name) {
		if (name == null) {
			return;
		}
		Vertex v = new Vertex();
		v.setName(name);
		vertexList.add(v);
	}

	/**
	 * 添加顶点的边界权重
	 * 
	 * @param start
	 * @param end
	 * @param weight
	 */
	public void addVertexEdge(int start, int end, int weight) {
		VertexEdge edge = new VertexEdge();
		edge.setStart(start);
		edge.setEnd(end);
		edge.setWeight(weight);
		vertexEdgeList.add(edge);
	}

	/**
	 * 显示顶点
	 * 
	 * @param index
	 */
	public void displayVertex(int index) {
		System.out.println(vertexList.get(index).getName());
	}

	/**
	 * 查看节点v的邻接点是否已经全部访问
	 * 
	 * @param v
	 * @return
	 */
	public int getAdjUnvisitedVertex(int index) {
		List<VertexEdge> eList = filter(index);
		for (VertexEdge edge : eList) {
			int end = edge.getEnd();
			if (vertexList.get(end).isWasVisited()) {
				continue;
			}
			return end;
		}
		return -1;
	}

	/**
	 * 过滤，查找 是start的边界
	 * 
	 * @param start
	 * @return
	 */
	private List<VertexEdge> filter(int start) {
		List<VertexEdge> result = new LinkedList<VertexEdge>();
		for (VertexEdge edge : vertexEdgeList) {
			if (start == edge.getStart()) {
				result.add(edge);
			}
		}
		return result;
	}

	/**
	 * 深度优先搜索Depth First Search
	 */
	public void dfs() {
		int index = 1;
		vertexList.get(index).setWasVisited(true);
		displayVertex(index);
		thestack.push(index);
		
		
		while(!thestack.isEmpty()) {
			int v = getAdjUnvisitedVertex(thestack.peek());
			if(v == -1) {
				thestack.pop();
				continue;
			}
			vertexList.get(v).setWasVisited(true);
			displayVertex(v);
			thestack.push(v);
		}
	}
	
	public static void main(String[] args) {
		GraphD g = new GraphD();
		g.addVertex("A");
        g.addVertex("B");
        g.addVertex("C");
        g.addVertex("D");
        g.addVertex("E");

        g.addVertexEdge(0, 1, 5);
        g.addVertexEdge(0, 3, 5);
        g.addVertexEdge(0, 4, 7);
        
        g.addVertexEdge(1, 2, 4);
        
        g.addVertexEdge(2, 3, 8);
        g.addVertexEdge(2, 4, 2);
  
        g.addVertexEdge(3, 2, 8);
        
        g.addVertexEdge(4, 1, 3);
        
        g.dfs();
	}
}
