package algorithmsPractice;

import java.util.ArrayList;
import java.util.List;

public class SplitWord {

	public static boolean isValid(char c) {
		if(c == ' ' || c == ']'){
			return false;
		}

		return true;
	}
	
	public static List<String> findWords(String str) {
		List<String> resultList = new ArrayList<>();
		if(str.length() == 0) {
			return resultList;
		}
		boolean startNew = true;
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			boolean isValid = isValid(c);
			if(!isValid) {
				startNew = true;
				if(sb.length() != 0) {
					resultList.add(sb.toString());
					sb = new StringBuilder();
				}
			}
			else if(!startNew) {
				sb.append(c);
			}
			else {
				startNew = false;
				sb = new StringBuilder();
				sb.append(c);
			}
		}
		
		if(sb.length() != 0)
			resultList.add(sb.toString());
		
		return resultList;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "I have     a ]faux coat ]";
		List<String> words = findWords(s);
		for(String str : words) {
			//System.out.println(str);
		}
		
		ListNode a = new ListNode(1);
		System.out.println(a);
		
	}

}
