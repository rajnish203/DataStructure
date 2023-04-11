import java.util.Scanner;

import javax.sound.midi.SysexMessage;

class Node<T>{
    T data;
    Node<T> left,right;
    Node(T data){
        this.data=data;
    }
}

public class insertDuplicateNode {
    public static void PrintTree(Node<Integer> root){
        if(root==null){
            return ;
        }
        System.out.print(root.data+": ");

        if(root.left!=null){
            System.out.print("L"+root.left.data+",");
        }
        if(root.right!=null){
            System.out.print("R"+root.right.data);
        }

        PrintTree(root.left);
        PrintTree(root.right);
    }

    public static Node<Integer> inputTree(boolean isRoot, int parentData, boolean isleft){
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
        Node<Integer> root=new Node<Integer>(data);
        Node<Integer>leftChild=inputTree(false, root.data, true);
        Node<Integer> rightChild=inputTree(false, root.data, false);
        root.left=leftChild;
        root.right=rightChild;

        return root;
    }
    public static Node<Integer> insert(Node<Integer> root){
        if(root==null){
            return null;
        }
    insert(root.left);
    insert(root.right);
    Node<Integer> node = new Node<>(root.data);
    Node<Integer> temp = root.left;
    root.left = node;
    node.left = temp;

    return root;


    }


    public static void main(String[] args) {
        Node<Integer> root=inputTree(true, 0, true);
        PrintTree(root);
        Node <Integer> newRoot=insert(root);
        PrintTree(newRoot);
    }
}
