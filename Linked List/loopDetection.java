import java.util.HashMap;
import java.util.Scanner;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
    }
}
public class loopDetection {
    public static void PrintThelist(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
    public static boolean detect(Node head){
        Node temp=head;
        HashMap<Node, Boolean>map=new HashMap<>();
        while(temp!=null){
            if(map.get(temp)==true){
                return true;
            }else{
                map.put(temp, true);
                temp=temp.next;
            }
        }
        return false;
    }
   public static void main(String[] args) {
    Node head=new Node(1);
    Node n1=new Node(2);
    Node n2=new Node(3);
    Node n4=new Node(4);
    Node n5=new Node(5);
    Node n6=new Node(6);
    Node n7=new Node(7);
    head.next=n1;
    n1.next=n2;
    n2.next=n4;n4.next=n5;
    n5.next=n6;
    n6.next=n7;n7.next=n4;
    boolean ans=detect(head);
    System.out.print(ans);
   } 
}

