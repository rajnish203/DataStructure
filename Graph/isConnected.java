public class isConnected {
    public static boolean helper(int graph[][],int startVertex, boolean visited[]){
        int count=0;
        visited[startVertex]=true;
        for(int i=0;i<graph.length;i++){
            if(graph[startVertex][i]==1 && !visited[i]){
                count++;
                helper(graph, startVertex, visited);
            }
        }
        if(count==graph.length){
            return true;
        }
        else{
            return false;
        }
    }
    public static boolean isConnectedGraph(int graph[][]){
        boolean visited[]=new boolean[graph.length];
        return helper(graph, 0, visited);
    }
    public static void main(String[] args) {
        
    }
    
}
