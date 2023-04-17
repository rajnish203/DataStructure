import java.util.Scanner;
class BinaryTree<T>{
    T data;
    BinaryTree<T> left, right;
    BinaryTree(T data){
        this.data=data;
    }
}

/* 
 @ Author :- Rajnish Kumar
 */
public class  Printk1k2 {
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
   public static void PrintFunction(BinaryTree<Integer> root, int k1, int k2){
    if(root==null){
        return;
    }
    if(root.data>k1 && root.data<k2){
        System.out.print(root.data+" ");
    }
    if(root.data>k1){
        PrintFunction(root.right, k1, k2);
        return;
    }
    else if(root.data<k2){
        PrintFunction(root.left, k1, k2);
        return;
    }
    else{
        System.out.print(root.data+" ");
        PrintFunction(root.left, k1, k2);
        PrintFunction(root.right, k1, k2);
    }
   }
    public static void main(String[] args) {
        int in[]={1,2,3,4,5,6,7};
        int pre[]={4,2,1,3,6,5,7};
        BinaryTree<Integer>root=BuildTreeUisngPreIn(in,pre);
        PrintTree(root);
       PrintFunction(root, 3, 7);
    }    
}




