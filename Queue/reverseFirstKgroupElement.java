import java.util.Stack;

public class reverseFirstKgroupElement {
    public static void reverse(int a[], int k){
        Stack<Integer>stack=new Stack<>();
        int i=0;
        while(i<k){
            stack.push(a[i++]);  
        }
        int j=0;
        while(!stack.isEmpty()){
            a[j++]=stack.pop();
            System.out.println(a[j]);
        }
        printAr(a);
    }
    public static void printAr(int a[]){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
    public static void main(String[] args) {
       int a[]={1,2,3,4,5,6};
       int k=3;
       reverse(a, k);
    }
    
}
