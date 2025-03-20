import java.util.*;

class EndABC{
    static boolean check(String inp){
        int state=0;
        for(int i=0;i<inp.length();i++){
            char ch=inp.charAt(i);
            switch(state){
                case 0:
                    if(ch=='a') state=1;
                    break;
                case 1:
                    if(ch=='b') state=2;
                    else if(ch=='c') state=0;
                    break;
                case 2:
                    if(ch=='a') state=1;
                    else if(ch=='b') state=0;
                    else state=3;
                    break;
                case 3:
                    if(ch=='a')state=1;
                    else state=0;
                    break;
            }
        }
        return state==3;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("String : ");
        String inp = sc.nextLine();
        if(check(inp)) System.out.println("Accepted");
        else System.out.println("Rejected");
    }
}