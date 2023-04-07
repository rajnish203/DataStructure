package Graph;

import java.util.Scanner;

public class DfsForDisconnectedGraph {
    public static void dfs(int adj[][]){
        boolean visited[]=new boolean[adj.length];
        dfsHelper(adj, 0,  visited);
    }
    public static void dfsHelper(int adj[][], int startVertex, boolean visited[]){
        visited[startVertex]=true;
        System.out.print(startVertex+" ");
        for(int i=0;i<adj.length;i++){
            if(adj[startVertex][i]==1 && !visited[i]){
                dfsHelper(adj, i,visited);
            }
        }
    }
    public static int[][] CreateGraph(){
        Scanner s=new Scanner(System.in);
        int n =s.nextInt();
        int e=s.nextInt();
        int adj[][]=new int[n][n];
        for(int i=0;i<e;i++){
                int v1=s.nextInt();
                int v2=s.nextInt();
                adj[v1][v2]=1;
                adj[v2][v1]=1;
        }
        return adj;
    }
   public static void main(String[] args) {
    int adj[][]=CreateGraph();
    dfs(adj);
   } 
}
