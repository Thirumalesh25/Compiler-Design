import java.util.*;

public class Operator_Parser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("No. of terminals: ");
        int n = sc.nextInt();
        sc.nextLine();

        System.out.print("Terminals: ");
        String t = sc.nextLine();

        String stk = "";
        String[][] p = new String[n][n];

        System.out.println("Precedence Table: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                p[i][j] = sc.next();
            }
        }

        System.out.println("OPERATOR PRECEDENCE TABLE:");
        System.out.print("\t");
        for (int i = 0; i < n; i++) {
            System.out.print(t.charAt(i) + "\t");
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.print(t.charAt(i) + "\t");
            for (int j = 0; j < n; j++) {
                System.out.print(p[i][j] + "\t");
            }
            System.out.println();
        }

        stk += "$";
        System.out.print("String: ");
        String inp = sc.next();
        inp += "$";

        System.out.println("STACK\t\tINPUT STRING\t\tACTION");
        System.out.println(stk + "\t\t" + inp + "\t\t");

        while (!stk.equals("$") || !inp.equals("$")) { 
            String c1 = stk.charAt(stk.length() - 1) + "";
            String c2 = inp.charAt(0) + "";
            int i1 = t.indexOf(c1);
            int i2 = t.indexOf(c2);
            
            if (p[i1][i2].equals("<")) { 
                stk += c2;
                inp = inp.substring(1);
                System.out.println(stk + "\t\t" + inp + "\t\tShift " + c2);
            } else {
                stk = stk.substring(0, stk.length() - 1);
                System.out.println(stk + "\t\t" + inp + "\t\tReduce");
            }
        }
        System.out.println("String Accepted.");
    }
}
