import java.util.*;

public class queueBYstack {

    static class queue{
        static Stack<Integer> s1= new Stack<>();
        static Stack<Integer> s2= new Stack<>();

        public static boolean isEmpty(){
            return s1.isEmpty();
        }

        public static void add(int data){
            s1.push(data);
        }

        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }

            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }

            int data=s2.pop();

            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }

            return data;
        }

        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }

            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }

            int data=s2.peek();

            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }

            return data;
        }
    }
    
    public static void main(String[] args) {
        queue q= new queue();
        q.add(1);
        q.add(2);
        q.add(3);

        System.out.println(q.peek());
        System.out.println(q.remove());
        
        while(!q.isEmpty()){
            System.out.println(q.remove());
        }

    }

}
