class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;
		public BinaryTreeNode(T data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

public class MakeTreeUisngInPo {
	public static BinaryTreeNode<Integer> buildTree(int[] postOrder, int[] inOrder) {    
         return buildTree(postOrder, inOrder, 0 ,postOrder.length-1, 0, inOrder.length-1);
	}
    
    public static BinaryTreeNode<Integer> buildTree(int[] postOrder, int[] inOrder,int siPost, int eiPost, int siIn, int eiIn) {

    	if (siPost>eiPost)
    	{
    		return null;
    	}
    	
    	int rootData=postOrder[eiPost];
    	BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
    	int rootIndex=-1;
    	for (int i=siIn;i<=eiIn;i++)
    	{
    		if (rootData==inOrder[i])
    		{
                rootIndex=i;
    			break;
    		}
    	}
    	int siInLeft=siIn;
    	int eiInLeft=rootIndex-1;
    	int siPostLeft=siPost;
    	int leftSubTreeLength = eiInLeft - siInLeft + 1;
    	int eiPostLeft=(siPostLeft)+(leftSubTreeLength-1);
    	int siInRight=rootIndex+1;
    	int eiInRight=eiIn;
    	int siPostRight=eiPostLeft+1;
    	int eiPostRight=eiPost-1;
        BinaryTreeNode<Integer> rightChild = buildTree(postOrder, inOrder, siPostRight, eiPostRight, siInRight, eiInRight);
    	BinaryTreeNode<Integer> leftChild = buildTree(postOrder, inOrder, siPostLeft, eiPostLeft, siInLeft, eiInLeft);
    	root.left=leftChild;
    	root.right=rightChild;
    	return root;
	}

    public static void PrintTree(BinaryTreeNode<Integer> root){
        if (root==null){
            return ;
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
        int postOrder[]={2,4,5,3,1};
        int inOrder[]={2,1,4,3,5};
        BinaryTreeNode<Integer>root=buildTree(postOrder, inOrder);
        PrintTree(root);
    }

}