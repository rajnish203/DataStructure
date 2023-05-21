import java.util.Scanner;

class Edge{
    int v1;
    int v2;
    int weight;
    Edge(int v1, int v2, int weight){
        this.v1=v1;
        this.v2=v2;
        this.weight=weight;
    }
}
public class prims {

    public static void primsFunc(int adj[][], int n){
        boolean visited[]=new boolean[n];
        int parent[]=new int[n];
        int weight[]=new int[n];

        // set source parent to 
        parent[0]=-1;
        weight[0]=0;
        for(int i=1;i<n;i++){
            weight[i]=Integer.MAX_VALUE;
        }
        for(int i=0;i<n;i++){
            int minVertex=findminVertex(visited, weight);
            visited[minVertex]=true;

            // explore the neighbours of the minvertex
            for(int j=0;j<n;j++){
                if(adj[minVertex][j]!=0 && !visited[j]){
                    if(weight[j]>adj[minVertex][j]){
                        weight[j]=adj[minVertex][j];
                        parent[j]=minVertex;
                    }
                }
            }
        }

    }
    private static int findminVertex(boolean[] visited, int[] weight) {
        int minvertex=-1;
        for(int i=0;i<visited.length;i++){
            if(!visited[i]&& weight[i]<weight[minvertex]){
                minvertex=i;
            }
        }
        return minvertex;
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int e=s.nextInt();
        int adj[][]=new int[n][n];
        for(int i=0;i<e;i++){
            int v1=s.nextInt();
            int v2=s.nextInt();
            int weight=s.nextInt();
            adj[v1][v2]=weight;
            adj[v2][v1]=weight;
        }
    }
}
