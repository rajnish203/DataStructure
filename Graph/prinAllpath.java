
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.List;
public class prinAllpath {
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<List<Integer>> q = new LinkedList<>();
        q.offer(new ArrayList<>(Arrays.asList(0)));

        while (!q.isEmpty()) {
            List<Integer> path = q.poll();
            int lastVertex = path.get(path.size() - 1);
            if (lastVertex == graph.length - 1) {
                ans.add(path);
            } else {
                for (int x : graph[lastVertex]) {
                    List<Integer> newPath = new ArrayList<>(path);
                    newPath.add(x);
                    q.offer(newPath);
                }
            }
        }

        return ans;
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
        int graph[][]=CreateGraph();
        List<List<Integer>>ans=allPathsSourceTarget(graph);
        System.out.print(ans);
    }
    
}
