import java.util.*;

public class mergeKsortedLL {

    public static LinkedList<Integer> mergeKsorted(LinkedList<Integer> l1, LinkedList<Integer> l2, LinkedList<Integer> l3){
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();

        while(!l1.isEmpty()){
            pq.add(l1.poll());
        }
        while(!l2.isEmpty()){
            pq.add(l2.poll());
        }
        while(!l3.isEmpty()){
            pq.add(l3.poll());
        }

        LinkedList<Integer> result = new LinkedList<>();
        while(!pq.isEmpty()){
            result.add(pq.poll());
        }
        return result;
    }
    
    public static void main(String[] args) {
        LinkedList<Integer> l1 = new LinkedList<>(Arrays.asList(1, 3, 7));
        LinkedList<Integer> l2 = new LinkedList<>(Arrays.asList(2, 4, 8));
        LinkedList<Integer> l3 = new LinkedList<>(Arrays.asList(9, 11, 12));

        LinkedList<Integer> mergedList = mergeKsorted(l1, l2, l3);
        System.out.println(mergedList); // Output: [1, 2, 3, 4, 7, 8, 9, 11, 12]
    }

}
