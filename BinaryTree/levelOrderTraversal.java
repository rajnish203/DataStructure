
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node <T>{
    T data;
    Node<Integer> left, right;
    Node(T data){
        this.data=data;
    }
 }

public class levelOrderTraversal {
    public static void PrintLevelOrder(Node<Integer> root){
        if(root==null){
            return;
        }
        Queue<Node<Integer>>pending=new LinkedList<>(null);
        pending.add(root);
        while(!pending.isEmpty()){
            Node<Integer>cur=pending.poll();
            System.out.print(cur.data+" ");
        }
    }

    public static Node<Integer> TakeInpput(boolean isRoot, int parentData, boolean isleft){
        if(isRoot){
            System.out.print("Enter the rootData: ");
        }else{
            if(isleft){
                System.out.print("Enter the leftchild of "+parentData);
            }else{
                System.out.print("Enter the rightChild of "+ parentData);
            }
        }
        Scanner s=new Scanner(System.in);
        int rootData=s.nextInt();
        if(rootData==-1){
            return null;
        }
        Node<Integer> root=new Node<>(rootData);
        Node<Integer> leftTree=TakeInpput(false, root.data, true);
        Node<Integer> rightTree=TakeInpput(false, root.data, false);
        root.left=leftTree;
        root.right=rightTree;

        return root;

    }
  
    public static void PrintTree(Node<Integer> root){
        if(root==null){
            return;
        }
        System.out.print(root.data+": ");
        if(root.left!=null){
            System.out.print("L"+root.left.data+" ,");
        }
        if(root.right!=null){
            System.out.print("R"+ root.right.data);
        }
        System.out.println();

        PrintTree(root.left);
        PrintTree(root.right);

    }
    public static void main(String[] args) {

        Node<Integer> root= TakeInpput(true, 0, true);
        
        PrintTree(root);

    }
}
