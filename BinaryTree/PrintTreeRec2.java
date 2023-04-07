class BinaryTree<T>{
    public T data;
    public BinaryTree<T> left;
    public BinaryTree<T> right;
    BinaryTree(T data){
    this.data=data;
   }
}
public class PrintTreeRec2 {
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
