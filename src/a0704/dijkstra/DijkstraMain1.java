package a0704.dijkstra;

import java.io.*;
import java.util.*;

public class DijkstraMain1 { 
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("src/a0704/dijkstra/input_dijkstra"));
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
		int[] dist=new int[N]; 
		for(int i=0; i<N; i++) dist[i]=Integer.MAX_VALUE; 
		
		dist[0]=0;
		System.out.println(Arrays.toString(dist));System.out.println();
		for(int i=0; i<N; i++) {
			int minVertex=-1;
			int min=Integer.MAX_VALUE;
			for(int j=0; j<N; j++) {
				if(!v[j] && min>dist[j]) { 
					min=dist[j];
					minVertex=j;		
				}
			}
			
			v[minVertex]=true;
			System.out.println(Arrays.toString(v));
			System.out.println("vertex="+minVertex+" min="+min);
			if(minVertex==N-1) break;		
		

			for(int[] j:g[minVertex]) {
				if(!v[j[0]] && dist[j[0]]>min+j[1]) {
							   dist[j[0]]=min+j[1]; 
				}
			}
			System.out.println(Arrays.toString(dist)); System.out.println("=================");
		
		}
		System.out.println(dist[N-1]);
		sc.close();
	}
}