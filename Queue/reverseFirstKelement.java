import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import javax.management.QueryExp;

public class reverseFirstKelement{
    public static Queue<Integer> reverse (Queue<Integer> que,int k){
        if(que.size()>k){
            k=k%que.size();
        }
        if(k==0 || k==1){
            return que;
        }
        reverseQue(que, k);
        for(int i=0;i<que.size();i++){
            que.add(que.remove());
        }
        return que;
    }
    public static void reverseQue(Queue<Integer> que, int k){
        if(que.size()==0 || que.size()==1 || k==0){
            return;
        }
        int temp=que.remove();reverse(que, k-1);
        que.add(temp);
    }
    public static void main(String[] args) {
        Queue<Integer> que=new LinkedList<>();
        Scanner s=new Scanner(System.in);
        int data=s.nextInt();
        int k=3;
        while(data!=-1){
            que.add(data);
            data=s.nextInt();
        }
        System.out.print(reverse(que, k));
        
    }
}