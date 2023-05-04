import java.util.Scanner;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
    }
}
public class MakeLastToHead {
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

    public static Node move(Node head){
        Node temp=head;
        Node prev=head;
        while(temp.next.next!=null){
            temp=temp.next;
            prev=prev.next;
        }
        temp=temp.next;
        prev.next=null;
        temp.next=head;
        return temp;
    }
   public static void main(String[] args) {
    Node head=CreateList();
    PrintThelist(head);
     Node head2=move(head);
     PrintThelist(head2);
   } 
}
