import java.util.Arrays;

public class MinJumps {

    public static int minJumps(int nums[]){
        int n=nums.length;
        int dp[]=new int[n];
        Arrays.fill(dp, -1);
        dp[n-1]=0;

        for(int i=n-1; i>=0; i--){
            int ans=Integer.MAX_VALUE;
            for(int j=i+1; j<=i+nums[i] && j<n; j++){
                if(dp[j]!=-1){
                    ans=Math.min(ans, dp[j]+1);
                }
            }
            if(ans!=Integer.MAX_VALUE){
                dp[i]=ans;
            }
        }

        return dp[0];
    }
    
    public static void main(String[] args) {
        System.out.println(minJumps(new int[]{2,3,1,1,4}));
    }

}
