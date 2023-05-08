
import java.util.Scanner;
import java.util.Stack;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
    }
}
public class pallindromicList {
    public static Node CreateList(){
        Scanner s=new Scanner(System.in);
        System.out.print("Enter the datan in the list ");
        int data=s.nextInt();
        Node head=null, tail=null;
        while(data!=-1){
            Node currentNode=new Node(data);
            if(head==null){
                head=currentNode;
                tail=currentNode;
            }else{
                tail.next=currentNode;
                tail=currentNode;
            }
            data=s.nextInt();
        }
        return head;
    }
    public static void PrintThelist(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }

    public static boolean isPallindromicList(Node head){
        Node temp=head;
        Stack<Integer>stack=new Stack<>();
        while(temp!=null){
            stack.push(temp.data);
            temp=temp.next;
        }
        temp=head;
        while(temp!=null){
            if(temp.data!=stack.peek()){
                return false;
            }
            temp=temp.next;
            stack.pop();
            
        }
        return true;
    }
   public static void main(String[] args) {
    Node head=CreateList();
    PrintThelist(head);
     Node head2=move(head);
     PrintThelist(head2);
   } 
}

