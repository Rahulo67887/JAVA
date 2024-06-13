import java.util.Scanner;

public class patterns {
    public static void main(String args[]){
        System.out.println("Press:\n" + "1 for diamond pattern\n" + 
        "2 for hollowRhombus pattern\n" +
        "3 for rhombus pattern\n" +
        "4 for triangle pattern\n" +
        "5 for Butterfly pattern\n" +
        "6 for FLOYDsTriangle pattern\n" +
        "7 for hollowRectangle pattern\n" +
        "8 for invertedPyramid pattern\n" +
        "9 for invertedHalfPyramid pattern\n" + 
        "10 for palindromicPatternwithNums\n" + 
        "11 for numberPyramid");

        Scanner sc= new Scanner(System.in);
        int n=0, rows=0, columns=0;

        int choice=sc.nextInt();
        if(choice==7){
            System.out.print("How many rows and columns do you want to print:");
            rows=sc.nextInt();
            columns=sc.nextInt();
        }else{
            System.out.print("How many lines do you want to print:");
            n=sc.nextInt();
        }

        switch(choice){
            case 1:
                diamond(n);
                break;
            case 2:
                hollowRhombus(n);
                break;
            case 3:
                rhombus(n);
                break;
            case 4:
                triangle(n);
                break;
            case 5:
                Butterfly(n);
                break;
            case 6:
                FLOYDsTriangle(n);
                break;
            case 7:
                hollowRectangle(rows, columns);
                break;
            case 8:
                invertedPyramid(n);
                break;
            case 9:
                invertedHalfPyramid(n);
                break;
            case 10:
                palindromicPatternwithNums(n);
                break;
            case 11:
                numberPyramid(n);
                break;
            default:
                System.out.print("Enter a valid input");
        }
    }

    public static void numberPyramid(int n){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n-i; j++){
                System.out.print(" ");
            }
            for(int j=1; j<=i; j++){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void palindromicPatternwithNums(int n){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=(n-i); j++){
                System.out.print(" ");
            }
            for(int j=i; j>=1; j--){
                System.out.print(j);
            }
            for(int j=2; j<=i; j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void  diamond(int n){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=(n-i); j++){
                System.out.print(" ");
            }
            for(int j=1; j<=(2*i)-1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=n; i>=1; i--){
            for(int j=1; j<=(n-i); j++){
                System.out.print(" ");
            }
            for(int j=1; j<=(2*i)-1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void hollowRhombus(int n){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=(n-i); j++){
                System.out.print(" ");
            }
            for(int j=1; j<=n; j++){
                if(i==1 || i==n || j==1 ||j==n){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println(" ");
        }
    }

    public static void rhombus(int n){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=(n-i); j++){
                System.out.print(" ");
            }
            for(int j=1; j<=n; j++){
                System.out.print("*");
            }
            System.out.println(" ");
        }
    }

    public static void triangle(int n){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                if((i+j)%2==0){
                    System.out.print("1");
                }else{
                    System.out.print("0");
                }
            }
            System.out.println(" ");
        }
    }

    public static void Butterfly(int n){

        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                System.out.print("*");
            }
            for(int j=1; j<=2*(n-i); j++){
                System.out.print(" ");
            }
            for(int j=1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println(' ');
        }
        for(int i=n; i>=1; i--){
            for(int j=1; j<=i; j++){
                System.out.print("*");
            }
            for(int j=1; j<=2*(n-i); j++){
                System.out.print(" ");
            }
            for(int j=1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println(' ');
        }
    }

    public static void FLOYDsTriangle(int n){
        int num=1;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                System.out.print(num + " ");
                num++;
            }
            System.out.println(" ");
        }
    }

    public static void hollowRectangle(int rows, int col){
        for(int i=1; i<=rows; i++){
            for(int j=1; j<=col; j++){
                if(i==1 || i==rows || j==1 || j==col){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println(" ");
        }
    }

    public static void invertedPyramid(int n){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n-i; j++){
                System.out.print(" ");
            }
            for(int j=1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println(' ');
        }
    }

    public static void invertedHalfPyramid(int n){
        for(int i=0; i<n; i++){
            for(int j=1; j<=n-i; j++){
                System.out.print(j);
            }
            System.out.println(' ');
        }
    }
}