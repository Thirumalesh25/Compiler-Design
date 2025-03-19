import java.util.*;

public class Predictive_Parser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("No. of terminals: ");
        int n1 = sc.nextInt();
        sc.nextLine();
        System.out.print("Terminals : ");
        String t = sc.nextLine();        
        
        System.out.print("No. of non-terminals: ");
        int n2 = sc.nextInt();
        sc.nextLine();
        System.out.print("Non-terminals : ");
        String nt = sc.nextLine();

        String[][] p = new String[n2][n1];

        System.out.println("Predictive Parsing Table : ");
        for (int i = 0; i < n2; i++) {
            for (int j = 0; j < n1; j++) {
                p[i][j] = sc.next();
            }
        }

        System.out.println("PREDICTIVE PARSING TABLE : ");
        System.out.print("\t");
        for (int i = 0; i < n1; i++) {
            System.out.print(t.charAt(i) + "\t");
        }
        System.out.println();

        for (int i = 0; i < n2; i++) {
            System.out.print(nt.charAt(i) + "\t");
            for (int j = 0; j < n1; j++) {
                System.out.print(p[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.print("Input String : ");
        String inp = sc.next() +"$"; 

        String stk="$"+nt.charAt(0);

        System.out.println("\nSTACK\t\tINPUT \t\tACTION");
        while (stk.length()!=0) {
            String c1 = stk.charAt(stk.length()-1)+"";
            String c2 = inp.charAt(0)+"";
            if(c1.equals(c2)) {
                stk=stk.substring(0,stk.length()-1);
                inp=inp.substring(1);
                System.out.println(stk + "\t\t" + inp + "\t\t");
                continue;
            }
            int i1 = nt.indexOf(c1);
            int i2 = t.indexOf(c2);
            System.out.println(stk + "\t\t" + inp + "\t\t"+c1+"->"+p[i1][i2]);


            if (p[i1][i2].equals("X")) {
                System.out.println("Not Accepted"); 
                break;
            }
            else{
                if(p[i1][i2].equals("@")){
                    stk=stk.substring(0,stk.length()-1);
                    continue;
                }
                StringBuilder sb=new StringBuilder(p[i1][i2]);
                stk=stk.substring(0,stk.length()-1);
                stk+=sb.reverse().toString();
            }
        }
        if (stk.isEmpty()) System.out.println("String Accepted.");
    }
}