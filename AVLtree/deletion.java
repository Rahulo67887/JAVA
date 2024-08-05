import java.util.*;

public class deletion extends insertion{

    public static Node inorderSuccessor(Node root){
        Node curr=root;
        while(curr.left!=null){
            curr = curr.left;
        }

        return curr;
    }

    public static Node delete(Node root, int key){
        if(root == null){
            return root;
        }

        if(key<root.data){
            root.left=delete(root.left, key);
        }
        else if(key>root.data){
            root.right=delete(root.right, key);
        }
        else{
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
                Node temp=inorderSuccessor(root.right);
                root.data=temp.data;
                delete(root.right, temp.data);
            }
        }

        if(root==null){
            return root;
        }

        root.height=Math.max(getHeight(root.right), getHeight(root.left)) + 1;

        int balance=getBalance(root);

        if(balance<-1 && getBalance(root.right) <= 0){
            return rotateLeft(root);
        }

        else if(balance<-1 &&  getBalance(root.right) > 0){
            root.right=rotateRight(root.right);
            return rotateLeft(root);
        }

        else if(balance>1 &&  getBalance(root.left) >= 0){
            return rotateRight(root);
        }

        else if(balance>1 && getBalance(root.left) < 0){
            root.right=rotateLeft(root.right);
            return rotateRight(root);
        }

        return root;
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
        System.out.println();
        root=delete(root, 20);
        preorder(root);
    }

}
