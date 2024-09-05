public class uniqueSubstring extends tries{

    public static int countNodes(Node root){
        if(root==null){
            return 0;
        }

        int count=0;
        for(int i=0; i<26; i++){
            if(root.children[i]!=null){
                count += 1 + countNodes(root.children[i]);
            }
        }

        return count+1;
    }

    public static void main(String[] args) {
        String str="ababa";

        for(int i=0; i<str.length(); i++){
            String suffix=str.substring(i);
            insert(suffix);
        }

        System.out.println(countNodes(root));
    }
    
}
