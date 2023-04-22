import java.util.Scanner;
public class NumberofWays{
    
    public static int noOfways(String words[], String target){
        Integer[][]dp=new Integer[words[0].length()][target.length()];
        return solve(words,target,0,0,dp);
    }
    public static int solve(String[]words, String target, int j, int k, Integer[][]dp){
        if(k==target.length()){
            return 1;
        }
        if(j>=words[0].length() ||  words[0].length()-j< target.length()-k){
            return 0;
        }
        if(dp[j][k]!=null){
            return dp[j][k];
        }
        int mod=1000000007;
        long take=0;
        for(int x=0;x<words.length;x++){
            if(words[x].charAt(j)==target.charAt(k)){
                take+=solve(words,target,j+1,k+1,dp);
                take%=mod;
            }  
        }
        long notTake=solve(words,target,j+1,k,dp);
        notTake%=mod;
        return dp[j][k]=(int)(take+notTake)%mod;
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.print("Enter the target string");
        String target=s.nextLine();
        int n=s.nextInt();
        String words[]=new String[n]; 
        System.out.print("Enter the words into the string");
        for(int i=0;i<n;i++){
         words[i]=s.nextLine();
        }
        int ans=noOfways(words, target);
        System.out.print(ans); 
     }
    
}
