import java.util.*;

public class climbingStairs {

    public static int countWaysRec(int n){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }

        return countWaysRec(n-1) + countWaysRec(n-2);
    }

    public static int countWaysMemo(int n, int ways[]){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }

        if(ways[n]!=-1){
            return ways[n];
        }

        return ways[n]=countWaysMemo(n-1, ways) + countWaysMemo(n-2, ways);
    }

    public static int countWaysTabu(int n){
        int ways[]=new int[n+1];
        ways[0]=1;

        for(int i=1; i<=n; i++){
            if(i==1){
                ways[i]=ways[i-1];
            }
            else{
                ways[i]=ways[i-1]+ways[i-2];
            }
        }

        return ways[n];
    }
    
    public static void main(String[] args) {
        int n=5;
        int ways[]=new int [n+1];
        Arrays.fill(ways, -1);
        System.out.println(countWaysMemo(n, ways));
    }

}
