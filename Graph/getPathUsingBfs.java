import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class getPathUsingBfs {
    public static ArrayList<Integer> getPath(int adj[][], int startVertex, int destination){
        boolean visited[]=new boolean[adj.length];
        Queue<Integer>queue=new LinkedList<>();
        HashMap<Integer, Integer>map=new HashMap<>();
        map.put(startVertex,-1);
        visited[startVertex]=true;
        queue.add(startVertex);
        boolean Pathfound=false;
        while(!queue.isEmpty()){
            int CurVertex=queue.poll();
            for(int i=0;i<adj.length;i++){
                if(adj[CurVertex][i]==1 && !visited[i]){
                    queue.add(i);
                    visited[i]=true;
                    map.put(i,CurVertex);
                    if(i==destination){
                        Pathfound=true;
                        break;
                    }
                }
            }
        }
        if(Pathfound){
            ArrayList<Integer>Path=new ArrayList<>();
            int CurVertex=destination;
           while(CurVertex!=-1){
            Path.add(CurVertex);
            int parent=map.get(CurVertex);
            CurVertex=parent;
           }
           return Path;

        }else{
            return null;
        }
    }
    public static int [][] createGraph(){
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
        s.close();
        return adj;
    }
    
    public static void main(String[] args) {
        int adj[][]=createGraph();
        ArrayList<Integer>path=getPath(adj, 0, 2);
        for(Integer i:path){
            System.out.print(i+" ");
        }
    }
    
}
