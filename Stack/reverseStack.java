import java.util.*;

public class reverseStack {

    public static void pushATbottom(Stack s, int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top=s.pop();
        pushATbottom(s, data);
        s.push(top);
    }

    public static void reverse(Stack s){
        if(s.isEmpty()){
            return;
        }
        int top=s.pop();
        reverse(s);
        pushATbottom(s, top);
    }

    public static void main(String[] args) {
        Stack<Integer> s= new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println(s);
    }
    
} 

