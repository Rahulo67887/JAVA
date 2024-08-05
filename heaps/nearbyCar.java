import java.util.*;

public class nearbyCar {
    static class Point implements Comparable<Point> {
        int x;
        int y;
        int dis;
        int idx;

        Point(int x, int y, int dis, int idx){
            this.x = x;
            this.y = y;
            this.dis = dis;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point P2){
            return this.dis-P2.dis;
        }
    }

    public static void main(String[] args) {
        int arr[][]={{3,3}, {5,-1}, {-2,4}};
        int k=2;
        PriorityQueue<Point> pq=new PriorityQueue<>();

        for(int i=0; i<arr.length; i++){
            pq.add(new Point(arr[i][0], arr[i][1], arr[i][0]*arr[i][0] + arr[i][1]*arr[i][1], i));
        }

        for(int i=0; i<k; i++){
            System.out.print("C" + pq.remove().idx + " ");
        }
    }
}
