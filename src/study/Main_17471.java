package study;

import java.util.*;
import java.io.*;


public class Main_17471 {
	static int n;
	static int[] cnts;
	static int[] a;
	static List<Integer> b;
	static boolean[] v;
	static List<Integer>[] g;
	static int totalSum;
	static int minDif = Integer.MAX_VALUE;
	static int[] union;
	

	static boolean checkOk() {
				
		List<Integer> c = new ArrayList<>();
		for (int i = 1; i<=n; i++) if(!b.contains(i)) c.add(i);
		
		//b그룹 체크
		boolean[] bg = new boolean[n+1];
		ArrayDeque<Integer> q = new ArrayDeque<>();
		
		q.offer(b.get(0));
		bg[b.get(0)] = true;
		int cnt = 1;
		
		while(!q.isEmpty()) {
			int t = q.poll();
			
			for (int nei: g[t]) {
				if(!bg[nei] && b.contains(nei)) {
					bg[nei] = true;
					q.add(nei);
					cnt++;
				}
			}
		}
		
		for (int i = 0; i<b.size(); i++) {
			if(!bg[b.get(i)]) return false;
		}
		
		bg = new boolean[n+1];
		q = new ArrayDeque<>();
		
		q.offer(c.get(0));
		bg[c.get(0)] = true;
		cnt = 1;
		
		while(!q.isEmpty()) {
			int t = q.poll();
			
			for (int nei: g[t]) {
				if(!bg[nei] && c.contains(nei)) {
					bg[nei] = true;
					q.add(nei);
					cnt++;
				}
			}
		}
		
		for (int i = 0; i<c.size(); i++) {
			if(!bg[c.get(i)]) return false;
		}
		
		return true;
	}
	
	static void sub(int index) {
		
		if(index == n) {
			//인구수 계산 
			if(b.size()==0 || b.size()==n) return;
			
			if(!checkOk()) return;
			
			int sum = 0;
			for (int i = 0; i<b.size(); i++) {
				sum += cnts[b.get(i)];
			}
			
			minDif = Math.min(minDif, Math.abs( (totalSum - sum) -  sum ));
			return;
		}
		
		b.add(a[index]);
		sub(index+1);
		
		b.remove(b.size()-1);
		sub(index+1);
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/study/input_17471"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		str = br.readLine();
		st = new StringTokenizer(str);
		
		//각 지역 인구수 
		cnts = new int[n+1];
		//그래프 인접리스트
		g = new List[n+1]; for (int i = 1; i<=n; i++) g[i] = new ArrayList<>();
		
		a = new int[n]; for (int i = 0; i<n; i++) a[i] = i+1;
		b = new ArrayList<>();
		
		union = new int[n+1]; for (int i = 1; i<=n; i++) union[i] = i;
		
		for (int i = 1; i<=n; i++) {
			int cnt = Integer.parseInt(st.nextToken());
			cnts[i] = cnt;
			totalSum += cnt;
		}
		
		for (int i = 1; i<=n; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			int t = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j<t; j++) {
				int temp = Integer.parseInt(st.nextToken());
				g[i].add(temp);
				g[temp].add(i);
			}
		}
		
		sub(0);
		
		minDif = 2147483647 == minDif ? -1 : minDif;
		System.out.println(minDif);
		
	}
}
