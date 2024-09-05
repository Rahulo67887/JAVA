

public class knapSack {

    public static int knapsack(int wt[], int val[], int w, int n, int dp[][]){
        if(n==0 || w==0){
            return 0;
        }

        if(dp[n][w]!=-1){
            return dp[n][w];
        }

        if(w>=wt[n-1]){
            int ans1=val[n-1]+knapsack(wt, val, w-wt[n-1], n-1, dp);
            int ans2=knapsack(wt, val, w, n-1, dp);
            return dp[n][w]=Math.max(ans1, ans2);
        }
        else{
            return dp[n][w]=knapsack(wt, val, w, n-1, dp);
        }
    }

    public static int knapsackTab(int wt[], int val[], int W){
        int n=val.length;
        int dp[][]=new int[n+1][W+1];
        for(int i=0; i<dp.length; i++){
            dp[i][0]=0;
        }
        for(int i=0; i<dp[0].length; i++){
            dp[0][i]=0;
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<W+1; j++){
                int v=val[i-1];
                int w=wt[i-1];

                if(w<=j){
                    int incProfit=v+dp[i-1][j-w];
                    int excProfit=dp[i-1][j];
                    dp[i][j]=Math.max(incProfit, excProfit);
                }
                else{
                    int excProfit=dp[i-1][j];
                    dp[i][j]=excProfit;
                }
            }
        }

        return dp[n][W];
    }
    
    public static void main(String[] args) {
        int val[]={15,14,10,45,30};
        int wt[]={2,5,1,3,4};
        int w=7;
        int dp[][]=new int[val.length+1][w+1];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(knapsackTab(wt, val, w));
    }

}
