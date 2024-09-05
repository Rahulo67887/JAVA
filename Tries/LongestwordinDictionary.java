public class LongestwordinDictionary {

    public static class Node{
        String word=null;
        Node[] children=new Node[26];
        boolean eow=false;
    }

    static Node root=new Node();

    public static void insert(String word){
        Node curr=root;
        for(int i=0; i<word.length(); i++){
            int idx=word.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
            }
            curr=curr.children[idx];
        }
        curr.eow=true;
        curr.word=word;
    }

    static String ans="";

    public static void dfs(Node node){

        if(node==null){
            return;
        }

        if(node.word!=null){
            if(node.word.length()>ans.length()){
                ans=node.word;
            }
            else if(node.word.length()==ans.length() && node.word.compareTo(ans)<0){
                ans=node.word;
            }
        }

        for(Node child : node.children){
            if(child!=null && child.word!=null){
                dfs(child);
            }
        }
    }
    
    public static void longestword(String words[]){
        for(String word : words){
            insert(word);
        }

        dfs(root);
        System.out.println("Longest word in dictionary with all prefixes: "+ans);
    }

    public static void main(String[] args) {
        String words[]={"a","banana","app","appl","ap","apply","apple"};
        longestword(words);
    }
 
}
