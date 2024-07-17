import org.w3c.dom.Node;

public class isBinary extends Binarytree{

    public static boolean isBinary(Node root){
        if((root.left==null && root.right!=null) || (root.left!=null && root.right==null)){
            return true;
        }
        if((root.left==null && root.right==null)){
            return false;
        }
        if(root.left!=null && root.right!=null){
            return isBinary(root.left) || isBinary(root.right);
        }
       return false;
    }
    
    public static void main(String[] args) {
        Node root=new Node(1);
        root.left =new Node(2);
        root.right =new Node(3);
        root.left.left =new Node(3);
        // root.left.right =new Node(5);
        // root.right.left =new Node(6);
        root.right.right =new Node(3);

        deleteLeaf(root, 3);
        inorder(root);
    }

}
