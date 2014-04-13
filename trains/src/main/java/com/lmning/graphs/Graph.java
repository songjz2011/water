package com.lmning.graphs;

/**
 * 基于邻接矩阵的无向图
 * @author lmning
 *Feb 14, 2009 6:37:28 AM
 */
public class Graph {
    private final int MAX_VERTS = 20;
    private Vertex[] vertexList;
    private int[][] adjmat ;
    private int nVerts;
    private Stack thestack;
    private Queue thequeue;
    
    public Graph(){
        //图顶点数组
        vertexList = new Vertex[MAX_VERTS];
        //邻接矩阵
        adjmat = new int[MAX_VERTS][MAX_VERTS];
        //当前节点 
        nVerts = 0;
        //初始化邻接矩阵
        for(int i =0;i<MAX_VERTS;i++)
            for(int j =0;j<MAX_VERTS;j++){
                adjmat[i][j]=0;
            }   
        thestack = new Stack();
        thequeue = new Queue();
    }
    //添加定点 
    public void addVerts(String label){
        vertexList[nVerts++]=new Vertex(label);
    }
    //添加边
    public void addEdge(int start,int end){
        adjmat[start][end]=1;
        adjmat[end][start]=1;
    }
    //显示v节点
    public void displayVertex(int v){
        System.out.println(vertexList[v].label);
    }
    //查看节点v的邻接点是否已经全部访问
    public int getAdjUnvisitedVertex(int v){
        for(int i = 1;i<nVerts;i++){
            if(adjmat[v][i]==1&&vertexList[i].wasvisited==false){
                return i;
            }
        }
        return -1;
    }
    //深度遍历
    public void dfs(){
        vertexList[0].wasvisited=true;
        displayVertex(0);
        thestack.push(0);
        
        while(!thestack.isEmpty()){
            int v = getAdjUnvisitedVertex(thestack.peek());
            if(v==-1){
                thestack.pop();
            }else{
                vertexList[v].wasvisited=true;
                displayVertex(v);
                thestack.push(v);
            }
        }
        //重置
        for(int i =0;i<nVerts;i++){
            vertexList[i].wasvisited=false;
        }
    }
    //广度遍历
    public void bfs(){
        vertexList[0].wasvisited=true;
        displayVertex(0);
        thequeue.insert(0);
        int v2;
        
        while(!thequeue.isEmpty()){
            int v = thequeue.remove();
            while((v2=getAdjUnvisitedVertex(v))!=-1){
                vertexList[v2].wasvisited=true;
                displayVertex(v2);
                thequeue.insert(v2);
            }
        }
        for(int i =0;i<nVerts;i++){
            vertexList[i].wasvisited=false;
        }
    }
    //最小生成树 ,只是众多最小生成树的一种可能
    public void mst(){
        vertexList[0].wasvisited=true;
        thestack.push(0);
        StringBuffer path = new StringBuffer();
        
        while(!thestack.isEmpty()){
            int v = thestack.peek();
            if(getAdjUnvisitedVertex(v)==-1){
                thestack.pop();
            }else{
                int v2 = getAdjUnvisitedVertex(v);
                thestack.push(v2);
                vertexList[v2].wasvisited=true;
                path.append(vertexList[v].getLabel()).append(vertexList[v2].getLabel()).append("-->");
            }       
        }
        System.out.println(path.toString());
        //重置
        for(int i =0;i<nVerts;i++){
            vertexList[i].wasvisited=false;
        }
    }
}
