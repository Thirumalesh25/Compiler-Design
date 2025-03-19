import java.util.*;

public class ICG {

    static int val(char c) {
    switch (c) {
        case '+':
        case '-':
            return 1;
        case '*':
        case '/':
            return 2;
        case '^':
            return 3;
        case '(':
            return 4;
        default:
            return -1;
    }
}


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Arithmetic Exp : ");
        String exp = sc.next();
        String ans = "";

        Stack<Character> s = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (val(ch) == -1) {
                ans += ch;
            } else if (s.isEmpty() || val(ch) > val(s.peek())) {
                s.push(ch);
            } else {
                while (!s.isEmpty() && val(ch) <= val(s.peek())) {
                    ans += s.pop();
                }
                s.push(ch);
            }
        }

        while (!s.isEmpty()) {
            ans += s.pop();
        }

        Stack<String> s1 = new Stack<>();
        int j = 0;

        for (int i = 0; i < ans.length(); i++) {
            char ch = ans.charAt(i);

            if (val(ch) != -1) {
                String l1 = s1.pop();
                String l2 = s1.pop();
                System.out.println("t" + j + " = " + l2 + ch + l1);
                s1.push("t" + j);
                j++;
            } else {
                s1.push(ch + "");
            }
        }
    }
}
