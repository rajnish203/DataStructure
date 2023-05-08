import java.util.Scanner;
import java.util.ArrayList;
class BinaryTree<T>{
    T data;
    BinaryTree<T> left, right;
    BinaryTree(T data){
        this.data=data;
    }
}
public class rightView {
    public static ArrayList<Integer> RightView(BinaryTree<Integer> root){
        ArrayList<Integer> list=new ArrayList<>();
        left(root, 0, list);
        return list;
    }
    public static void left(BinaryTree<Integer> root, int depth, ArrayList<Integer> list){
        if(root==null){
            return;
        }
        if(list.size()==depth){
            list.add(root.data);
        }
        left(root.right, depth+1, list);
        left(root.left, depth+1, list);
    }
    public static void PrintTree(BinaryTree<Integer> root){
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
    public static BinaryTree<Integer> inputTree(boolean isRoot, int parentData, boolean isleft){
        if(isRoot){
            System.out.print("Enter the root data");
        }else{
            if(isleft){
                System.out.print("Enter the leftChild of : "+parentData);
            }else{
                System.out.print("Enter the rightChild of: "+ parentData);
            }
        }
        Scanner s=new Scanner(System.in);
        int data=s.nextInt();
        if(data==-1){
            return null;
        }
        BinaryTree<Integer> root=new BinaryTree<Integer>(data);
        BinaryTree<Integer>leftChild=inputTree(false, root.data, true);
        BinaryTree<Integer> rightChild=inputTree(false, root.data, false);
        root.left=leftChild;
        root.right=rightChild;
        return root;
    }
    public static void main(String[] args) {
        BinaryTree<Integer> root=inputTree(true, 0,true);
        PrintTree(root);
        System.out.print(RightView(root));
    }    
}





