import java.util.*;

public class First {
    static String[] prod, nT;
    static Map<String, String> first = new LinkedHashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("No. of productions: ");
        int n = sc.nextInt();
        sc.nextLine(); 
        prod = new String[n];
        nT = new String[n];

        System.out.println("Grammar: ");
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[] p = s.split("->");
            nT[i] = p[0];
            prod[i] = p[1];
        }

        for (int i = n - 1; i >= 0; i--) {
            first.put(nT[i], F(prod[i]));
        }
        
        for (String k : first.keySet()) {
            System.out.println(k+"->"+first.get(k));
        }
        
    }

    static String F(String s) {
        String[] rules = s.split("/");
        String t="";
        for (String r : rules) {
            int k = 0;
            char ch = r.charAt(k);
            while (k<r.length()) {
                if (ch < 'A' || ch > 'Z') {t+=ch; break;}
                else if(k<r.length()-1 && first.get(ch+"").contains("@")) {
                    t+=first.get(ch+"").replace("@", "");
                }
                else{
                    t+=first.get(ch+"");
                    break;
                }
                k++;
                ch = r.charAt(k);
            }
        }
        return t;
    }
}
