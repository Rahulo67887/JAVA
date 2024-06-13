import java.util.Scanner;

public class oddEvenSum {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int number, choice, oddsum=0, evenSum=0;
        do{
            System.out.println("Enter number:");
            number=sc.nextInt();
            
            if(number%2==0){
                evenSum+=number;
            }else{
                oddsum+=number;
            }

            System.out.println("Do you want to continue?(press 1 for yes and 0 for no) : ");
            choice=sc.nextInt();
        }while(choice==1);

        System.out.println("Sum of even numbers : " + evenSum);
        System.out.println("Sum of odd numbers : " + oddsum);
    }
}
