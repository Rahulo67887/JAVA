public class numTostring {
    static String digits[]={"zero ", "one ","two ", "three ", "four ", "five ", "six ", "seven ", "eight ", "nine "};

    public static void printDigits(int num){
        if(num==0){
            return;
        }
        int lastNum=num%10;
        printDigits(num/10);
        System.out.print(digits[lastNum]);
    }

    public static void main(String args[]){
        printDigits(431278932);
    }
}
