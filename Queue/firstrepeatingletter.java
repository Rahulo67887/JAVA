import java.util.*;

public class firstrepeatingletter {
    static int freq[]=new int[26];
    static Queue<Character> q=new LinkedList<>();

    public static void printRepeating(String str){
        for(int i=0; i<str.length(); i++){
            char ch=str.charAt(i);
            q.add(ch);
            freq[ch-'a']++;

            while(!q.isEmpty() && freq[q.peek()-'a']>1){
                q.remove();
            }

            if(q.isEmpty()){
                System.out.print(-1+" ");
            }
            else{
                System.out.print(q.peek() + " ");
            }

        }
        System.out.println();
    }

    public static void main(String[] args) {
        printRepeating("aabccxb");
    }
}
