import java.util.*;

public class maxArea {

    public static int maxarea(int arr[]){
        int maxar=0;
        int nsr[]=new int[arr.length];
        int nsl[]=new int[arr.length];

        Stack<Integer> s=new Stack<>();

        for(int i=arr.length-1; i>=0; i--){
            while(!s.empty() && arr[s.peek()]>=arr[i]){
                s.pop();
            }
            if(s.empty()){
                nsr[i]=arr.length;
            }
            else{
                nsr[i]=s.peek();
            }
            s.push(i);
        }

        s=new Stack<>();

        for(int i=0; i<arr.length; i++){
            while(!s.empty() && arr[s.peek()]>=arr[i]){
                s.pop();
            }
            if(s.empty()){
                nsl[i]=-1;
            }
            else{
                nsl[i]=s.peek();
            }
            s.push(i);
        }

        for(int i=0; i<arr.length; i++){
            int width=nsr[i]-nsl[i]-1;
            int currAr=arr[i]*width;
            maxar=Math.max(currAr, maxar);
        }

        return maxar;
    }

    public static void main(String[] args) {
        int length[]={2,4};
        System.out.println("Maximum area in histograph : " + maxarea(length));
    }
}
