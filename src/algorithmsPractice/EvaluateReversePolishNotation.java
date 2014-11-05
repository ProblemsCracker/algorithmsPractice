package algorithmsPractice;

import java.util.HashSet;
import java.util.Stack;

public class EvaluateReversePolishNotation {

public static int calculate(int a, int b, char operator) {
        
        switch (operator){
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            default: return 0;
        }
        
    }
    
    public static int evalRPN(String[] tokens) {
        HashSet<Character> operationSet = new HashSet<Character>();
        operationSet.add('+');
        operationSet.add('-');
        operationSet.add('*');
        operationSet.add('/');
        
        int i = 0; 
        
        if(tokens.length == 1) return Integer.valueOf(tokens[0]);
        
        Stack<Integer> stack = new Stack<Integer>();
        
        int result = 0;
        //write test cases
        while(i < tokens.length) {
            String s = tokens[i];
            char first = s.charAt(0);
            if(operationSet.contains(first) && s.length() == 1) {
                int b = stack.pop();
                int a = stack.pop();
                int tmp = calculate(a, b, first);
                stack.push(tmp);
                result = tmp;
            }
            else {
                int tmp = Integer.valueOf(s);
                stack.push(tmp);
            }
            i++;
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] sArr = {"2","1","+","3","*"};
		System.out.println(evalRPN(sArr));
	}

}
