import java.util.*;

public class groupAnagram {
    
    public static class Node{
        ArrayList<String> data = new ArrayList<>();
        Node children[]=new Node[26];
        boolean eow = false;

        public Node(){
            for(int i=0;i<children.length; i++){
                children[i] = null;
            }
        }
    }

    public static Node root=new Node();

    static ArrayList<ArrayList<String>> ans= new ArrayList<ArrayList<String>>();

    public static ArrayList<ArrayList<String>> GroupAnagram(String str[]){
        for(String s : str){
            insert(s);
        }

        DFS(root);
        return ans;
    }

    public static void insert(String str){
        Node curr=root;
        char ch[]=str.toCharArray();
        Arrays.sort(ch);
        for(char c : ch){
            int idx=c-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
            }
            curr=curr.children[idx];
        }
        curr.eow=true;
        curr.data.add(str);
    }

    public static void DFS(Node rt){
        if(rt.eow){
            ans.add(rt.data);
        }

        for(int i=0;i<26; i++){
            if(rt.children[i]!=null){
                DFS(rt.children[i]);
            }
        }
    }

    public static void main(String[] args) {
        String str[]={"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(GroupAnagram(str));
    }

}
