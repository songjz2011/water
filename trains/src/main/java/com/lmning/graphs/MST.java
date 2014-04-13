package com.lmning.graphs;

public class MST {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Graph g = new Graph();
        g.addVerts("A");
        g.addVerts("B");
        g.addVerts("C");
        g.addVerts("D");
        g.addVerts("E");
        g.addVerts("F");
        g.addVerts("G");
        
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(0,3);
        g.addEdge(1,4);
        g.addEdge(1,5);
        g.addEdge(3,6);
        
        g.addEdge(4,5);
        g.addEdge(2,6);
        
        g.dfs();
        g.mst();

    }


}
