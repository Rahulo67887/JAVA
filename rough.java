import java.util.*;

public class rough {
    public static int trappedWater(int height[]){
        int n = height.length;
        if (n == 0) return 0;

        int lmx[] = new int[n];
        int rmx[] = new int[n];
        
        // Compute left maximum heights
        lmx[0] = height[0];
        for(int i = 1; i < n; i++){
            lmx[i] = Math.max(lmx[i - 1], height[i]);
        }
        
        // Compute right maximum heights
        rmx[n - 1] = height[n - 1];
        for(int i = n - 2; i >= 0; i--){
            rmx[i] = Math.max(rmx[i + 1], height[i]);
        }
        
        int trappedWater = 0;
        for(int i = 0; i < n; i++){
            int waterLevel = Math.min(lmx[i], rmx[i]);
            trappedWater += waterLevel - height[i];
        }
        return trappedWater;
    }
    public static void main(String args[]){
        int height[] = {4, 2, 6, 3, 2, 5};
        System.out.println("Total Trapped Water is " + trappedWater(height));
    }
}
