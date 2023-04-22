public class stair_case {
    public static long All_possible_Ways(int n){
        if(n==1 || n==0){
            return n;
        }
        if(n==2){
            return 2;
        }
        long dp[]=new long [n+1];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n=10;
        long ans=All_possible_Ways(n);
        System.out.print(ans);

    }
}
