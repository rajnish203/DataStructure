import java.util.Stack;

public class QuickLeftRotaion{
    public static void rotate(int a[], int k){
        Stack<Integer> s=new Stack<>();
        int i=0;
        for(i=0;i<k;i++){
            s.push(a[i]);
        }
        System.out.print(s);
        int index=i;
        while(!s.isEmpty()){
            int element=s.pop();
            System.out.print(element);
            a[index++]=element;
        }
        System.out.println();
        for(int element:a){
            System.out.print(element);
        }
    }
    public static void main(String args[]){
        int a[]={1,2,3,4,5,6,7};
        int k=2;
        rotate(a, k);
    }
}