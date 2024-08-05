

public class wordBreak extends tries{

    public static boolean WordBreak(String key){
        if(key.length()==0){
            return true;
        }

        for(int i=1; i<=key.length(); i++){
            if(search(key.substring(0, i)) && WordBreak(key.substring(i))){
                return true;
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        String words[]={"i", "like", "sam", "samsung", "mobile", "ice"};

        for(int i=0; i<words.length; i++){
            insert(words[i]);
        }

        System.out.println(WordBreak("ilikesamsung"));
    }

}
