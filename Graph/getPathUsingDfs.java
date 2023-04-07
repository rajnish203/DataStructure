import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class getPathUsingDfs {
    public static ArrayList<Integer> path (int adj[][], int startVertex, int destination){
        boolean visited[]=new boolean[adj.length];
        return getPath(adj, startVertex, destination, visited);
    }
    public static ArrayList<Integer> getPath(int adj[][], int startVertex, int destination, boolean[]visited){ 
        if(startVertex==destination) 
        {
            ArrayList<Integer> ans=new ArrayList<>();
            visited[startVertex]=true;
            ans.add(startVertex);
            return ans;
        }
        visited[startVertex]=true;
        for(int i=0;i<adj.length;i++)
        {
            if(adj[startVertex][i]==1 && !visited[i])
            {   
                ArrayList<Integer> arr=getPath(adj,i,destination, visited); 
                if(arr!=null)
                {
                    arr.add(startVertex);

                    return arr;
                }
            }
        }
        //if no naswer is found return null 
        return new ArrayList<>();
    }
    public static int [][] createGraph(){
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
        int adj[][]=createGraph();
        ArrayList<Integer>path=path(adj, 0, 2);
        for(Integer i:path){
            System.out.print(i+" ");
        }
        System.out.print(path);
    }
}
