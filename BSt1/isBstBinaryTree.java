import java.util.Scanner;
class BinaryTree<T>{
    T data;
    BinaryTree<T> left, right;
    BinaryTree(T data){
        this.data=data;
    }
}

class Node<T>{
    T data;
    Node<T> next;
    Node(T data){
        this.data=data;
    }
}

/* 
 @ Author :- Rajnish Kumar
 */
public class  isBstBinaryTree {
    public static BinaryTree<Integer> BuildTreeHelper(int []in, int pre[], int sin, int ein, int spre, int epre){
        if(spre>epre){
            return null;
        }
        int rootData=pre[spre];

        BinaryTree<Integer> root=new BinaryTree<>(rootData);
        int rootIndex=-1;
        for(int i=sin;i<=ein;i++){
            if(in[i]==rootData){
                rootIndex=i;
                break;
            }
        }
       
        int leftPreSi=spre+1;
        int leftInSi=sin;
        int leftInEi=rootIndex-1;
        int leftSubtreeLength=leftInEi-leftInSi+1;
        int leftPreEi=leftPreSi+leftSubtreeLength-1;


        int rightPresi=leftPreEi+1;
        int rightPreEi=epre;
        int rightInSi=rootIndex+1;
        int rightInEi=ein;

        BinaryTree<Integer> leftSubtree=BuildTreeHelper(in, pre, leftInSi, leftInEi, leftPreSi, leftPreEi);
        BinaryTree<Integer> rightSubTree=BuildTreeHelper(in, pre, rightInSi, rightInEi, rightPresi, rightPreEi);
        root.left=leftSubtree;
        root.right=rightSubTree;
        return root;
    }
    public static BinaryTree<Integer> BuildTreeUisngPreIn(int in[], int pre[]){
        return BuildTreeHelper(in, pre, 0, in.length-1, 0, pre.length-1);
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
    public static int minimum(BinaryTree<Integer> root){
        if(root==null){
            return Integer.MAX_VALUE;
        }
        int leftmin=minimum(root.left);
        int rightmin=minimum(root.right);
        return Math.min(root.data,Math.min(leftmin, rightmin));
    }
    public static int maximum(BinaryTree<Integer>root){
        if(root==null){
            return Integer.MIN_VALUE;
        }
        int leftmax=maximum(root.left);
        int rightmax=maximum(root.right);

        return Math.max(root.data,Math.max(leftmax,rightmax));
    }
    public static boolean isBst(BinaryTree<Integer> root){
        if(root==null){
            return true;
        }
        int leftMax=maximum(root.left);
        if(root.data<leftMax){
            return false;
        }
        int rightMin=minimum(root.right);
        if(root.data>rightMin){
            return false;
        }
        boolean isLeftBst=isBst(root.left);
        boolean isRightBst=isBst(root.right);

        return isLeftBst&&isRightBst;
    }
    public static Node<Integer> ConvertBstToLinkedList(BinaryTree<Integer> root){
        // By using the Inorder traversal

        if(root==null){
            return new Node<>(null);
        }
        ConvertBstToLinkedList(root.left);
        Node<Integer> head=new Node<>(root.left.data);
        Node<Integer> tail=ConvertBstToLinkedList(root.right);
        head.next=tail;
        return head;

    }
    public static void PrintList(Node<Integer> head){
        Node<Integer> temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }

    public static void main(String[] args) {
        int in[]={1,2,3,4,5,6,7};
        int pre[]={4,2,1,3,6,5,7};
        BinaryTree<Integer>root=BuildTreeUisngPreIn(in,pre);
        PrintTree(root);
        Node<Integer> head=ConvertBstToLinkedList(root);
        PrintList(head);
    }    
}




