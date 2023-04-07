class Node {
    int data;
    Node left, right;
    Node(int  data){
        this.data=data;
    }
}
public class createBinaryTree {
    public static void printTree(Node root ){
        if(root==null){
            return ;
        }
        System.out.print(root.data+" ");
        printTree(root.left);
        printTree(root.right);
    }
    public static void main(String args[]){
        Node root =new Node(1);
        Node n1=new Node(2);
        Node n2=new Node(3);
        root.right=n2;
        root.left=n1;
        printTree(root);
    }
    
}
