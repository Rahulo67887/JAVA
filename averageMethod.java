import java.util.Scanner;

public class averageMethod {
    
    public static int average(int n1, int n2, int n3){
        return (n1+n2+n3)/3;
    }
    public static void main(String args[]){
        int n1, n2, n3;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter three numbers : ");
        n1=sc.nextInt();
        n2=sc.nextInt();
        n3=sc.nextInt();
        System.out.print("Average of given numbers is : " + average(n1,n2,n3));



    }
}
