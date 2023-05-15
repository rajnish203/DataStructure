import java.util.Scanner;

import javax.swing.plaf.synth.SynthStyle;

class ListNode{
    int data;
    ListNode next;
    ListNode(int data){
        this.data=data;
    }
}
public class swap1721 {
    public static ListNode CreateList(){
        Scanner s=new Scanner(System.in);
        int data=s.nextInt();
        ListNode head=null, tail=null;
        while(data!=-1){
            ListNode curNode=new ListNode(data);
            if(head==null){
                head=curNode;
                tail=curNode;
            }else{
                tail.next=curNode;
                tail=curNode;
            }
            data=s.nextInt();
        }
        return head;
    }
    public static ListNode swapListNode(ListNode head, int k){
        // find the size of the list
        ListNode temp=head;
        int size=0;
        while(temp!=null){
            size++;
            temp=temp.next;
        }
        temp=head;

        // push all the of list into the array
        int a[]=new int[size];
        int index=0;
        while(temp!=null){
            a[index++]=temp.data;
            temp=temp.next;
        }

        // Now perform the swapping in the array
        int val=a[a.length-k];
        a[a.length-k]=a[k-1];
        a[k-1]=val;


        // now again make the list and return the head of the list 
        ListNode head2=null, tail=null;
        int i=0;
        while(i<a.length){
            ListNode curNode=new ListNode(a[i++]);
            if(head2==null){
                head2=curNode;
                tail=curNode;
            }else{
                tail.next=curNode;
                tail=curNode;
            }
        }
        return head2;

    }
    public static void PrintList(ListNode head){
        ListNode temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
    public static void main(String[] args) {
        ListNode head=CreateList();
        ListNode head2=swapListNode(head, 2);
       PrintList(head2);
    }
}
