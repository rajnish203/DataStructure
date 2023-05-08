import java.util.*;
import java.lang.*;
import java.io.*;
class GeekNewJob
 {
     
     public static void valid(String str){
         boolean isAnyUppercase=false;
         boolean isAnyLowerCase=false;
         boolean isAnyNumeric=false;
         
         for(int i=0;i<str.length();i++){
           char ch=str.charAt(i);
           if(Character.isLowerCase(ch)){
               isAnyLowerCase=true;
           }else if(Character.isUpperCase(ch)){
              isAnyUppercase=true; 
           }else if(Character.isDigit(ch)){
               isAnyNumeric=true;
           }
           
           if (isAnyLowerCase && isAnyUppercase && isAnyNumeric){
               break;
           }
         }
          if( isAnyLowerCase&& isAnyUppercase  && isAnyNumeric){
               System.out.println("YES");
           }else{
               System.out.println("NO");
           }
     }
	public static void main (String[] args)
	 {
	     Scanner s =new Scanner(System.in);
	     int n=s.nextInt();
	     for(int i=1;i<=n;i++){
	         String str=s.nextLine();
	         valid(str);
	     }
	 }
}