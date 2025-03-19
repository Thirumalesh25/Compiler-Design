import java.util.*;

class Lexical_Analyzer{
    static void print(String m){
        System.out.println(m);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("LineOfCode : ");
        String str=sc.nextLine();
        HashSet<String> key =new HashSet<>(Arrays.asList("if", "else", "int","break"));
        
        int s=0;
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(";,+-*=/><(){}[] ".contains(ch+"")){
                String tk = str.substring(s, i).trim();
                if(!tk.isEmpty()){
                    if(key.contains(tk)) print("KEYWORD : "+tk);
                    else if(Character.isDigit(tk.charAt(0))) print("INVALID : "+tk);
                    else print("IDENTIFIER : "+tk);
                }
                s=i+1;
                if(ch==' ') continue;
                if("+-*=></".contains(ch+"")) print("OPERATOR : "+ch);
                else print("DELIMITER : "+ch);
            }
        }
    }
}
