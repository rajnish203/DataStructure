
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;
class BinaryTree<T>{
    T data;
    BinaryTree<T> left, right;
    BinaryTree(T data){
        this.data=data;
    }
}
class pair{
    int horizontal_distance;
    BinaryTree<Integer> root;
    public pair(int horizontal_distance, BinaryTree<Integer> root){
        this.root=root;
        this.horizontal_distance=horizontal_distance;
    }
}
public class bottomview {
    public static ArrayList<Integer> PrintBottomView(BinaryTree<Integer> root){
        Queue<pair>queue=new LinkedList<>();
        TreeMap<Integer, Integer> map=new TreeMap<>();
        queue.add(new pair(0, root));
        while(!queue.isEmpty()){
            pair cur=queue.poll();
            map.put(cur.horizontal_distance, cur.root.data);
            if(cur.root.left!=null){
                queue.add(new pair(cur.horizontal_distance-1, cur.root.left));
            }
            if(cur.root.right!=null){
                queue.add(new pair(cur.horizontal_distance+1, cur.root.right));
            }
        }
        ArrayList<Integer>list=new ArrayList<>();
        for(int i: map.keySet()){
            list.add(map.get(i));
        }
        return list;
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
        System.out.print(PrintBottomView(root));
    }    
}



