public class MinPartition {

    public static int minPartition(int arr[]){
        int n=arr.length;
        int sum=0; 
        for(int i=0; i<arr.length; i++){
            sum+=arr[i];
        }

        int dp[][]=new int[n+1][(sum/2)+1];

        for(int i=1; i<n+1; i++){
            for(int j=1; j<(sum/2)+1; j++){
                if(arr[i-1]<=j){
                    dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-arr[i-1]] + arr[i-1]);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        int sum1=dp[n][sum/2];
        int sum2=sum-sum1;
        return Math.abs(sum2-sum1);
    }
    
    public static void main(String[] args) {
        int nums[]={1,6,11,5};
        System.out.println(minPartition(nums));
    }

}
