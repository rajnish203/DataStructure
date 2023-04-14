import java.util.Scanner;

class Node <T>{
    T data;
    Node<Integer> left, right;
    Node(T data){
        this.data=data;
    }
 }


 class Pair<T, U> {
    T minimum;
    U maximum;

    public Pair(T minimum, U maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }

}
public class returnMinAndMax {

    public static Node<Integer> TakeInpput(boolean isRoot, int parentData, boolean isleft){
        if(isRoot){
            System.out.print("Enter the rootData: ");
        }else{
            if(isleft){
                System.out.print("Enter the leftchild of "+parentData);
            }else{
                System.out.print("Enter the rightChild of "+ parentData);
            }
        }
        Scanner s=new Scanner(System.in);
        int rootData=s.nextInt();
        if(rootData==-1){
            return null;
        }
        Node<Integer> root=new Node<>(rootData);
        Node<Integer> leftTree=TakeInpput(false, root.data, true);
        Node<Integer> rightTree=TakeInpput(false, root.data, false);
        root.left=leftTree;
        root.right=rightTree;

        return root;

    }
    private static Pair<Integer,Integer> p2=new Pair<>(Integer.MAX_VALUE,Integer.MIN_VALUE);
    public static Pair <Integer,Integer> findMInMax(Node<Integer> root){
        helper(root);
        return p2;
    }
    public static void helper(Node<Integer> root){
        if(root==null){
            return;
        }
        int rootData=root.data;
        int maxVal=p2.maximum;
        if (rootData>maxVal)
        {
            p2.maximum=root.data;
        }
        
        int minVal=p2.minimum;
        if (rootData<minVal)
        {
            p2.minimum=root.data;
        }
        helper(root.left);
        helper(root.right);
    }

    public static void PrintTree(Node<Integer> root){
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

        Node<Integer> root= TakeInpput(true, 0, true);
        
        PrintTree(root);

        System.out.println(findMInMax(root).maximum);

        System.out.println(findMInMax(root).minimum);
    }
}
