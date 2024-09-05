import java.util.Arrays;

public class MCM {

    public static int mcmRec(int i, int j, int arr[]){
        if(i==j){
            return 0;
        }

        int ans=Integer.MAX_VALUE;

        for(int k=i; k<=j-1; k++){
            int ans1=mcmRec(i, k, arr);
            int ans2=mcmRec(k+1, j, arr);
            int ans3=arr[i-1]*arr[k]*arr[j];
            int finalCost=ans1+ans2+ans3;
            ans=Math.min(ans, finalCost);
        }

        return ans;
    }

    public static int mcmMemo(int i, int j, int arr[], int dp[][]){
        if(i==j){
            return 0;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int ans=Integer.MAX_VALUE;

        for(int k=i; k<=j-1; k++){
            int ans1=mcmMemo(i, k, arr, dp);
            int ans2=mcmMemo(k+1, j, arr, dp);
            int ans3=arr[i-1]*arr[k]*arr[j];
            int finalCost=ans1+ans2+ans3;
            ans=Math.min(ans, finalCost);
        }

        return dp[i][j]=ans;
    }

    public static int mcmTab(int arr[]){
        int n=arr.length;
        int dp[][]=new int[n][n];

        for(int i=0; i<n; i++){
            dp[i][i]=0;
        }

        for(int len=2; len<n; len++){
            for(int i=1; i<=n-len; i++){
                int j=i+len-1;
                dp[i][j]=Integer.MAX_VALUE;
                for(int k=i; k<j; k++){
                    int cost1=dp[i][k];
                    int cost2=dp[k+1][j];
                    int cost3=arr[i-1]*arr[k]*arr[j];
                    dp[i][j]=Math.min(cost1 + cost2 + cost3, dp[i][j]);
                }
            }
        }
        return dp[1][n-1];
            
    }
    
    public static void main(String[] args) {
        int arr[]={1,2,3,4,3};
        int dp[][]=new int[arr.length][arr.length];
        for(int a[] : dp){
            Arrays.fill(a, -1);
        }
        System.out.println(mcmTab(arr));
    }

}
