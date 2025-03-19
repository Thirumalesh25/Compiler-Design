import java.util.*;

public class Lexical_Analyzer {

    public static boolean isKeyword(String str) {
        Set<String> key = new HashSet<>(Arrays.asList(
        "if","else","while","do","break","continue","int","void"));
        return key.contains(str);
    }

    public static void print(String message) {
        System.out.println(message);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();

        int s = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (";,+-/*=<>(){}[] ".contains(ch + "")) {
                String tk = str.substring(s, i).trim();

                if (!tk.isEmpty()) {
                    if (isKeyword(tk)) {
                        print("KEYWORD: " + tk);
                    } else if (Character.isDigit(tk.charAt(0))) {
                        print("INVALID: " + tk);
                    } else {
                        print("IDENTIFIER: " + tk);
                    }
                }

                s = i + 1;
                if (ch == ' ') continue;

                if ("+-*/><=".contains(ch + "")) {
                    print("OPERATOR: " + ch);
                } else {
                    print("DELIMITER: " + ch);
                }
            }
        }
    }
}
