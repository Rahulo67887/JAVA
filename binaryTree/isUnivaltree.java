import org.w3c.dom.Node;

public class isUnivaltree extends Binarytree{

    static boolean isUnivalTree(Node root){
        if(root == null){
            return true;
        }

        if(root.left != null && root.data != root.left.data){
            return false;
        }
            
        if(root.right != null&& root.data != root.right.data){
            return false;
        }
        
        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }

    public static void main(String[] args) {
        Node root=new Node(1);
        root.left =new Node(2);
        root.right =new Node(3);
        root.left.left =new Node(3);
        root.left.right =new Node(5);
        root.right.left =new Node(6);
        root.right.right =new Node(3);

        System.out.println(isUnivalTree(root));
        inorder(root);
    }

}
