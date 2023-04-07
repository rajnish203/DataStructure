import java.net.CacheRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Node{
    int data;
    Node right;
    Node left;
    Node(int data){
        this.data=data;
    }
}
public class Printk1k2{
    // public static ArrayList<Integer> Print(Node root,int k1, int k2){
    //   if(root==null){
    //     return new ArrayList<>();
    //   }
    //   ArrayList<Integer>list=new ArrayList<>();
    //   if(root.data>=k1 && root.data<=k2){
    //    list.add(root.data);
    //   }
    //   if(k1<root.data){
    //     if(root.left!=null){
    //       list.add(root.left.data);
    //     }
    //     Print(root.left, k1,  k2); 
    //   }
    //   if(root.data<=k2){
    //     if(root.right!=null){
    //       list.add(root.right.data);
    //     }
    //     Print(root.right, k1, k2);
    //   }
    //   return list;
    // }
    public static void printRange(Node node, int k1, int k2) {
      if (node == null) {
          return;
      }

      // If node's value is in range, print it
      if (node.data >= k1 && node.data <= k2) {
          System.out.print(node.data + " ");
      }

      // If node's value is less than k2, then only we need to check right subtree
      if (node.data <=k2) {
          printRange(node.right, k1, k2);
      }

      // If node's value is greater than k1, then only we need to check left subtree
      if (node.data >= k1) {
          printRange(node.left, k1, k2);
      }
  }

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
  public static void main(String[] args) {
        Node root=CreateTree();
        int k1=6;int k2=10;
        printRange(root, k1, k2);
    }
}