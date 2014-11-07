package algorithmsPractice;

import java.util.Arrays;

public class CoinsOnALine {

	/** binary recursion */
	
	public int calScore(int[] line, boolean IAmFirst) {
		if(line.length == 0) return 0;
		
		/** his turn */
		/** assume he will take the small or big one */
		/** what if I am the first to start the game, add a boolean value */
		/** what if the opposite is as smart as you are */
		
		int[] newLine = Arrays.copyOf(line, line.length);
		
		if(!IAmFirst) {
			if(line[0] > line[line.length - 1]) {
				newLine = Arrays.copyOfRange(newLine, 1, newLine.length);
			}
			else {
				newLine = Arrays.copyOfRange(newLine, 0, newLine.length - 1);
			}
		}
		
		if(newLine.length == 0) return 0;
		
		/** My turn   */ 
		/** take left */
		int right = calScore(Arrays.copyOfRange(newLine, 1, newLine.length), false);
		int takeLeft = right + newLine[0];
		
		int left = calScore(Arrays.copyOfRange(newLine, 0, newLine.length - 1), false);
		int takeRight = left + newLine[newLine.length - 1];
		
		return Math.max(takeLeft, takeRight);
	}
	
	public int dp(int[] line) {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = {1, 2, 5, 3};
		CoinsOnALine testObject = new CoinsOnALine();
		System.out.println(testObject.calScore(test, true));
	}

}
