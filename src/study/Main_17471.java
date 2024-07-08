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
	
	
	static int find(int c) {
		if(union[c] == c) return c;
		
		return union[c] = find(union[c]);
	}

	static void makeUnion(int n1, int n2) {
		int root1 = find(n1);
		int root2 = find(n2);
		
		if(root1 == root2) return;
		
		union[root1] = root2;
	}
	
	static boolean checkOk() {
		boolean[] notPic = new boolean[n+1];
				
		
		int bRoot = union[b.get(0)];
		for (int i = 0; i<b.size(); i++) {
			int to = b.get(i);
			notPic[to] = true;
			
			
			if(bRoot != union[to]) return false;
		}

		List<Integer> c = new ArrayList<>();
		
		for (int i = 1; i<=n; i++) {
			if(!notPic[i]) c.add(i);
		}

		
		int cRoot = union[c.get(0)];
		
		for (int i = 1; i<c.size(); i++) {
			int to = c.get(i);
			
			if(cRoot != union[to]) return false;
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
				sum += cnts[b.get(i)-1];
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
		cnts = new int[n];
		//그래프 인접리스트
		g = new List[n+1]; for (int i = 1; i<=n; i++) g[i] = new ArrayList<>();
		
		a = new int[n]; for (int i = 0; i<n; i++) a[i] = i+1;
		b = new ArrayList<>();
		
		union = new int[n+1]; for (int i = 1; i<=n; i++) union[i] = i;
		
		for (int i = 0; i<n; i++) {
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
				makeUnion(i,temp);
			}
		}
		
		for (int i = 1; i<=n; i++) {
			find(i);
		}

		sub(0);
		
		minDif = 2147483647 == minDif ? -1 : minDif;
		System.out.println(minDif);
		
	}
}
