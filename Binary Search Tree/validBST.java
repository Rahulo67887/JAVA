import org.w3c.dom.Node;

public class validBST extends bst{

    public static boolean validBST(Node root, Node min, Node max){
        if(root==null){
            return true;
        }

        if(min!=null && root.data<=min.data){
            return false;
        }

        if(max!=null && root.data>=max.data){
            return false;
        }

        return validBST(root.left, min, root) && validBST(root.right, root, max);
    }

    public static void main(String[] args) {
        int values[]={8,5,3,1,4,6,10,11,14};
        Node root=null;

        for(int i=0; i<values.length; i++){
            root=insert(root, values[i]);
        }

        if(validBST(root, null, null)){
            System.out.println("Tree is a valid BST");
        }
        else{
            System.out.println("Tree is not a valid BST");
        }
    }
}
