package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_9251_LCS {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        int len1 = str1.length();
        int len2 = str2.length();

        // DP 테이블 크기는 (len1 + 1) x (len2 + 1)
        int[][] dp = new int[len1 + 1][len2 + 1];

        // LCS 알고리즘
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // 최종 결과 출력 (LCS 길이)
        System.out.println(dp[len1][len2]);
    }
}