import java.util.*;

public class Shift_Reduce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("No.of production : ");
        int n = sc.nextInt();
        sc.nextLine(); 
        String lhs[]=new String[n];
        String rhs[]=new String[n];

        System.out.println("Grammar : ");
        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().split("->");
            lhs[i]=p[0];
            rhs[i]=p[1];
        }
        
        System.out.print("String : ");
        String inp = sc.nextLine();

        System.out.println("\nStack\tInputBuffer\tAction");
        String stk="";
        int l=inp.length();
        while (true) {
            char ch = inp.charAt(0);
            stk += ch;
            inp=inp.substring(1);
            System.out.println(stk + "\t\t" + inp+"\t\tShift " + ch);

            for (int j = 0; j < n; j++) {
                int idx = stk.indexOf(rhs[j]);
                if (idx != -1) {
                    stk = stk.substring(0, idx) + lhs[j];
                    System.out.println(stk+"\t\t"+inp+"\t\tReduce " + lhs[j] + "->" + rhs[j]);
                    j = -1; 
                }
            }

            if (stk.equals(lhs[0]) && inp.length()==0) {
                System.out.println("Accepted");
                break;
            }
            if (inp.length()==0) {
                System.out.println("Not Accepted");
                break;
            }
        }
    }
}