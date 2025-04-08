import java.util.*;

public class First_Follow {
    static String[] first;
    static String[] follow; 
    static String nt;
    
    public static String removeDuplicate(String str) {
        boolean[] seen = new boolean[256];
        StringBuilder sb = new StringBuilder();
    
        for (char c : str.toCharArray()) {
            if (!seen[c]) {
                seen[c] = true;
                sb.append(c);
            }
        }
    
        return sb.toString();
    }
    
    static void getFollow(String lhs, String rhs){
        for (int j = 0; j < rhs.length(); j++) {
            char ch = rhs.charAt(j);
            if(ch<'A' || ch>'Z') continue;
            int idx = nt.indexOf(ch+"");
            if (j == rhs.length() - 1 || rhs.charAt(j+1)=='/') {
                follow[idx] += follow[nt.indexOf(lhs)];
                continue;
            }
            
            for (int k = j + 1; k < rhs.length(); k++) {
                char nch = rhs.charAt(k);
                if(nch=='/'){
                    follow[idx] += follow[nt.indexOf(lhs)];
                    break;
                }
                if (nch < 'A' || nch > 'Z') {
                    follow[idx] += nch;
                    break;
                }
                follow[idx] += first[nt.indexOf(nch+"")];
                if (follow[idx].contains("@")) {
                    follow[idx] = follow[idx].replace("@", "");
                    if(k==rhs.length()-1) 
                        follow[idx] += follow[nt.indexOf(lhs)];
                }
                else break;
                
            }
        }
    }
    
    static String getFirst(String s) {
        String[] rules = s.split("/");
        String t="";
        for (String r : rules) {
            for(int k=0;k<r.length();k++){
                char ch = r.charAt(k);
                int idx=nt.indexOf(ch+"");
                if (ch < 'A' || ch > 'Z') {
                    t+=ch;
                    break;
                }
                if(k<r.length()-1 && first[idx].contains("@")) {
                    t+=first[idx].replace("@", "");
                }
                else{
                    t+=first[idx];
                    break;
                }
            }
        }
        return t;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("No. of productions: ");
        int n = sc.nextInt();
        sc.nextLine();
        
        System.out.print("Non-Terminals: ");
        nt = sc.nextLine();
        
        first=new String[n];
        follow=new String[n];
        String[][] grmr = new String[n][2];
        System.out.println("Grammar: ");
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[] p = s.split("->");
            grmr[i][0] = p[0];
            grmr[i][1] = p[1];
            follow[i]="";
            first[i]="";
        }

        System.out.println("FIRST : ");
        for (int i = n - 1; i >= 0; i--) {
            first[i]= removeDuplicate(getFirst(grmr[i][1]));
        }
        for (int i = 0; i < n; i++) {
            System.out.println(nt.charAt(i) + " -> " + first[i]);
        }
        
        System.out.println("FOllow : ");
        follow[0]="$";
        for(int i=0;i<n;i++)
            getFollow(grmr[i][0], grmr[i][1]);
        for (int i = 0; i < n; i++) {
            String res= removeDuplicate(follow[i]);
            System.out.println(nt.charAt(i) + " -> " + res);
        }
    }
}