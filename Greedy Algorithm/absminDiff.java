import java.util.*;
public class absminDiff {
    
    public static void main(String[] args) {
        int A[]={1,2,3};
        int B[]={3,1,2};
        
        Arrays.sort(A);
        Arrays.sort(B);

        int mindiff=0;

        for(int i=0; i<A.length; i++){
            mindiff+=Math.abs(A[i]-B[i]);
        }

        System.out.println("Minimum absolute difference is : " + mindiff);
    }

}
