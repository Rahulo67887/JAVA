import java.util.*;

public class KthLargestinStream {
    static PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
    static int K;

    public static void KthLargest(int k, int arr[]) {
        K = k;
        for(int i : arr){
            add(i);
        }
    }

    public static void add(int val){
        pq.add(val);
        if(pq.size() > K){
            pq.poll();
        }
        if(pq.size()<K){
            System.out.print("-1 ");
            return;
        }
        System.out.print(pq.peek() + " ");
    }

    public static void main(String[] args) {
        int arr[]={4,5,8,2};
        KthLargest(3, arr);
        add(3);
        add(5);
        add(10);
        add(9);
        add(4);
        
    }
}
