import java.util.*;

public class ItineryforTickets{

    public static String getStart(HashMap<String, String> map){
        HashMap<String, String> revmap = new HashMap<String, String>();

        for(String key : map.keySet()){
            revmap.put(map.get(key), key);
        }

        for(String key : map.keySet()){
            if(!revmap.containsKey(key)){
                return key;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        HashMap<String, String> tickets = new HashMap<String, String>();
        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        String start = getStart(tickets);
        System.out.print(start);

        for(String key : tickets.keySet()){
            System.out.print(" -> " + tickets.get(start));
            start=tickets.get(start);
        }
        System.out.println();
    }
}