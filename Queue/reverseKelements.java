import java.util.*;

public class reverseKelements {

    public static void reverse(Queue<Integer> q, int k){
        Stack<Integer> s =new Stack();
        int i=0;
        while(i<k){
            s.push(q.remove());
            i++;
        }

        int f=s.peek();

        while(!s.empty()){
            q.add(s.pop());
        }

        while (q.peek()!=f) {
            q.add(q.remove());
        }
    }
    
    public static void main(String[] args) {
        Queue<Integer> q=new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        q.add(60);
        q.add(70);
        q.add(80);
        q.add(90);
        q.add(100);
        System.out.println(q);
        reverse(q, 5);
        System.out.println(q);
    }

}
