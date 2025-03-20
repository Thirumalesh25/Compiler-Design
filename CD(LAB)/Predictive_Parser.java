import java.util.*;

class Predictive_Parser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("No. of Non-Terminals: ");
        int n1 = sc.nextInt();
        sc.nextLine();
        System.out.print("Non-Terminals: ");
        String nt = sc.nextLine();

        System.out.print("No. of Terminals: ");
        int n2 = sc.nextInt();
        sc.nextLine();
        System.out.print("Terminals: ");
        String t = sc.nextLine();

        System.out.println("Precedence Table: ");
        String[][] table = new String[n1][n2];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                table[i][j] = sc.next();
            }
        }

        System.out.println("PARSE TABLE:");
        System.out.print("\t");
        for (int i = 0; i < n2; i++) {
            System.out.print(t.charAt(i) + "\t");
        }
        System.out.println();
        for (int i = 0; i < n1; i++) {
            System.out.print(nt.charAt(i) + "\t");
            for (int j = 0; j < n2; j++) {
                System.out.print(table[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.print("String: ");
        String inp = sc.next() + "$";
        String stk = "$" + nt.charAt(0);

        System.out.println("STACK\t\tINPUT\t\tACTION");
        System.out.println(stk + "\t\t" + inp + "\t\t");
        while (!stk.isEmpty()) {
            String c1 = stk.charAt(stk.length() - 1)+"";
            String c2 = inp.charAt(0)+"";

            if (c1.equals(c2)) {
                inp = inp.substring(1);
                stk = stk.substring(0, stk.length() - 1);
                System.out.println(stk + "\t\t" + inp + "\t\tPOP " + c1);
                continue;
            }
            int i1 = nt.indexOf(c1);
            int i2 = t.indexOf(c2);
            if (table[i1][i2].equals("X")) {
                System.out.println("Not Accepted.");
                break;
            }
            stk = stk.substring(0, stk.length() - 1);
            if (table[i1][i2].equals("@")) continue;
            StringBuilder sb = new StringBuilder(table[i1][i2]);
            stk += sb.reverse().toString();
            System.out.println(stk + "\t\t" + inp + "\t\t" + c1 + "->" + table[i1][i2]);
        }
        if (stk.isEmpty()) System.out.println("Accepted.");
        sc.close();
    }
}
