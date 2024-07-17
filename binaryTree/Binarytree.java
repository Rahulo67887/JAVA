import java.util.*;

    public class Binarytree {
        static int idx=-1;

        public static class Node{
            int data;
            Node left;
            Node right;
    
            Node(int data){
                this.data = data;
                this.left = null;
                this.right = null;
            }
        }

        public static Node Buildtree(int node[]){
            idx++;
            if(node[idx]==-1){
                return null;
            }

            Node newNode = new Node(node[idx]);
            newNode.left=Buildtree(node);
            newNode.right=Buildtree(node);

            return newNode;
        }

        public static void preorder(Node node) {
            if(node==null) {
                return;
            }

            System.out.print(node.data + " ");
            preorder(node.left);
            preorder(node.right);
        }

        public static void inorder(Node node) {
            if(node==null) {
                return;
            }

            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }

        public static void postorder(Node node) {
            if(node==null) {
                return;
            }

            postorder(node.left);
            postorder(node.right);
            System.out.print(node.data + " ");
        }

        public static void levelorder(Node node) {
            if(node==null){
                return;
            }
           Queue<Node> q = new LinkedList<>();
            q.add(node);
            q.add(null);
           while(!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode==null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }
                    else{
                        q.add(null);
                    }
                }
                else{
                    System.out.print(currNode.data + " ");
                    if(currNode.left != null){
                        q.add(currNode.left);
                    }
                    if(currNode.right != null){
                        q.add(currNode.right);
                    }
                }

           }
        }

        public static int height(Node node){
            if(node==null){
                return 0;
            }

            int lh=height(node.left);
            int rh=height(node.right);
            return Math.max(lh, rh)+1;
        }

        public static int countNodes(Node node){
            if(node==null){
                return 0;
            }

            int lh=countNodes(node.left);
            int rh=countNodes(node.right);
            return lh+rh+1;
        }

        public static int sumofNodes(Node node){
            if(node==null){
                return 0;
            }

            int lh=sumofNodes(node.left);
            int rh=sumofNodes(node.right);
            return lh+rh+node.data;
        }

        public static int diameter(Node node){
            if(node==null){
                return 0;
            }
    
            int ld=diameter(node.left);
            int lh=height(node.left);
            int rh=height(node.right);
            int rd=diameter(node.right);
    
            return Math.max(lh+rh+1, Math.max(ld,rd)); 
        }

        public static class Info{
            int diam;
            int height;

            Info(int diam, int height){
                this.diam = diam;
                this.height = height;
            }
        }

        public static Info diameter2(Node node){
            if(node==null){
                return new Info(0,0);
            }
    
            Info li=diameter2(node.left);
            Info ri=diameter2(node.right);

            int diam=Math.max(li.height+ri.height+1, Math.max(li.diam, ri.diam)); 
            int height=Math.max(li.height,ri.height)+1;
    
            return new Info(diam, height);
        }

        public static boolean isSubroot(Node root, Node subroot){
            if(root==null){
                return false;
            }

            if(root.data==subroot.data){
                if(isIdentical(root, subroot)){
                    return true;
                }
            }

            boolean leftAns=isSubroot(root.left, subroot);
            boolean rightAns=isSubroot(root.right, subroot);

            return leftAns || rightAns;
        }

        public static boolean isIdentical(Node node, Node subroot){
            if(node==null && subroot==null){
                return true;
            }
            else if(node==null || subroot==null || node.data!=subroot.data){
                return false;
            }

            if(!isIdentical(node.left, subroot.left)){
                return false;
            }

            if(!isIdentical(node.right, subroot.right)){
                return false;
            }

            return true;
        }

        public static class Info2{
            Node node;
            int hd;

            Info2(Node node, int hd){
                this.node=node;
                this.hd=hd;
            }
        }

        public static void topview(Node root){
            Queue<Info2> q=new LinkedList<>();
            HashMap<Integer, Node> map=new HashMap<>();
            int min=0, max=0;

            q.add(new Info2(root, 0));
            q.add(null);

            while(!q.isEmpty()){
                Info2 curr=q.remove();
                if(curr==null){
                    if(q.isEmpty()){
                        break;
                    }
                    else{
                        q.add(null);
                    }
                }
                else{
                    if(!map.containsKey(curr.hd)){
                        map.put(curr.hd, curr.node);
                    }
                    if(curr.node.left!=null){
                        q.add(new Info2(curr.node.left, curr.hd-1));
                        min=Math.min(min, curr.hd-1);
                    }
                    if(curr.node.right!=null){
                        q.add(new Info2(curr.node.right, curr.hd+1));
                        max=Math.max(max, curr.hd+1);
                    }
                }   
            }

            for(int i=min; i<=max; i++){
                System.out.print(map.get(i).data + " ");
            }
        }

        public static void klevel(Node root, int k, int level){
            if(root==null){
                return;
            }

            if(k==level){
                System.out.print(root.data + " ");
                return;
            }

            klevel(root.left, k+1, level);
            klevel(root.right, k+1, level);
        }

        public static Node lca(Node root, int n1, int n2){
            ArrayList<Node> path1 = new ArrayList<>();
            ArrayList<Node> path2 = new ArrayList<>();

            getpath(root, n1, path1);
            getpath(root, n2, path2);

            int i=0;
            for(; i<path1.size() && i<path2.size(); i++){
                if(path1.get(i)!=(path2.get(i))){
                    break;
                }
            }

            return path1.get(i-1);
        }

        public static boolean getpath(Node root, int n, ArrayList<Node> path){
            if(root==null){
                return false;
            }

            path.add(root);

            if(root.data==n){
                return true;
            }

            boolean leftpath=getpath(root.left, n, path);
            boolean rightpath=getpath(root.right, n, path);

            if(leftpath || rightpath){
                return true;
            }

            path.remove(path.size()-1);
            return false;
        }

        public static Node lca2(Node root, int n1, int n2){
            if(root==null || root.data==n1 || root.data==n2){
                return root;
            }

            Node leftlca=lca2(root.left, n1, n2);
            Node rightlca=lca2(root.right, n1, n2);

            if(leftlca==null){
                return rightlca;
            }

            if(rightlca==null){
                return leftlca;
            }

            return root;
        }

        public static int minDis(Node root, int n1, int n2){
            Node lca=lca2(root, n1, n2);

            int dis1=lcadis(lca, n1);
            int dis2=lcadis(lca, n2);

            return dis1+dis2;
        }

        public static int lcadis(Node lca, int n){
            if(lca==null){
                return -1;
            }

            if(lca.data==n){
                return 0;
            }

            int leftdis=lcadis(lca.left, n);
            int rightdis=lcadis(lca.right, n);

            if(leftdis==-1 && rightdis==-1){
                return -1;
            }
            else if(leftdis==-1){
                return rightdis+1;
            }
            else if(rightdis==-1){
                return leftdis+1;
            }

            return -1;
        }

        public static int transform(Node root){
            if(root==null){
                return 0;
            }

            int data=root.data;
            int leftchild=transform(root.left);
            int rightchild=transform(root.right);

            int newleft= root.left==null ? 0 : root.left.data;
            int newright= root.right==null ? 0 : root.right.data;

            root.data=leftchild+newleft+newright+rightchild;

            return data;
        }

    public static void main(String[] args) {
        Node root=new Node(1);
        root.left =new Node(2);
        root.right =new Node(3);
        root.left.left =new Node(4);
        root.left.right =new Node(5);
        root.right.left =new Node(6);
        root.right.right =new Node(7);

        Node subroot=new Node(2);
        subroot.left=new Node(4);
        subroot.right=new Node(7);

        transform(root);
        preorder(root);
    }
}
