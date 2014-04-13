package com.trains.search;

import java.awt.geom.Path2D;

public class TrainsSearch {

    private int[][] map = { {-1, 5, -1, 5, 7}, {-1, -1, 4, -1, -1}, {-1, -1, -1, 8, 2}, {-1, -1, 8, -1, 6},
            {-1, 3, -1, -1, -1},};

    public void dfs(String end, String path, int maxLength) {
        if (path.length() - 1 > maxLength)
            return;
        if (path.length() > 1 && path.endsWith(path)) {
            System.out.println(path + ", " + path.length());
        }
        char lastChar = path.charAt(path.length() - 1);
        int lastNodeIndex = lastChar - 'A';

        for (int i = 0; i < map[lastNodeIndex].length; i++) {
            char newChar = (char) (i + 'A');
            if (map[lastNodeIndex][i] > 0) {
                dfs(end, path + newChar, maxLength);
            }
        }
    }
    
 // used to record the trip round count
    public int tripCount = 0;
    
    /***
     * 
     * @param end , the end node. if we reach it we found a path
     * @param path , the current path we already have 
     * @param maxLength, the maximum stops
     */
    public void dfs1(String end, String path, int maxLength)
    {
        // this is for debug and trace
        // System.out.println(";; " + path);
        
        // if the path reach the maximum stops, then cancel search
        if (path.length() - 1 > maxLength) return;
        
        // check if we have reach the "end" node
        if ( path.length() > 1 && path.endsWith(end) ) {
            System.out.println(path + ", " + tripCount);
            tripCount ++;
        }
        
        // caculate the lastest node index in map
        char lastChar = path.charAt(path.length()-1);
        int lastNodeIndex = lastChar - 'A';
        
        // loop all nodes in map which connected to lastNode, and try it
        for (int i = 0; i < map[lastNodeIndex].length; i++) {
            char newChar = (char) (i + 'A');
            if (map[lastNodeIndex][i] > 0) {
                dfs(end, path + newChar, maxLength);
            }
        }
    }

    public static void main(String[] args) {
        TrainsSearch t = new TrainsSearch();
        t.dfs1("C", "C", 3);
    }

}
