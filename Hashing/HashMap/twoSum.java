import java.util.*;

public class twoSum {

    public static int[] twosum(int[] a, int target){
        Map<Integer, Integer> visited=new HashMap<Integer, Integer>();

        for(int i=0; i<a.length; i++){
            int diff=target-a[i];
            if(visited.containsKey(diff)){
                return new int[]{i, visited.get(diff)};
            }
            visited.put(a[i], i);
        }

        return new int[]{0,0};
    }
    
    public static void main(String[] args) {
        int arr[]={3,2,4};
        int idx[]=twosum(arr, 6);
        for(int i : idx){
            System.out.print(i + " ");
        }
    }

}
