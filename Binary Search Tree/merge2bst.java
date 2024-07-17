import java.util.ArrayList;

import org.w3c.dom.Node;

public class merge2bst extends bst {

    public static Node mergeBst(Node root1, Node root2){
        ArrayList<Integer> inorder1 = new ArrayList<>();
        getInorder(inorder1, root1);

        ArrayList<Integer> inorder2 = new ArrayList<>();
        getInorder(inorder2, root2);

        int i=0, j=0;
        ArrayList<Integer> inorder = new ArrayList<>();
        while(i<inorder1.size() && j<inorder2.size()){
            if(inorder1.get(i)<inorder2.get(j)){
                inorder.add(inorder1.get(i++));
            }
            else{
                inorder.add(inorder2.get(j++));
            }
        }

        while(i<inorder1.size()){
            inorder.add(inorder1.get(i++));
        }

        while(j<inorder2.size()){
            inorder.add(inorder2.get(j++));
        }

        return createBST(inorder, 0, inorder.size()-1);
    }

    public static void getInorder(ArrayList<Integer> inorder, Node root){
        if(root==null){
            return;
        }

        getInorder(inorder, root.left);
        inorder.add(root.data);
        getInorder(inorder, root.right);
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

    public static void main(String[] args) {
        Node root1=new Node(2);
        root1.left=new Node(1);
        root1.right=new Node(4);

        Node root2=new Node(9);
        root2.left=new Node(3);
        root2.right=new Node(12);

        Node root=mergeBst(root1, root2);
        preorder(root);
    }

}