import java.util.Scanner;

public class Tester {
	
	public static String infixConverter(String str) {
		
		if(str == null || str.isEmpty()) {
			throw new IllegalArgumentException("Bad or empty string in infixConverter");
		}
		
		String postfix = "";
		String[] raw = str.split("");
		String infix = "";
		for(String s:raw) {
			if(s.equals(" ") == false) {
				infix += s;
			}
		}
		String[] exp = infix.split("");
		LinkedStack<String> stack = new LinkedStack<String>();
		
		for(int i = 0; i < exp.length; i++) {
			if(exp[i].equals("(")) {
				stack.push(exp[i]);
			}
			else if(exp[i].equals(")")) {
				while(stack.getTop().equals("(") == false && stack.size > 0) {
					postfix += stack.pop();
				}
				stack.pop();
			}
			else if(exp[i].equals("+") || 
					exp[i].equals("-") || 
					exp[i].equals("*") || 
					exp[i].equals("/") || 
					exp[i].equals("^")) {
				while(stack.size > 0 && (precedence("stack", stack.getTop()) - precedence("current", exp[i])) > 0) {
					postfix += stack.pop();
				}
				stack.push(exp[i]);
			}
			else {
				postfix += exp[i];
			}
		}
		while(stack.size > 0) {
			postfix += stack.pop();
		}
		return postfix;
	}
	
	public static int precedence(String loc, String op) {
		int res = 0;
		switch(op) {
		case "+":
			if(loc == "stack") {
				res = 2;
			} else {
				res = 1;
			}
			break;
		case "-":
			if(loc == "stack") {
				res = 2;
			} else {
				res = 1;
			}
			break;
		case "*":
			if(loc == "stack") {
				res = 4;
			} else {
				res = 3;
			}
			break;
		case "/":
			if(loc == "stack") {
				res = 4;
			} else {
				res = 3;
			}
			break;
		case "^":
			if(loc == "stack") {
				res = 5;
			} else {
				res = 6;
			}
			break;
		case "(":
			if(loc == "stack") {
				res = 0;
			}
			else {
				res = 100;
			}
			break;
		case ")":
			res = 0;
			break;
		}
		return res;
	}
	
	public static int postfixCalc(String postfix) {
		if(postfix == null || postfix.isEmpty()) {
			throw new IllegalArgumentException("Empty or null infix input in postfixCalc");
		}
		
		String[] exp = postfix.split("");
		LinkedStack<Integer> stack = new LinkedStack<Integer>();
		
		for(int i = 0; i < exp.length; i++) {
			if(exp[i].equals("+") || 
					exp[i].equals("-") || 
					exp[i].equals("*") || 
					exp[i].equals("/") || 
					exp[i].equals("^")) {
				int r = stack.pop();
				int l = stack.pop();
				int res = 0;
				switch(exp[i]) {
				case "+":
					res = l+r;
					break;
				case "-":
					res = l-r;
					break;
				case "*":
					res = l*r;
					break;
				case "/":
					res = l/r;
					break;
				case "^":
					res = (int) Math.pow(l, r);
					break;
				}
				stack.push(res);
			}
			else {
				stack.push(Integer.parseInt(exp[i]));
			}
		}
		if(stack.size == 1) {
			return (int) stack.pop();
		}
		else {
			throw new IllegalArgumentException("Postfix error: infix statement likely has bad syntax");
		}
	}

	private static void display() {
		Scanner kb = new Scanner(System.in);
		System.out.print("Please enter the infix expression to process: ");
		String infix = kb.nextLine().trim();
		String postfix = infixConverter(infix);
		System.out.println("The postfix expression for the input infix is: " + infixConverter(infix));
		System.out.println("The final result after evaluating the postfix is: " + postfixCalc(postfix));
		kb.close();
	}
	
	public static void main(String[] args) {
		display();
	}
}
