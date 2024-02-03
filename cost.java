import java.util.Scanner;

public class cost{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter cost of pen : ");
        float pen=sc.nextFloat();
        System.out.println("Enter cost of pencil : ");
        float pencil=sc.nextFloat();
        System.out.println("Enter cost of eraser : ");
        float eraser=sc.nextFloat();
        float total=(pen + pencil + eraser);
        System.out.println("Total cost : " + total);
        total=(pen+pen*0.18f)+(pencil+pencil*0.18f)+(eraser+eraser*0.18f);
        System.out.println("Total cost with gst : " + total);

    }
}