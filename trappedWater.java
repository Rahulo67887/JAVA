import java.util.*;

public class trappedWater {
    public static int trappedWater(int height[]){
        int n=height.length;
        int lmx[]=new int[n];
        lmx[0]=height[0];
        for(int i=1; i<n; i++){
            lmx[i]=Math.max(lmx[i-1], height[i]);
        }
        int rmx[]=new int [n];
        rmx[n-1]=height[n-1];
        for(int i=n-2; i>=0; i--){
            rmx[i]=Math.max(rmx[i+1], height[i]);
        }
        int trappedWater=0;
        for(int i=0; i<n; i++){
            int waterlevel=Math.min(lmx[i], rmx[i]);
            //trappedWater+=(Math.min(lmx[i], rmx[i]))-height[i];
            trappedWater+=waterlevel-height[i];
        }
        return trappedWater;
    }
    public static void main(String args[]){
        int height[]={4,2,6,3,2,5};
        System.out.println("Total Trapped Water is " + trappedWater(height));
    }
}
