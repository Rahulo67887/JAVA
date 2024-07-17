import java.util.ArrayList;

import org.w3c.dom.Node;

public class printRoot2leaf extends bst{

    public static void printRoot2leaf(Node root, ArrayList<Integer> path){
        if(root==null){
            return;
        }

        path.add(root.data);

        if(root.left==null && root.right==null){
            print(path);
        }

        printRoot2leaf(root.left, path);
        printRoot2leaf(root.right, path);
        path.remove(path.size()-1);
    }

    public static void print(ArrayList<Integer> list){
        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i) + "->");
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        int values[]={8,5,3,1,4,6,10,11,14};
        Node root=null;

        for(int i=0; i<values.length; i++){
            root=insert(root, values[i]);
        }

        printRoot2leaf(root, new ArrayList<>());
    }
}
