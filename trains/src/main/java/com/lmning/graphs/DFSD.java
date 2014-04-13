package com.lmning.graphs;

public class DFSD {
    public static void main(String[] args) {
        GraphD g = new GraphD();
        g.addVerts("A");
        g.addVerts("B");
        g.addVerts("C");
        g.addVerts("D");
        g.addVerts("E");
        g.addVerts("F");
        g.addVerts("G");

        g.addEdge(0, 1, 1);
        g.addEdge(0, 2, 1);
        g.addEdge(0, 3, 1);
        g.addEdge(1, 4, 1);
        g.addEdge(1, 5, 1);
        g.addEdge(3, 6, 1);
  
        g.addEdge(4, 5, 1);
        g.addEdge(2, 6, 1);

         g.dfs();
        // g.bfs();
       // g.mst();
    }

}
