import java.util.ArrayList;

public class PrintAllPermutation  {

    public static ArrayList<String> printAllP(String str){
        int n=str.length();
        int f=factorial(n);
        ArrayList<String>list=new ArrayList<>();
        for(int i=0;i<f;i++){
            int temp=i;String s2="";
            StringBuilder s=new StringBuilder(str);
            for(int div=n;div>=1;div--){
                int q=temp/div;
                int r=temp%div;
                s2=s2+s.charAt(r);
                s.deleteCharAt(r);
                temp=q;
            }
            list.add(s2);
            s2="";
        }
        return list;
    }
    public static int factorial(int n){
        int val=1;
        for(int i=2;i<=n;i++){
            val*=i;
        }
        return val;
    }
    public static int countString(ArrayList<String> list){
        int count= 0;
        for(int i=0;i<list.size();i++){
            String s=list.get(i);
            int n=s.length();
           for(int j=0;j<n;j++){
            if(s.charAt(j)== '1' && s.charAt(j+1)=='1'){
                return count;
            }
            else{
                if(j==n){
                    count++;
                }
            }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        String s="abc";
        System.out.print(printAllP(s));
    }
}
