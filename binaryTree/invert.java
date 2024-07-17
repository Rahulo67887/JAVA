import org.w3c.dom.Node;

public class invert extends Binarytree{
    public static Node invert(Node root){
        if(root==null){
            return root;
        }

        Node left = invert(root.left);
        Node right = invert(root.right);

        root.left=right;
        root.right=left;

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

        inorder(root);
        System.out.println();
        root=invert(root);
        inorder(root);
    }
}
