package algorithmsPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParenthesis {

	public class State{
        int left;
        int right;
        StringBuilder sb;
        public State(int left, int right, StringBuilder sb) {
            this.left = left; 
            this.right = right;
            this.sb = sb;
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        
        //binary tree: left > 0, add left, right > left, add right
        Stack<State> stack = new Stack<>();
        stack.push(new State(n, n, new StringBuilder()));
        
        //dfs using stack
        while(!stack.isEmpty()) {
            State curState = stack.pop();
            
            int curLeft = curState.left;
            int curRight = curState.right;
            StringBuilder curSb = curState.sb;
            
            if(curLeft == 0 && curRight == 0) {
                result.add(curSb.toString());
            }
            
            if(curLeft > 0) {
                stack.push(new State(curLeft - 1, curRight, new StringBuilder(curSb.toString() + "(")));
            }
            
            if(curRight > curLeft) {
                stack.push(new State(curLeft, curRight - 1, new StringBuilder(curSb.toString() + ')')));
            }
            
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenerateParenthesis test = new GenerateParenthesis();
		List<String> result = test.generateParenthesis(2);
		for(String s: result) {
			System.out.println(s);
		}
	}

}
