package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HashAPath {
    public static boolean isPathExistHelper(int adj[][], int source, int Destination, boolean visited[]){
        if(source==Destination){
            return true;
        }
        visited[source]=true;
        Queue<Integer>pending=new LinkedList<>();
        pending.add(source);
        while(!pending.isEmpty()){
            source=pending.poll();
                for(int i=0;i<adj.length;i++){
                    if(adj[source][i]==1 && !visited[i]){
                        if(i==Destination){
                            return true;
                        }
                        pending.add(i);
                        visited[i]=true;
                    }
                }
           }
           return false;
     }
    
    public static boolean isPathExist(int adj[][], int source, int Destination){
        boolean visited[]=new boolean[adj.length];
        return isPathExistHelper(adj, source, Destination, visited);
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
        Scanner s=new Scanner(System.in);
        int source=s.nextInt();
        int Destination=s.nextInt();
        int adj[][]=CreateGraph();
        boolean ans=isPathExist(adj, source, Destination);
        System.out.print(ans);
    }
}
