import java.util.*;

public class insertion {

    public static class Node{
        int data, height;
        Node left, right;

        Node(int data) {
            this.data = data;
            height = 1;
        }
    }

    public static Node root;

    public static int getHeight(Node node) {
        if(node==null){
            return 0;
        }

        return node.height;
    }
    public static Node rotateLeft(Node x){
        Node y=x.right;
        Node z=y.left;

        y.left=x;
        x.right=z;

        x.height=Math.max(getHeight(x.right), getHeight(x.left))+1;
        y.height=Math.max(getHeight(y.right), getHeight(y.left))+1;

        return y;
    }

    public static Node rotateRight(Node y){
        Node x=y.left;
        Node z=x.right;

        x.right=y;
        y.left=z;

        x.height=Math.max(getHeight(x.right), getHeight(x.left))+1;
        y.height=Math.max(getHeight(y.right), getHeight(y.left))+1;

        return x;
    }

    public static int getBalance(Node root){
        if(root==null){
            return 0;
        }

        return getHeight(root.left) - getHeight(root.right);
    }

    public static Node insert(Node root, int data){
        if(root==null){
            return new Node(data);
        }

        if(data < root.data){
            root.left=insert(root.left, data);
        }
        else if(data > root.data){
            root.right=insert(root.right, data);
        }
        else{
            return root;
        }

        root.height=1 + Math.max(getHeight(root.left), getHeight(root.right));

        int balance=getBalance(root);

        if(balance>1 && data<root.left.data){
            return rotateRight(root);
        }

        if(balance<-1 && data>root.right.data){
            return rotateLeft(root);
        }

        if(balance>1 && data>root.left.data){
            root.left=rotateLeft(root.left);
            return rotateRight(root);
        }

        if(balance<-1 && data<root.right.data){
            root.right=rotateRight(root.right);
            return rotateLeft(root);
        }

        return root;
    }

    public static void preorder(Node root){
        if(root==null){
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    
    public static void main(String[] args) {
        root=insert(root, 10);
        root=insert(root, 10);
        root=insert(root, 20);
        root=insert(root, 30);
        root=insert(root, 40);
        root=insert(root, 50);
        root=insert(root, 25);

        preorder(root);
    }



}
