package algorithmsPractice;


import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sun.xml.internal.ws.util.StringUtils;

public class kmp {
public static String addBinary(String a, String b) {
        
        StringBuilder sb = new StringBuilder();
        String revA = new StringBuilder(a).reverse().toString();
        String revB = new StringBuilder(b).reverse().toString();
        
        int carry = 0;
        int iA = 0;
        int iB = 0;
        
        while(iA < revA.length() && iB < revB.length()) {
            int curDigit = revA.charAt(iA) - '0' + revB.charAt(iB) - '0' + carry;
            if(curDigit >= 2) {
                carry = 1;
                curDigit = curDigit % 2;
            }
            else {
                carry = 0;
            }
            iA ++;
            iB ++;
            sb.insert(0, String.valueOf(curDigit));
        }
        
        while(iA < revA.length()) {
            int curDigit = revA.charAt(iA) - '0' + carry;
            if(curDigit >= 2) {
                carry = 1;
                curDigit = curDigit % 2;
            }
            else {
                carry = 0;
            }
            iA ++;
            sb.insert(0, String.valueOf(curDigit));
        }
        
        while(iB < revB.length()) {
            int curDigit = revB.charAt(iB) - '0' + carry;
            if(curDigit >= 2) {
                carry = 1;
                curDigit = curDigit % 2;
            }
            else {
                carry = 0;
            }
            iB ++;
            sb.insert(0, String.valueOf(curDigit));
        }
        
        if(carry == 1) {
            sb.insert(0, String.valueOf(carry));
        }
        
        String result = sb.toString();
        
        return result;
    }
	
    public static void main(String[] args) {
        int[] A = new int[]{2,0};
    	int[] B = new int[]{1};
    	String result = "adfasdfasdf";
    	char[] aArr = result.toCharArray();
    	Arrays.sort(aArr);
    	System.out.println(result + ";;;" + new String(aArr));
    }
    
    
}