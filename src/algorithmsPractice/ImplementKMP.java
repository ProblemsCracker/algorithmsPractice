package algorithmsPractice;

public class ImplementKMP {

	/**
	 * Example:
	 * S = ****************cbcbc****************
	 * P = 				   cbcba
	 */
	
	/** MatchTable function for a pattern **/
    private static int[] buildMatchTable(String pat)
    {
        int n = pat.length();
        int[] matchTable = new int[pat.length()];
        matchTable[0] = -1;
        
        for (int j = 1; j < n; j++)
        {
            int i = matchTable[j - 1];
            
            while ((pat.charAt(j) != pat.charAt(i + 1)) && i >= 0)
                i = matchTable[i];
            
            if (pat.charAt(j) == pat.charAt(i + 1))
                matchTable[j] = i + 1;
            else
                matchTable[j] = -1;
        }
        
        return matchTable;
    }
    
    /** Function to find match for a pattern **/
    private static int posMatch(String text, String pat, int[] matchTable)
    {
        int i = 0, j = 0;
        int lens = text.length();
        int lenp = pat.length();
        while (i < lens && j < lenp)
        {
            if (text.charAt(i) == pat.charAt(j))
            {
                i++;
                j++;
            }
            else if (j == 0)
                i++;
            else
                j = matchTable[j - 1] + 1;
        }
        return ((j == lenp) ? (i - lenp) : -1);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcdefg";
		String p = "cde";
		int[] matchTable = buildMatchTable(p);
		int check = posMatch(s, p, matchTable);
		System.out.println(check);
	}

}
