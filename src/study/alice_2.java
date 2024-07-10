package study;

import java.util.*;
import java.io.*;

public class alice_2 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);

        String[] secLine = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(secLine[i]);
        }
        
        for (int t = 0; t < m; t++) {
            String[] taskLine = br.readLine().split(" ");
            int i = Integer.parseInt(taskLine[0]);
            int j = Integer.parseInt(taskLine[1]);
            int k = Integer.parseInt(taskLine[2]);

            int[] subArray = Arrays.copyOfRange(arr, i - 1, j);
            Arrays.sort(subArray);

            sb.append(subArray[k - 1]).append("\n");
        }

        System.out.print(sb.toString());
    }
}