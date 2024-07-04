package a0704.dijkstra;

import java.io.*;
import java.util.*;

public class DijkstraMain_exam {
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
		int[] d=new int[N]; 
		for(int i=0; i<N; i++) d[i]=Integer.MAX_VALUE; 
		
		d[0]=0;
		for(int i=0; i<N; i++) {
			int minVertex=-1;
			int min=Integer.MAX_VALUE;
			for(int j=0; j<N; j++) {
				if(!v[j] && min>d[j]) { 
					min=d[j];
					minVertex=j;		
				}
			}
			
			v[minVertex]=true;
			if(minVertex==N-1) break;		
		
			for(int[] j:g[minVertex]) {
				if(!v[j[0]] && d[j[0]]>min+j[1]) {
							   d[j[0]]=min+j[1]; 
				}
			}
		}
		System.out.println(d[N-1]);
		sc.close();
	}
}