import java.util.Scanner;
public class equillibriumPoint {

    public static int equillibriumIndex(long arr[], int n){
        long []leftSum=new long[n];
        long []rightSum=new long[n];
        long leftS=0;
        for(int i=0;i<n;i++){
            leftSum[i]=leftS;
            leftS+=arr[i];
        }
        long rightS=0;
        for(int i=n-1;i>=0;i--){
            rightSum[i]=rightS;
            rightS+=arr[i];
        }
        int ans=-1;
        for(int i=0;i<n;i++){
            if(leftSum[i]==rightSum[i]){
                ans=i+1;
                break;
            }
        }
        return ans;

    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.print("Enter the size of the array ");
        int n=s.nextInt();
        long arr[]=new long[n];
        for(int i=0;i<n;i++){
            arr[i]=s.nextLong(); 
        }
        int ans=equillibriumIndex(arr, n);
        System.out.println(ans);
    }
    
}
