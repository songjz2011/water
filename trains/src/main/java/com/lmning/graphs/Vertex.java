package com.lmning.graphs;
/**
 * 顶点对象
 * @author lmning
 *Feb 14, 2009 9:07:55 AM
 */
public class Vertex {
    public String label;
    public boolean wasvisited;
    
    public Vertex(String label) {
        this.label = label;
        this.wasvisited = false;
    }

    public String getLabel() {
        return label;
    }
}
