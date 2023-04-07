
import java.util.Scanner;;

class implement{
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
        for(int i=0;i<adj.length;i++){
            for(int j=0;j<adj[0].length;j++){
                System.out.print(adj[i][j]+" ");
            }
            System.out.println();
        }
      }
}