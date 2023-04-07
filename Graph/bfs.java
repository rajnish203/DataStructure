import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bfs {
    public static void bfsExecute (int adj[][]){
        boolean visited[]=new boolean[adj.length];
        for(int i=0;i<adj.length;i++){
            if(!visited[i]){
            bfsHelper(adj, i, visited);
            }
        }
        // }
        // bfsHelper(adj, 0, visited);        // if Graph has no disconencted component
    }
    public static void bfsHelper(int adj[][], int startVertex, boolean visited[]){
        Queue<Integer> queue=new LinkedList<>();
        visited[startVertex]=true;
        queue.add(startVertex);
        while(!queue.isEmpty()){
            int CurVertex=queue.poll();
            System.out.print(CurVertex+" ");
            for(int i=0;i<adj.length;i++){
                if(adj[CurVertex][i]==1 && !visited[i]){
                    queue.add(i);
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
        bfsExecute(adj);
    }
}
