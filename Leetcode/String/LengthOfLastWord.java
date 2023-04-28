
import java.util.Scanner;

public class LengthOfLastWord {
    public static int length(String s){
        int count=0;
        if(s.length()==0){
            return 0;
        }
        int i=0;
        while(i<s.length()){
            if(s.charAt(i)==' ' && i<=s.length()-1){
                count=0;
                i++;
            }else{
                i++;
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.print("Enter the string");
        String str=s.nextLine();
        int ans =length(str);
        System.out.print(ans);
        s.close();
    }
}
