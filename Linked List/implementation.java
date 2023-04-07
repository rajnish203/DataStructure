import java.util.Scanner;

import javax.security.auth.login.CredentialException;

import java.util.Scanner;
class Node <T>{
    T data;
    Node <T>next;
    Node(T data){
        this.data=data;
    }
}
public class implementation{
    public static Node<Integer> createLinkedList(){
        Node<Integer>head=null;
        Node<Integer>tail=null;
        Scanner s=new Scanner(System.in);
        System.out.print("Enter the data in the list");
        int data=s.nextInt();
        while(data!=-1){
            Node<Integer>immediate=new Node<>(data);
            if(head==null){
                head=immediate;
                tail=immediate;
            }else{
                tail.next=immediate;
                tail=tail.next;
            }
            data=s.nextInt();
        }
        s.close();
        return head;
    }
    public static Node<Integer> insertAtFirst(Node<Integer>head){
        Scanner s =new Scanner(System.in);
        if(head==null){
            System.out.print("Enter the data to be inserted\n");
            int data=s.nextInt();
            Node<Integer>newNode=new Node<>(data);
            newNode.next=null;
            return newNode;
        }
        System.out.print("Enter the data to be inserted\n");
        int data=s.nextInt();
        Node<Integer> newNode=new Node<>(data);
        newNode.next=head;
        head=newNode;
        return head;
    }
    // public static insert(Node<Integer>head, int pos, int data){
    //     // insert at 1st pos
    // }
    public static void PrintList(Node<Integer>head){
        if(head==null){
            return;
        }
        System.out.print(head.data+" ");
        PrintList(head.next);
    }
    public static void main(String[] args) {
      Node<Integer>head=createLinkedList();
      PrintList(head);
      Node<Integer>head2=insertAtFirst(head);
      PrintList(head2);
    }

}