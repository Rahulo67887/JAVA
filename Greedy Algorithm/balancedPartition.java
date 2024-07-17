import java.util.*;

class balancedPartition {
    static int BalancedPartition(String str, int n){
        if (n == 0)
            return 0;

        int r = 0, l = 0;
        int ans = 0;

        for(int i = 0; i < n; i++) {
            if (str.charAt(i) == 'R'){
                r++;
            }
            else if (str.charAt(i) == 'L'){
                l++;
            }
            if (r == l){
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        String str = "LLRRRLLRRL";
        int n = str.length();
        System.out.print(BalancedPartition(str, n) + "\n");

        System.out.print(BalancedPartition(str, n-1) + "\n");

        System.out.print(BalancedPartition(str, n-2) + "\n");

        System.out.print(BalancedPartition(str, n-3) + "\n");

        System.out.print(BalancedPartition(str, n-4) + "\n");

        System.out.print(BalancedPartition(str, n-5) + "\n");

        System.out.print(BalancedPartition(str, n-6) + "\n");

        System.out.print(BalancedPartition(str, n-7) + "\n");

        System.out.print(BalancedPartition(str, n-8) + "\n");
    }

}