import java.util.Scanner;

class BinaryTree<T>{
    T data;
    BinaryTree<T> right,left;
    BinaryTree(T data){
        this.data=data;
    }
}
public class PrintTreeRec {
    public static void PrintTree(BinaryTree<Integer> root){
        if(root==null){
            return;
        } 
        System.out.print(root.data+" ");
        PrintTree(root.left);
        PrintTree(root.right);  
    }
    public static void main(String[] args) {
        BinaryTree<Integer>root=new BinaryTree<Integer>(1);
        BinaryTree<Integer>rootright=new BinaryTree<Integer>(2);
        BinaryTree<Integer>rootLeft=new BinaryTree<Integer>(3);
        root.left=rootLeft;
        root.right=rootright;
        BinaryTree<Integer>left1=new BinaryTree<Integer>(4);
        BinaryTree<Integer>right1=new BinaryTree<Integer>(5);
        rootLeft.left=left1;
        rootright.right=right1;
        PrintTree(root);
        
    }
    
}
