public class keypad {

    static char[][] keypadWord={{}, {}, {'a','b','c'}, {'d','e','f'}, {'g','h','i'}, {'j','k','l'}, {'m','n','o'}, {'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};

    public static void message(String digit, String message){
        if(digit.isEmpty()){
            System.out.println(message);
            return;
        }
        message(digit, message+keypadWord[digit[1]][]);
    }

    public static void main(String[] args) {
        
    }
}
