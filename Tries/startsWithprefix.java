public class startsWithprefix extends tries{

    public static boolean startsWith(String prefix){
        Node curr=root;

        for(int i=0; i<prefix.length(); i++){
            int idx=prefix.charAt(i)-'a';
            if(curr.children[idx]==null){
                return false;
            }

            curr=curr.children[idx];
        }

        return true;
    }
    
    public static void main(String[] args) {
        String words[]={"apple", "app", "mango", "man", "woman"};

        for(int i=0; i<words.length; i++){
            insert(words[i]);
        }

        System.out.println(startsWith("app"));
        System.out.println(startsWith("moon"));
    }

}
