import java.util.*;

public class dicpher {

    public static String decipher(String str) {
        Stack<Integer> counts = new Stack<>();
        Stack<String> resultStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);

            if (Character.isDigit(currentChar)) {
                k = k * 10 + (currentChar - '0'); // handle multi-digit numbers
            } else if (currentChar == '[') {
                counts.push(k);
                resultStack.push(currentString.toString());
                currentString = new StringBuilder();
                k = 0;
            } else if (currentChar == ']') {
                StringBuilder decodedString = new StringBuilder(resultStack.pop());
                int count = counts.pop();
                for (int j = 0; j < count; j++) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } else {
                currentString.append(currentChar);
            }
        }

        return currentString.toString();
    }

    public static void main(String[] args) {
        System.out.println(decipher("2[b2[v]]")); // Expected output: "bvvbvv"
    }
}
