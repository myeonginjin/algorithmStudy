package a0703.prim;

import java.io.*;
import java.util.*;

public class PrimPqMain_exam {
		public static void main(String[] args) throws Exception{
			System.setIn(new FileInputStream("src/a0703/prim/input_prim"));
			Scanner sc=new Scanner(System.in);
			int N= sc.nextInt();		
			List<int[]>[] g=new List[N]; for(int i=0; i<N; i++) g[i]=new ArrayList<>();
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					int c=sc.nextInt();
					if(c!=0) g[i].add(new int[] {j,c}); 
				}							
			}
			boolean[] v=new boolean[N];
			int[] w=new int[N];
			for(int i=0; i<N; i++) w[i]=Integer.MAX_VALUE/2;  
			
			PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1[1], o2[1]));
			int sum=0, cnt=0;
			w[0]=0;
			pq.offer(new int[] {0,w[0]});
			while(!pq.isEmpty()) {
				int[] vc = pq.poll();
				int min = vc[1];
				int minVertex = vc[0];
				if(v[minVertex]) continue;
				
				v[minVertex]=true;
				sum+=min;						
				if(cnt++==N-1) break;		
			
				for(int[] j:g[minVertex]) {
					if(!v[j[0]] && w[j[0]]>j[1]) {
								   w[j[0]]=j[1]; 
								   pq.offer(new int[] {j[0], w[j[0]]});
					}
				}
			}
			System.out.println(sum);
			sc.close();
		}
	}