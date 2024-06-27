package a0625.sortkmp;

import java.util.*;
import java.io.*;

public class Main_11047 {
	
public static void main(String[] args) throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String str;
	StringTokenizer st;
	
	str = br.readLine();
	st = new StringTokenizer(str);
	
	int n = Integer.parseInt(st.nextToken());
	int k = Integer.parseInt(st.nextToken());
	
	int cnt = 0;
	
	ArrayDeque<Integer> d = new ArrayDeque<>();
	
	for (int i = 0; i<n; i++) {
		d.offer(Integer.parseInt(br.readLine()));
	}
	
	
	
	while(!d.isEmpty()) {
		if(k == 0) {
			break;
		}
		
		int coin = d.pollLast();
		if(k>=coin) {
			cnt += k/coin;
			k %= coin;
		}
		
	}
	
	System.out.println(cnt);
	
	}
}
