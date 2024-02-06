import java.util.Scanner;

public class checkPalindrome {
    public static boolean checkPalindrome(int n){
        int plndrm=0;
        int copy=n;
        while(n>0){
            int lstDgt=n%10;
            plndrm=plndrm*10+lstDgt;
            n=n/10;
        }
        if(plndrm==copy){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        if(checkPalindrome(n)){
            System.out.print("Entered number is palindrome");
        }else{
            System.out.print("Entered number is not palindrome");
        }
    }
}
