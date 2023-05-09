import java.util.ArrayList;
public class AllPossibleBinaryString {
    public static int countStrings(long N) {
        int count=0;
       ArrayList<String> list=new ArrayList<>();
       countStringHelper("",N, list);
       for(int i=0;i<list.size();i++){
           String s=list.get(i);
           char [] a=s.toCharArray();
           boolean ans=checkTwoConsecutive(a);
           if(ans){
               count++;
           }
       }
       return count;
    }
    private static boolean checkTwoConsecutive(char arr[]){
        char preElement='a';
        for( char element:arr){
            if(element=='1' && preElement=='1'){
                return false;
            }else{
                preElement=element;
            }
        }
        return true;
    }
    public static ArrayList<String> countStringHelper(String s,long N, ArrayList<String> list){
        if(N==0){
            list.add(s);
            return list;
        }else{
            countStringHelper(s+"0",N-1, list);
          countStringHelper(s+"1",N-1, list);
        }
        return list;
    }  
    // optimize code for the above Question
    static int mod= 1000000007;
    public static int countStrings2(long N) {
        return fib(N+2);
    }
    static int fib(long n) {
        long F[][] = new long[][]{{1,1},{1,0}};
        if (n == 0) return 0;
        power(F, n-1);
        return (int)F[0][0];
    }
    static void power(long F[][], long n) {
        if( n == 0 || n == 1) return;
        long M[][] = new long[][]{{1,1},{1,0}};
        power(F, n/2);
        multiply(F, F);
        if (n%2 != 0) multiply(F, M);
    }
    static void multiply(long F[][], long M[][]) {
        long x =  ((F[0][0]*M[0][0])%mod + (F[0][1]*M[1][0])%mod)%mod;
        long y =  ((F[0][0]*M[0][1])%mod + (F[0][1]*M[1][1])%mod)%mod;
        long z =  ((F[1][0]*M[0][0])%mod + (F[1][1]*M[1][0])%mod)%mod;
        long w =  ((F[1][0]*M[0][1])%mod + (F[1][1]*M[1][1])%mod)%mod;
        F[0][0] = x;
        F[0][1] = y;
        F[1][0] = z;
        F[1][1] = w;
    }
    public static void main(String[] args) {
        long n1=2;
        System.out.print(countStrings(n1));
        long n=3;
        System.out.print(countStrings2(n));
    }
}
