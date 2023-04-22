public class regularExp {
    public static boolean isMatch(String str, String p){
        boolean [][]dp=new boolean[ p.length()+1][str.length()+1];
       
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(i==0 && j==0){
                    dp[i][j]=true;
                }else if(i==0){
                    dp[i][j]=false;
                }else if(j==0){
                    char ch=p.charAt(i-1);
                    if(ch=='*'){
                        dp[i][j]=dp[i-2][j];
                    }else{
                        dp[i][j]=false;
                    }
                }else{
                    char strc=str.charAt(j-1);
                    char patc=p.charAt(i-1);
                    if(patc=='*'){
                        dp[i][j]=dp[i-2][j];
                        char secndLastpat=p.charAt(i-2);
                        if(secndLastpat=='.'|| secndLastpat==strc){
                            dp[i][j]=dp[i][j] || dp[i][j-1];
                        }
                    }else if(patc=='.'){
                        dp[i][j]=dp[i-1][j-1];
                    }else if(patc==strc){
                        dp[i][j]=dp[i-1][j-1];
                    }else{
                        dp[i][j]=false;
                    }
                }
            }
        }
        return dp[p.length()][str.length()];
    }
    public static void main(String[] args) {
        String str= "aa";
        String p="a*";
        boolean ans =isMatch(str, p);
        System.out.print(ans);
    }
    
}
