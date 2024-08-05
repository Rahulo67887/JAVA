import java.util.*;

public class rought{
    public static Node getMinNode(Node root) {
        Node curr = root;
        //MIN data is at left-most node
        while (curr.left != null)
        curr = curr.left;
        return curr;
        }
        public static Node deleteNode(Node root, int key) {
        // perform usual BST delete
        if (root == null) {
        return root;
        }
        // key < root's data => then it lies in left subtree
        if (key < root.data) {
        root.left = deleteNode(root.left, key);
        }
        // key > root's data => then it lies in right subtree
        else if (key > root.data) {
        root.right = deleteNode(root.right, key);
        }
        // key = root's data => then this is the node to be deleted
        else {
        // node with only one child or no child
}

