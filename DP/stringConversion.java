public class stringConversion {

    public static void noOfsteps(String s1, String s2){
        int c=LCS(s1, s2);
        int del = s1.length()-c;
        del = del<0 ? 0 : del;
        int insert = s2.length()-c;
        insert = insert<0 ? 0 : insert;

        System.out.println("For string conversion, delete operations : " + del + ", insert operations : " + insert + "");
    }

    public static int LCS(String str1, String str2){
        int n=str1.length();
        int m=str2.length();
        int dp[][]=new int[n+1][m+1];
        for(int i=0; i<n+1; i++){
            for(int j=0; j<m+1; j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
            }
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1] + 1;
                }
                else{
                    int ans1=dp[i-1][j];
                    int ans2=dp[i][j-1];
                    dp[i][j]=Math.max(ans1, ans2);
                }
            }
        }

        return dp[n][m];
    }
    
    public static void main(String[] args) {
        noOfsteps("abcdef", "aceg");
    }

}
