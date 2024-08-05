public class longestWordWithAllPrefix extends tries{

    public static String ans="";

    public static void longestWord(Node root, StringBuilder temp){
        if(root==null){
            return;
        }

        for(int i=0; i<26; i++){
            if(root.children[i]!=null && root.children[i].eow==true){
                char ch=(char)(i+'a');
                temp.append(ch);
                if(temp.length()>ans.length()){
                    ans=temp.toString();
                }
                longestWord(root.children[i], temp);
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }
    
    public static void main(String[] args) {
        String words[]={"banana", "a", "app", "ap", "appl", "apple", "apply"};

        for(int i=0; i<words.length; i++){
            insert(words[i]);
        }

       longestWord(root, new StringBuilder(""));
        System.out.println(ans);
    }

}
