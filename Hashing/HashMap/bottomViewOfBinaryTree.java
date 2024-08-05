import java.util.*;

public class bottomViewOfBinaryTree {

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

    public static class Pair{
        int hd;
        Node node;

        Pair(int hd, Node node){
            this.hd=hd;
            this.node=node;
        }
    }

    public static void bottomView(Node root){
        if(root==null){
            return;
        }

        Queue<Pair> q= new LinkedList<>();
        TreeMap<Integer, Integer> map= new TreeMap<>();

        q.add(new Pair(0, root));
        while(!q.isEmpty()){
            Pair curr=q.poll();
            map.put(curr.hd, curr.node.data);

            if(curr.node.left!=null){
                q.add(new Pair(curr.hd-1, curr.node.left));
            }

            if(curr.node.right!=null){
                q.add(new Pair(curr.hd+1, curr.node.right));
            }
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            System.out.print(entry.getValue() + " ");
        }
    }    
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(25);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        
        System.out.print("Bottom view of the given binary tree: ");
        bottomView(root);
    }
}
