public class X_pattern{
     public static void main(String[] args) {
        int n=5;
        int m=2*n-1,k=1, flag=1;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=m;j++){
                if(i==j || j==2*n-i){
                    System.out.print(k);
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
            if(flag==1 &&k<n){
                k++;
            }else{
                flag=0;
                k--;
            }
        }
    }
}