import org.w3c.dom.Node;

public class deleteLeaf extends Binarytree{

    public static Node deleteLeaf(Node root, int x){
        if(root==null){
            return null;
        }

        root.left=deleteLeaf(root.left, x);
        root.right=deleteLeaf(root.right, x);

        if(root.data==x && root.left==null && root.right==null){
            return null;
        }

        return root;
    }

    public static void main(String[] args) {
        Node root=new Node(1);
        root.left =new Node(2);
        root.right =new Node(3);
        root.left.left =new Node(3);
        root.left.right =new Node(5);
        root.right.left =new Node(6);
        root.right.right =new Node(3);

        deleteLeaf(root, 3);
        inorder(root);
    }
}
