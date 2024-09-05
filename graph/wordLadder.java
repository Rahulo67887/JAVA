import java.util.*;

public class wordLadder {

    public static int shortestChainLen(String start, String target, Set<String> d){
        if(start==target){
            return 0;
        }

        if(!d.contains(target)){
            return 0;
        }

        int level=0;
        Queue<String> q = new LinkedList<String>();
        q.add(start);

        while(!q.isEmpty()){
            level++;
            int sizeofq=q.size();

            for(int i=0; i<sizeofq; i++){
                char word[]=q.remove().toCharArray();

                for(char pos=0; pos<word.length; pos++){
                    char org_word=word[pos];

                    for(char k='a'; k<='z'; k++){
                        word[pos]=k;

                        if(String.valueOf(word).equals(target)){
                            return level+1;
                        }
    
                        if(!d.contains(String.valueOf(word))){
                            continue;
                        }

                        d.remove(String.valueOf(word));
                        q.add(String.valueOf(word));
                    }

                    word[pos]=org_word;
                }
            }
        }
        return 0;
    }
    
    public static void main(String[] args){
    // make dictionary
    Set<String> D = new HashSet<String>();
    D.add("poon");
    D.add("plee");
    D.add("same");
    D.add("poie");
    D.add("plie");
    D.add("poin");
    D.add("plea");
    String start = "toon";
    String target = "plea";
    System.out.print("Length of shortest chain is: "+ shortestChainLen(start, target, D));
}

}
