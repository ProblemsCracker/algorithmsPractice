package algorithmsPractice;

public class ImplementKMP {

	/**
	 * Example:
	 * S = ****************cbcbc****************
	 * P = 				   cbcba
	 */
	
	/** MatchTable function for a pattern **/
    private static int[] buildNextTable(String p)
    {
        int n = p.length();
        int[] nextTable = new int[p.length()];
        nextTable[0] = -1;
        int k = -1;
        int j = 0;
        
        while (j < n - 1)
        {
        	//p[k]表示前缀，p[j]表示后缀 
            if (k == -1 || p.charAt(k) == p.charAt(j)) {
            	++k;
            	++j;
            	nextTable[j] = k;
            }
            else
            {
            	k = nextTable[k];
            }
        }
        
        return nextTable;
    }
    
    /** Function to find match for a pattern **/
    private static int posMatch(String s, String p, int[] nextTable)
    {
        int i = 0, j = 0;
        int lens = s.length();
        int lenp = p.length();
        while (i < lens && j < lenp)
        {
        	//①如果j = -1，或者当前字符匹配成功（即S[i] == P[j]），都令i++，j++
            if (j == -1 || s.charAt(i) == p.charAt(j))
            {
                i++;
                j++;
            }
            else
            {
            	//②如果j != -1，且当前字符匹配失败（即S[i] != P[j]），则令 i 不变，j = next[j]      
                //next[j]即为j所对应的next值 
                j = nextTable[j];
            }
        }
        return ((j == lenp) ? (i - lenp) : -1);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcdefg";
		String p = "cde";
		int[] nextTable = buildNextTable(p);
		int check = posMatch(s, p, nextTable);
		System.out.println(check);
	}

}
