import java.util.*;

public class stockSpan {
    
    public static void span(int stocks[], int spans[]){
        Stack<Integer> s=new Stack<>();
        spans[0]=1;
        s.push(0);

        for(int i=1; i<stocks.length; i++){
            int currprice=stocks[i];
            while(!s.isEmpty() && stocks[s.peek()]<currprice){
                s.pop();
            }
            if(s.isEmpty()){
                spans[i]=i+1;
            }
            else{
                int prevhigh=s.peek();
                spans[i]=i-prevhigh;
            }
            s.push(i);
        }
    }

    public static void main(String[] args) {
        int stock[]={100, 80, 60, 70, 60, 85, 100};
        int span[]=new int[7];
        span(stock, span);
    }
}
