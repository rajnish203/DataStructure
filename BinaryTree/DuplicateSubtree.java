import java.util.Scanner;

class Node{
    int data;
    Node right, left;
    Node(int data){
        this.data=data;
    }

}
public class DuplicateSubtree {
    public static Node CreateTree(){
        Scanner s=new Scanner(System.in);
        System.out.print("Enter the root data");
        int rootData=s.nextInt();
        if(rootData==-1){
          return null;
        }
        Node root=new Node(rootData);
        Node rootLeftChild=CreateTree();
        Node rootrightChild=CreateTree();
        root.left=rootLeftChild;
        root.right=rootrightChild;
        return root;
      }
    public static boolean DuplicateSTree(Node root){
        
    }
   public static void main(String[] args) {
    
   }
}
