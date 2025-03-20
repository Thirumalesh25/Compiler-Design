import java.util.*;

class ICG {
    static int val(char ch){
        switch(ch){
            case '+':
            case '-': return 1;
            case '*':
            case '/': return 2;
            case '^': return 3;
            case '(' :return 4;
            default : return -1;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Arithmetic Exp : ");
        String exp=sc.nextLine();
        String ans="";
        Stack<Character> s1=new Stack<>();
        for(int i=0;i<exp.length();i++){
            char ch=exp.charAt(i);
            if(val(ch)==-1) ans+=ch;
            else if(s1.isEmpty() || val(ch)>val(s1.peek())) s1.push(ch);
            else{
                while(!s1.isEmpty() && val(ch) <=val(s1.peek())){
                    ans+=s1.pop();
                }
                s1.push(ch);
            }
        }
        while(!s1.isEmpty()) ans+=s1.pop();
        
        int j=0;
        Stack<String> s2 =new Stack<>();
        for(int i=0;i<ans.length();i++){
            char ch=ans.charAt(i);
            if(val(ch)==-1) s2.push(ch+"");
            else{
                String o2=s2.pop();
                String o1=s2.pop();
                System.out.println("t"+j+"="+o1+ch+o2);
                s2.push("t"+j);
                j++;
            }
        }
    }
}
