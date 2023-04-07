
import java.util.Scanner;

import javax.swing.text.StyledEditorKit.BoldAction;
import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

 class Pair{
    int height;
    boolean isBalance;
 }
class BinaryTree<T>{
    T data;
    BinaryTree<T> left, right;
    BinaryTree(T data){
        this.data=data;
    }
}
public class isBalanceImproved {
    public static int height(BinaryTree<Integer> root){
        if(root==null){
            return 0;
        }
        int leftHeight=height(root.left);
        int rightHeight= height(root.right);

        return 1+Math.max(leftHeight, rightHeight);
    }
    public static Pair isBalanceTree(BinaryTree<Integer>root){
       if(root==null){
        int height=0;
        boolean isBal=true;
        Pair p1=new Pair();
        p1.height=height;
        p1.isBalance=isBal;
        return p1;
       }
       Pair leftOutput =isBalanceTree(root.left);
       Pair rightOutput=isBalanceTree(root.right);
       boolean isBal=true;
       int height=1+Math.max(leftOutput.height,rightOutput.height);
       if(Math.abs(leftOutput.height-rightOutput.height)>1){
        isBal=false;
       }

       if(!leftOutput.isBalance || !rightOutput.isBalance){
        isBal=false;
       }

        Pair ans=new Pair();
        ans.height=height;
        ans.isBalance=isBal;
        return ans;
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
        System.out.print(isBalanceTree(root).isBalance);
    }    
}






