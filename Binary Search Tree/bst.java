import java.util.*;

public class bst {

    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    public static Node insert(Node root, int val){
        if(root==null){
            return new Node(val);
        }

        if(root.data>val){
            root.left=insert(root.left, val);
        }

        if(root.data<val){
            root.right=insert(root.right, val);
        }

        return root;
    }    

    public static Node delete(Node root, int val){
        if(root.data>val){
            root.left=delete(root.left, val);
        }

        else if(root.data<val){
            root.right=delete(root.right, val);
        }

        else{
            if(root.left==null && root.right==null){
                return null;
            }

            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
            else{
                Node IS=inorderSuccessor(root.right);
                root.data=IS.data;
                root.right=delete(root.right, IS.data);
            }
        }

        return root;
    }

    public static Node inorderSuccessor(Node root){
        while(root.left!=null){
            root=root.left;
        }

        return root;
    }

    public static boolean search(Node root, int key){
        if(root==null){
            return false;
        }

        if(root.data==key){
            return true;
        }

        if(root.data<key){
            return search(root.right, key);
        }

        else if(root.data>key){
            return search(root.left, key);
        }

        return false;
    }

    public static void inorder(Node root){
        if(root==null){
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        int values[]={8,5,3,1,4,6,10,11,14};
        Node root=null;

        for(int i=0; i<values.length; i++){
            root=insert(root, values[i]);
        }
    }

}
