import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class hasPath {
    public static boolean isPathExist(int adj[][], int source, int destination){
        boolean visited[]=new boolean[adj.length];
        Queue<Integer>queue=new LinkedList<>();
        visited[source]=true;
        queue.add(source);
        while(!queue.isEmpty()){
            int CurVertex=queue.poll();
            for(int i=0;i<adj.length;i++){
                if(adj[CurVertex][i]==1 && !visited[i]){
                    if(i==destination){
                        return true;
                    }
                    queue.add(i);
                    visited[i]=true;
                }
            }
        }
        return false;
    }
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
    public static void main(String[] args) {
      int adj[][]=CreateGraph();
      boolean ans=isPathExist(adj, 0, 7)  ;
      System.out.print(ans);
    }
    
}
