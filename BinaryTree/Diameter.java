import java.util.Scanner;
class BinaryTree<T>{
    T data;
    BinaryTree<T> left, right;
    BinaryTree(T data){
        this.data=data;
    }
}
public class  Diameter {
    public static int findDiameter(BinaryTree<Integer> root){
        if (root==null){
            return 0;
        }
        return 1+findDiameterHelper(root.left)+findDiameterHelper(root.right);
    }
    public static int findDiameterHelper(BinaryTree<Integer> root){
        //write your code here
        if(root==null){
            return 0;
        }
        int leftHeight=height(root.left);
        int rightHeight=height(root.right);
        if(leftHeight>rightHeight){
            return leftHeight+1;
        }
        else{
            return rightHeight+1;
        }

    }

    public static int height(BinaryTree<Integer> root){
        if(root==null){
            return 0;
        }
        int leftHeight=height(root.left);
        int rightHeight=height(root.right);
        return  1+Math.max(leftHeight,rightHeight);
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
       int ans=findDiameter(root);
       System.out.print(ans);
    }    
}




