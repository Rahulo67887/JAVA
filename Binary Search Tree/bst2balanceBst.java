import java.util.*;

public class bst2balanceBst extends bst{

    public static Node balanceBST(Node root){
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(inorder, root);

        root=createBST(inorder, 0, inorder.size() - 1);
        return root;
    }

    public static Node createBST(ArrayList<Integer> inorder, int st, int end){
        if(st>end){
            return null;
        }

        int mid=(st+end)/2;
        Node root=new Node(inorder.get(mid));
        root.left=createBST(inorder, st, mid-1);
        root.right=createBST(inorder, mid+1, end);
        return root;
    }

    public static void getInorder(ArrayList<Integer> inorder, Node root){
        if(root==null){
            return;
        }

        getInorder(inorder, root.left);
        inorder.add(root.data);
        getInorder(inorder, root.right);
    }

    public static void main(String[] args) {
        Node root=new Node(8);
        root.left=new Node(6);
        root.left.left=new Node(5);
        root.left.left.left=new Node(3);

        root.right=new Node(10);
        root.right.right=new Node(11);
        root.right.right.right=new Node(12);

        root=balanceBST(root);
        preorder(root);
    }
    
}
