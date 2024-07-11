package study;

import java.io.*;
import java.util.*;

public class alice_4_orijin {
	static int n;
	static ArrayList<Integer>[] g;
	static ArrayList<Integer> perm;
	static boolean playerWin = false;
	static StringBuilder sb = new StringBuilder();
	
	static void checkWinner() {
		int p1 = 0;
		int p2 = 0;
		
		for (int i = 0; i<perm.size(); i++) {
			if((i+1)%2==0) {
				p2+= perm.get(i);
			}else {
				p1 += perm.get(i);
			}
		}
		
		if(p1>=p2) {
			playerWin = true;
		}
	}
	
	static void dfs(int v, int degree) {
		if(playerWin) return;

		if(g[v].size() == 0) {
			checkWinner();
			
			perm.remove(perm.size()-1);
			return;
		}
		
		for (int i = 0; i<g[v].size(); i++) {
			int child = g[v].get(i);
		
			perm.add(child);
			dfs(child, degree+1);
		}
		perm.remove(perm.size()-1);
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		g = new ArrayList[n+1]; for (int i = 1; i<=n; i++) g[i] = new ArrayList<>();
		
		String str;
		StringTokenizer st;
		int t, tt, from, to;
		for (int i = 0; i<n-1; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			t = Integer.parseInt(st.nextToken());
			tt = Integer.parseInt(st.nextToken());
			
			from = Math.min(t,tt);
			to = Math.max(t,tt);
			
			g[from].add(to);
		}
		
		for (int i = 1; i<=n; i++) {
			perm = new ArrayList<>();
			playerWin = false;
			perm.add(i);
			dfs(i, 1);
			
			
			if(!playerWin) {
				sb.append("0").append("\n");
			} else {
                sb.append("1").append("\n");
            }
		}
		System.out.println(sb);
	}

}
