package com.lmning.graphs;

/**
 * 基于邻接矩阵的有向图
 * @author lmning
 *Feb 14, 2009 6:37:28 AM
 */
public class GraphD {
    private final int MAX_VERTS = 20;    //最大顶点数
    private Vertex[] vertexList;         //图中的所有顶点
    private int[][] adjmat ;             //邻接矩阵
    private int nVerts;                  //实际顶点数
    private Stack thestack;              //深度搜索用
    private Queue thequeue;              //广度搜索用
    private String sortedArray[];          //拓扑排序用
    
    public GraphD(){
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
        sortedArray = new String[MAX_VERTS];
    }
    //添加定点 
    public void addVerts(String label){
        vertexList[nVerts++]=new Vertex(label);
    }
    //添加边
    public void addEdge(int start,int end, int weight){
        adjmat[start][end]=weight;
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
        //重置邻接矩阵
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
        //重置邻接矩阵 
        for(int i =0;i<nVerts;i++){
            vertexList[i].wasvisited=false;
        }
    }
    //最小生成树 ,只是众多最小生成树的一种可能
    public void mst(){
        vertexList[0].wasvisited=true;
        thestack.push(0);
        StringBuffer path = new StringBuffer(); //path用来存储最小生成树的边
        
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
        //重置邻接矩阵 
        for(int i =0;i<nVerts;i++){
            vertexList[i].wasvisited=false;
        }
    }
    //拓扑排序
    public void topo(){
        int orig_nverts = nVerts;
        while(nVerts>0){
            int v = noSuccessors();
            if(v==-1){
                System.out.println("ERROR: Graph has cycles");
                return ;
            }
            sortedArray[nVerts-1]=vertexList[v].label;
            //删除没有后继的节点
            deleteVertex(v);
        }
        //输出结果
        System.out.println("拓扑排序输出：");
        for(int i =0;i<orig_nverts;i++){
            System.out.print(sortedArray[i]);
        }
        System.out.println();
    }
    //返回一个没有后继的顶点 
    public int noSuccessors(){
        for(int row =0;row<nVerts;row++){
            boolean hassuccessor = false;
            for(int col =0;col<nVerts;col++){
                if(adjmat[row][col]>0){
                    hassuccessor=true;
                    break;
                }
            }
            if(!hassuccessor){
                return row;
            }
        }
        return -1;
    }
    //删除没有后继的节点,并修改邻接矩阵
    public void deleteVertex(int v){
        if(v!=nVerts-1){                   //不是最后一个节点才做如下操作
        for(int i = v;i<nVerts-1;i++){     //从数组中删除已经拓扑排好序的节点 
            vertexList[i]=vertexList[i+1];
        }
        for(int i=v;i<nVerts-1;i++){       //修改邻接矩阵行
            moverowup(i,nVerts);
        }
        for(int i=v;i<nVerts-1;i++){       //修改邻接矩阵列 
            movecolleft(i,nVerts-1);
        }
        }   
        nVerts--;
    }
    //把删除顶点下的元素上移一行
    public void moverowup(int row,int n){
        for(int col =0;col<n;col++){
            adjmat[row][col] = adjmat[row+1][col];
        }
    }
    //把删除顶点右的元素左移一列
    public void movecolleft(int col,int n){
        for(int row =0;row<n;row++){
            adjmat[row][col] = adjmat[row][col+1];
        }
    }
    
    //输出邻接矩阵
    public void print(){
        System.out.println("图的邻接矩阵:");
        System.out.print("    ");
        for(int i =0;i<nVerts;i++){
            System.out.print("  "+vertexList[i].label);
        }
        System.out.println();
        for(int i =0;i<nVerts;i++){
            System.out.print(vertexList[i].label+"  |  ");
            for(int j=0;j<nVerts;j++){
                System.out.print(adjmat[i][j]+"  ");
            }
            System.out.println();
        }
    }
}
