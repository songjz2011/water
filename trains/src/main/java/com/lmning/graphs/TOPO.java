package com.lmning.graphs;

public class TOPO {
    /**
     * @param args
     */
    public static void main(String[] args) {
        GraphD g = new GraphD();
        /*g.addVerts("A");
        g.addVerts("B");
        g.addVerts("C");
        g.addVerts("D");
        g.addVerts("E");
        g.addVerts("F");
        
        g.addEdge(0,2);
        g.addEdge(0,3);
        g.addEdge(1,4);
        g.addEdge(3,5);
        g.addEdge(2,5);
        g.addEdge(4,5);*/
        
        g.addVerts("A");
        g.addVerts("B");
        g.addVerts("C");
        g.addVerts("D");
        g.addVerts("E");
        g.addVerts("F");
        g.addVerts("G");
        g.addVerts("H");
        g.addVerts("I");
        
        g.addEdge(0,2,1);
        g.addEdge(0,1,1);
        g.addEdge(1,3,1);
        g.addEdge(2,3,1);
        g.addEdge(3,4,1);
        g.addEdge(3,6,1);
        g.addEdge(4,7,1);
        g.addEdge(5,6,1);
        //g.addEdge(6,7,1);
        g.addEdge(8,2,1);
        
        
        
        g.print();
        g.topo();
        
        
    }

}
