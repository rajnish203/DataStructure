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
public class  MakeBstFromSortArray {
    public static BinaryTree<Integer> SortedArrayToBST(int[] arr){
        return SortedArrayToBST(arr,0,arr.length-1);}
public static BinaryTree<Integer> SortedArrayToBST(int[] arr,int si,int ei){

    if(si>ei)
        return null;
    int mid=(ei+si)/2;
    BinaryTree<Integer> root=new BinaryTree<>(arr[mid]);

    root.left=SortedArrayToBST(arr,si,mid-1);
    root.right=SortedArrayToBST(arr,mid+1,ei);
    return root;
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
    public static void main(String[] args) {
        int in[]={1,2,3,4,5,6,7};
        BinaryTree<Integer> root=SortedArrayToBST(in);
        PrintTree(root);
    }    
}





