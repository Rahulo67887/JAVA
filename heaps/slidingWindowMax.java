import java.util.PriorityQueue;

public class slidingWindowMax {

    static class Pair implements Comparable<Pair>{
        int val;
        int idx;

        Pair(int val, int idx){
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair P2) {
            return P2.val-this.val;
        }
    }
    
    public static void main(String[] args) {
        int arr[]={1,3,-1,-3,5,3,6,7};
        int k = 3;

        PriorityQueue<Pair> pq=new PriorityQueue<Pair>();
        for(int i=0; i<k; i++){
            pq.add(new Pair(arr[i], i));
        }

        int res[]=new int[arr.length-k+1];
        res[0]=pq.peek().val;

        for(int i=k; i<arr.length; i++){
            while(i<arr.length && pq.peek().idx<=(i-k)){
                pq.remove();
            }

            pq.add(new Pair(arr[i], i));
            res[i-k+1]=pq.peek().val;
        }

        for(int i=0; i<res.length; i++){
            System.out.print(res[i] + " ");
        }
    }

}
