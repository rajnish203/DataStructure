import javax.sql.rowset.spi.SyncResolver;

public class BinaryTreeuse {
    public static void PrintInOrder(BinaryTree<Integer>root){
        if(root==null){
            return;
        }
        PrintInOrder(root.left);
        System.out.print(root.data);
        PrintInOrder(root.right);
    }
    public static void PrintTree(BinaryTree<Integer>root){
        if(root==null){
            return ;
        }
        System.out.print(root.data+" ");
        PrintTree(root.left);
        PrintTree(root.right);
    }
    public static int height(BinaryTree<Integer>root){
        if(root==null){
            return 0;
        }
        int x=height(root.left);
        int y=height(root.right);
        return 1+Math.max(x,y);
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
        int height=height(root);
        System.out.println("\n"+height);
    }
}
