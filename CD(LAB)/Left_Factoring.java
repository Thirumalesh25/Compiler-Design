import java.util.*;

public class Left_Factoring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("No.of Productions : ");
        int n = sc.nextInt();
        sc.nextLine(); 
        
        System.out.println("Grammar : ");
        for (int i = 0; i < n; i++) {
            String p[] = sc.nextLine().split("->");
            LR(p[0], p[1]);
        }
    }

    static void LR(String p1, String p2) {
        String[] p = p2.split("/");
        String beta = "", R = "";
        int h[]=new int[26];
        for (String i : p) {
            char ch = i.charAt(0);
            if (ch >= 'a' && ch <= 'z') 
                h[ch-'a']++;
        }
        int maxi=0;
        for(int i=1;i<26;i++){
            if(h[i]>h[maxi]) maxi=i;
        }
        if (h[maxi]<=1) {
            System.out.println("Not Left Factoring.");
            return;
        }
        char alpha = (char)('a'+maxi);
        for (String i : p) {
            if (i.isEmpty()) continue;
            char ch = i.charAt(0);
            if (alpha == ch) 
                beta += i.substring(1)+"/";
            else 
                R += i + "/";
        }
        System.out.println("Left Factoring Exists");
        System.out.println(p1 + " -> " + alpha + p1 + "'/" + R);
        System.out.println(p1 + "' -> " + beta);
    }
}
