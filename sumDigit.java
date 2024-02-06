import java.util.Scanner;

public class sumDigit {
    public static int sum(int n){
        int sum=0;
        while(n>0){
            sum+=n%10;
            n=n/10;
        }
        return sum;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a number : ");
        int n=sc.nextInt();
        System.out.print("Sum of the digits of "+ n + " is : " + sum(n));
    }
}
