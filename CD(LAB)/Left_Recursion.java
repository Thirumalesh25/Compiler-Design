import java.util.*;

public class Left_Recursion {
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
        boolean ch=false;
        String alpha="", beta="";
        for(String i : p){
            if((i.charAt(0)+"").equals(p1)){
                ch=true;
                alpha+=i.substring(1)+p1+"'/";
            }
            else{
                beta+=i+p1+"'/";
            }
        }
        if(!ch){
            System.out.println("Not Left Recursion.");
            return;
        }
        System.out.println("Left Recursion Exist");
        System.out.println(p1+"->"+beta);
        System.out.println(p1+"'->"+alpha+"epslion");
    }
}