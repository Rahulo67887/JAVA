import java.util.*;

public class paranthesis {
    public static boolean validParanthesis(String str){
        Stack<Character> s= new Stack<>();

        for(int i=0; i<str.length(); i++){
            char ch=str.charAt(i);
            if(ch=='(' || ch=='{' || ch=='['){
                s.push(ch);
            }
            else{
                if(s.isEmpty()){
                    return false;
                }
                if(s.peek()=='(' && ch==')' 
                || s.peek()=='{' && ch=='}'
                || s.peek()=='[' && ch==']' )
                {
                    s.pop();
                }
            } 
        }

        if(s.isEmpty()){
            return true;
        }

        return false;
    }

    public static boolean duplicateParanthesis(String str){
        Stack<Character> s= new Stack<>();
        for(int i=0; i<str.length(); i++){
            char ch=str.charAt(i);
            if(ch=='('){
                s.push(ch);
            }
            else{
                int count=0;
                if(s.peek()!='('){
                    s.pop();
                    count++;
                }
                if(count<1){
                    return false;
                }
                else{
                    s.pop();
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(duplicateParanthesis("((a+b))"));
        System.out.println(validParanthesis("((a+b))"));
    }
}
