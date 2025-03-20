import java.util.*;

public class Follow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("No. of productions: ");
        int n = sc.nextInt();
        System.out.print("No. of non-Terminals: ");
        int n1 = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Non-Terminals: ");
        String nt = sc.nextLine();
        
        String[] first = new String[n1];
        String[] follow = new String[n1];

        for (int i = 0; i < n1; i++) {
            System.out.print("First(" + nt.charAt(i) + ") : ");
            first[i] = sc.nextLine();
            follow[i] = "";  
        }
        follow[0] = "$";  
        
        System.out.println("Grammar: ");
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[] p = s.split("->");
            String lhs = p[0];
            String rhs = p[1];  

            for (int j = 0; j < rhs.length(); j++) {  
                String ch = rhs.charAt(j) + "";
                if (ch.charAt(0) < 'A' || ch.charAt(0) > 'Z') continue; 
                
                int i1 = nt.indexOf(ch);
                if (j == rhs.length() - 1) {
                    follow[i1] += follow[nt.indexOf(lhs)];
                } else {
                    String nch = rhs.charAt(j + 1) + "";

                    if (nch.charAt(0) < 'A' || nch.charAt(0) > 'Z') { 
                        follow[i1] += nch;
                    } else {
                        follow[i1] += first[nt.indexOf(nch)];
                    }
                }
            }
        }
        System.out.println();
        for (int i = 0; i < n1; i++) {
            System.out.println(nt.charAt(i) + " -> " + follow[i]);
        }
    }
}
