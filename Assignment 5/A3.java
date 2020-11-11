import java.util.*;

public class A3 { 
	//This is written assuming that the whole code is in one line, and does not contain brackets as strings, which would be balanced as it is.
	//To write code taking the above condition into account, characters between "" and '' should be ignored.
	static boolean areBracketsBalanced(String expr) { 

		Deque<Character> stack  = new ArrayDeque<Character>(); 
  
		for (int i = 0; i < expr.length(); i++) { 

			char x = expr.charAt(i);

			if (x != '[' && x != ']' && x != '{' && x != '}' && x != '(' && x != ')') 
				continue;

			if (x == '(' || x == '[' || x == '{') { 

				stack.push(x); 
				continue; 
			} 
  
			if (stack.isEmpty()) 
				return false;

			char check; 

			switch (x) { 
			case ')': 
				check = stack.pop(); 
				if (check == '{' || check == '[') 
					return false; 
				break; 
  
			case '}': 
				check = stack.pop(); 
				if (check == '(' || check == '[') 
					return false; 
				break; 
  
			case ']': 
				check = stack.pop(); 
				if (check == '(' || check == '{') 
					return false; 
				break; 
			} 
		} 
  
		return (stack.isEmpty()); 
	} 
  
	public static void main(String[] args) { 

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter string you want to check.");
		String expr = sc.nextLine();

		if (areBracketsBalanced(expr)) 
			System.out.println("Balanced."); 
		else
			System.out.println("Not Balanced.");
	} 
} 