import java.lang.Thread.State;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import javax.swing.border.LineBorder;
import javax.swing.text.html.StyleSheet;

public class isConnectedUsingBfs {
    public static int [][] CreateGraph(){
        Scanner s=new Scanner(System.in);
        int v=s.nextInt();
        int e=s.nextInt();
        int adj[][]=new int[v][v];
        for(int i=0;i<e;i++){
            int v1=s.nextInt();
            int v2=s.nextInt();
            adj[v1][v2]=1;
            adj[v2][v1]=1;
        }
        return adj;
     }

     public static boolean  bfs(int graph[][]) {
        boolean visited[]=new boolean[graph.length];
        int startVertex=0;
        Queue<Integer>pending=new LinkedList<>();
        visited[startVertex]=true;
        pending.add(startVertex);
        while(!pending.isEmpty()){
            int curr=pending.poll();
            for(int i=0;i<graph.length;i++){
                if(graph[curr][i]==1 && !visited[i]){
                    pending.add(i);
                    visited[i]=true;
                }
            }
        }
        for(boolean i: visited){
            if(!i){
                return false;
            }
        }
        return true;

     }
    public static void main(String[] args) {
    int graph[][]=CreateGraph();
    System.out.print(bfs(graph));
    }
    
}
