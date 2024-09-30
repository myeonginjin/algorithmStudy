package a0701.graph;

import java.io.*;
import java.util.*;



public class Main_6479_전력난 {
	
	static class Node {
		int n;
		int p;
		
		public Node(int n , int p) {
			this.n = n;
			this.p = p;
		}
	}
	
	static int n,m;
	static List<Node>[] g;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		

		while (true) {
			str = br.readLine();
			st = new StringTokenizer(str);
			
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			
			if(n==0 && m == 0) break;
			
			g = new ArrayList[m]; for (int i = 0; i<m; i++) g[i] = new ArrayList<>();
			
			PriorityQueue<int[]> q = new PriorityQueue<>( (o1,o2) -> { return Integer.compare(o1[1],o2[1]); } );
			
			int sumPrice = 0;
	
			
			int to, go, price;
			
			for (int i = 0; i<n; i++) {
				str = br.readLine();
				st = new StringTokenizer(str);
				
				to = Integer.parseInt(st.nextToken());
				go = Integer.parseInt(st.nextToken());
				
				price = Integer.parseInt(st.nextToken());
				
				g[to].add(new Node(go, price));
				g[go].add(new Node(to, price));
				
				
				
				sumPrice += price;
			}
			
			boolean[] v = new boolean[m];
			
	
			for (Node n : g[0]) {
				q.add(new int[]{n.n, n.p});
			}
			
			int newPriceSum = 0;
			v[0] = true;
				
			while(!q.isEmpty()) {
				int[] temp = q.poll();
				
				int node = temp[0];
				int p = temp[1];
				
				if(v[node]) continue;
				
				v[node] = true;
				
				newPriceSum += p;
				
				//System.out.println("node : "+node +" "+" p : " + p);
				
				for (Node n : g[node]) {
					q.add(new int[]{n.n, n.p});
				}                                                                                                                        
			}
			
			sb.append(sumPrice - newPriceSum).append("\n");
		}
		System.out.println(sb);
	}
	

}
