package com.lmning.graphs;

public class FLOYD {
    public static void main(String[] args) {
        GraphD g = new GraphD();
        
        g.addVerts("A");
        g.addVerts("B");
        g.addVerts("C");
        g.addVerts("D");
        g.addVerts("E");
        
        g.addEdge(0,1,50);
        g.addEdge(0,3,80);
        g.addEdge(1,2,60);
        g.addEdge(1,3,90);
        g.addEdge(2,4,40);
        g.addEdge(3,4,70);
        g.addEdge(3,2,20);
        g.addEdge(4,1,50);
        
        g.topo();
    }

}
