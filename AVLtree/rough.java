import java.util.*;

import org.w3c.dom.Node;

public class rough extends insert{
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
            if ((root.left == null) || (root.right == null)) {
Node temp = null;
if (temp == root.left)
temp = root.right;
else
temp = root.left;
// No child case
if (temp == null)
{
temp = root;
root = null;
}
else // One child case
root = temp; // Copy the contents of
// the non-empty child
}
else {
// node with two children: Get the inorder
// successor (smallest in the right subtree)
Node temp = getMinNode(root.right);
// Copy the inorder successor's data to this node
root.data = temp.data;
// Delete the inorder successor
root.right = deleteNode(root.right, temp.data);
}
}
if (root == null)
return root;
// update height of curr node
root.height = Math.max(height(root.left), height(root.right)) + 1;
// get balance factor of this node (to check for unbalanced)
int bf = getBalance(root);
// If this node becomes unbalanced, then there are 4 cases
// Left Left Case
if (bf > 1 && getBalance(root.left) >= 0)
return rightRotate(root);
// Left Right Case
if (bf > 1 && getBalance(root.left) < 0)
{
    root.left = leftRotate(root.left);
    return rightRotate(root);
    }
    // Right Right Case
    if (bf < -1 && getBalance(root.right) <= 0)
    return leftRotate(root);
    // Right Left Case
    if (bf < -1 && getBalance(root.right) > 0)
    {
    root.right = rightRotate(root.right);
    return leftRotate(root);
    }
    return root;
    }
    
    public static void main(String[] args){
        root=insert(root, 10);
        root=insert(root, 10);
        root=insert(root, 20);
        root=insert(root, 30);
        root=insert(root, 40);
        root=insert(root, 50);
        root=insert(root, 25);
    
        preorder(root);
        System.out.println();
        deleteNode(root, 20);
        preorder(root);
    }
}

if(root.right==null && root.left==null){
    return null;
}
else if(root.left==null){
    return root.right;
}
else if(root.right==null){
    return root.left;
}
else{
    Node Is=inorderSuccessor(root.right);
    root.data=Is.data;
    delete(root.right, Is.data);
}



