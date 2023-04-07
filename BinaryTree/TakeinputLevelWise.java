
import java.security.Permission;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//@ author rajnish203
class BinaryTree<T>{
    T data;
    BinaryTree<T> left, right;
    BinaryTree(T data){
        this.data=data;
    }
}


public class TakeinputLevelWise {
    public static void PrintTree(BinaryTree<Integer>root){
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



    public static BinaryTree<Integer> input(){
        System.out.print("Enter the root data");
        Scanner s=new Scanner(System.in);
        int data=s.nextInt();
        if(data==-1){
            return null;
        }
        BinaryTree<Integer> root=new BinaryTree<>(data);
        Queue<BinaryTree<Integer>>pendinNode=new LinkedList<>();
        pendinNode.add(root);
        while(!pendinNode.isEmpty()){
            BinaryTree<Integer> currentNode=pendinNode.poll();
            System.out.print("Enter the leftChild of "+ currentNode.data);
            int left=s.nextInt();
            if(left!=-1){
                BinaryTree<Integer> leftChild=new BinaryTree<>(left);
                currentNode.left=leftChild;
                pendinNode.add(leftChild);
            }
            System.out.print("Enter the rightChild of "+ currentNode.data);
            int right=s.nextInt();
            if(right!=-1){
                BinaryTree<Integer> rightChild=new BinaryTree<>(right);
                currentNode.right=rightChild;
                pendinNode.add(rightChild);
            }
        }
        return root;
    }



    public static void main(String[] args) {
        BinaryTree<Integer> root=input();
        PrintTree(root);
    }
}
