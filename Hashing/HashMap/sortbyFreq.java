import java.util.*;

public class sortbyFreq {

    public static void sort(String s){
        TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }
            else{
                map.put(c, 1);
            }
        }

        TreeMap<Integer , Character> res = new TreeMap<>();
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            res.put(entry.getValue(), entry.getKey());
        }

        for(Map.Entry<Integer, Character> entry : res.entrySet()){
            System.out.print(entry.getValue() + " ");
        }



    }
    
    public static void main(String[] args) {
        sort("tree");
    }

}
