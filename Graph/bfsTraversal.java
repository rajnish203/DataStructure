package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bfsTraversal {
    public static void bfs(int adj[][]){
        boolean visited[]=new boolean[adj.length];
        for(int i=0;i<adj.length;i++){
            if(!visited[i]){
                  bfsHelper(adj,i,visited);
            }
           }
    }
    public static void bfsHelper(int adj[][], int startVertex, boolean visited[]){
        visited[startVertex]=true;
        Queue<Integer>pending=new LinkedList<>();
        pending.add(startVertex);
        while(!pending.isEmpty()){
            int cur=pending.poll();
            System.out.print(cur+" ");
            for(int i=0;i<adj.length;i++){
                if(adj[cur][i]==1 && visited[i]==false){
                    pending.add(i);
                    visited[i]=true;
                }
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
        bfs(adj);
    }
    
}
