

public class conerrtNUMintoString {
    static String digit[]={"zero", "one", "two", "three", "four", "five","six", "seven", "eight", "nine"};

    public static void convert(int n){
        if(n==0){
            return;
        }else{
            int lastDigit=n%10;
            convert(n/10);
            System.out.print(digit[lastDigit] + " ");
        }
    }
    public static void main(String[] args) {
        convert(1090);
    }
}
