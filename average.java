import java.util.Scanner;

public class average {
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter two numbers");
        int a=sc.nextInt();
        int b=sc.nextInt();
        int average=(a+b)/2;
        System.out.println("Average is : " + average);
    }
}
