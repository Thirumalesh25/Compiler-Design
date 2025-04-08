import java.util.*;

public class Stack {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Stack<Integer> s = new Stack<>();
		System.out.print("Size : ");
		int n = sc.nextInt();

		while (true) {
			System.out.print("1.Push 2.Pop 3.Display 4.Exit\nChoice : ");
			int c = sc.nextInt();
			switch (c) {
				case 1 :
					if (s.size() >= n) System.out.println("Overflow");
					else {
					    System.out.print("Number : ");
					    s.push(sc.nextInt());
					}
					break;

				case 2 : 
					if (s.isEmpty()) System.out.println("Underflow");
					else s.pop();
					break;

				case 3 : System.out.println(s); break;
				
				case 4 : return;
				
				default : System.out.println("Invalid ");
			}
		}
	}
}
