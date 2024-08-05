import java.util.*;

import org.w3c.dom.Node;

public class minDiffofNode extends bst{

    public static int diff=Integer.MAX_VALUE;

    public static void minDiff(Node root, int k){
        if(root==null){
            return;
        }

        diff=Math.abs(Math.min(diff, root.data-k));
        
        if(k>root.data){
            minDiff(root.right, k);
        }
        if(k<root.data){
            minDiff(root.left, k);
        }
    }

    public static void main(String[] args){
        Node root = new Node(9); root.left = new Node(4);
root.right = new Node(17);
root.left.left = new Node(3);
root.left.right = new Node(6);
root.left.right.left = new Node(5);
root.left.right.right = new Node(7);
root.right.right = new Node(22);
root.right.right.left = new Node(20);

        preorder(root);
        System.out.println();
        minDiff(root, 18);
        System.out.println(diff);
        
    }
    
}
