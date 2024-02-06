import java.util.Scanner;

public class isEven {
    public static boolean isEven(int num){
        if(num%2!=0){
            return false;
        }
        return true;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a number : ");
        int n=sc.nextInt();
        if(isEven(n)){
            System.out.print("Entered number is even");
        }
        else{
            System.out.print("Entered number is odd");
        }
    }
}
