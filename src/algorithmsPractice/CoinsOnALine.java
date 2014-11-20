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
		/** */
		
		//n^3
		int[][] sum = new int[line.length][line.length];
		for(int i = 0; i < line.length; i++) {
			for(int j = i; j < line.length; j++) {
				int tmpSum = 0;
				for(int k = i; k <= j; k++) {
					tmpSum += line[k];
				}
				sum[i][j] = tmpSum;
			}
		}
		
		int[][] dp = new int[line.length][line.length];
		
		//dp[i][j]: max i can get in i to j
		//dp[i][j] = max{sum[i][j] - dp[i][j - 1], sum[i][j] - dp[i - 1][j]};
		
		//for every i > j, dp[i][j] = 0; maybe no need because java initialize they to 0
		for(int i = 0; i < line.length; i++) {
			for(int j = 0; j < i; j++) {
				dp[i][j] = 0;
			}
			dp[i][i] = line[i];
		}
		
		//n^2
		for(int i = 0; i < line.length; i++) {
			int start = i - 1;
			int end = i + 1;
			while(start >= 0) {
				dp[start][i] = Math.max(sum[start][i] - dp[start + 1][i], sum[start][i] - dp[start][i - 1]);
				start--;
			}
			while(end < line.length) {
				dp[i][end] = Math.max(sum[i][end] - dp[i + 1][end], sum[i][end] - dp[i][end - 1]);
				end++;
			}
			
			start = i - 1;
			end = i + 1;
			while(start >= 1 && end < line.length) {
				dp[start][end] = Math.max(sum[start][end] - dp[start + 1][end], sum[start][end] - dp[start][end - 1]);
				start--;
				end++;
			}
		}
		
		return dp[0][dp.length - 1];
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = {3, 2, 2, 3, 1, 2};
		CoinsOnALine testObject = new CoinsOnALine();
		System.out.println(testObject.calScore(test, true));
	}

}
