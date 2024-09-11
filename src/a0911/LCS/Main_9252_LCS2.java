package a0911.LCS;

import java.io.*;
import java.util.*;

public class Main_9252_LCS2 {
	
	public static void main(String[] args) throws Exception {
		
		//System.setIn(new FileInputStream("src/study/input_1991"));
		//System.setIn(new FileInputStream("src/study/input_1991"));
		
		System.setIn(new FileInputStream("src/a0911/LCS/input_9252"));
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str12 = br.readLine();
		String str1 = br.readLine();
		
		int[][] dp = new int[str1.length()+1][str12.length()+1];
		
	
		
		int changePoint = -1;
		StringBuilder sb = new StringBuilder();
		
		for (int j = 1; j<str12.length()+1; j++) {
			
			for (int i = 1; i<str1.length()+1; i++) {
				
				if(str1.charAt(i-1) == str12.charAt(j-1)) {
					
					dp[i][j] = dp[i-1][j-1] + 1 ;
					
					
					if (changePoint < dp[i][j]) {
						changePoint = dp[i][j];
						
						sb.append(str12.charAt(j-1));
					}
					
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		System.out.println(dp[str1.length()][str12.length()]);
		
        // 역추적하여 LCS 문자열 찾기
        StringBuilder sb2 = new StringBuilder();
        int i = str1.length();
        int j = str12.length();
        
        while( i > 0 && j > 0 ) {
        	if(str1.charAt(i-1) == str12.charAt(j-1)) {
        		sb2.append(str1.charAt(i-1));
        		i--;
        		j--;
        	}
        	
        	else if (dp[i-1][j] > dp[i][j-1]) {
        		i--;
        	} else {
        		j--;
        	}
        }
         
        // LCS 문자열 출력 (역순이므로 뒤집어야 함)
        System.out.println(sb2.reverse());
	}

}
