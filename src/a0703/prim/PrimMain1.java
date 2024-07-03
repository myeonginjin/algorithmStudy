package a0703.prim;

import java.io.*;
import java.util.*;

public class PrimMain1 { //간선이 많으면 (행렬로 하는게) 적으면 인접 리스트로 만드는 ~ // 
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("src/a0703/prim/input_prim.txt"));
		Scanner sc=new Scanner(System.in);
		int N= sc.nextInt();		
		List<int[]>[] g=new List[N]; for(int i=0; i<N; i++) g[i]=new ArrayList<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int c=sc.nextInt();
				if(c!=0) g[i].add(new int[] {j,c}); // 인접정점 번호, 비용  
				//코스트를 입력받는거에요 i번 정점에서 j로 가는 비용? //if 문 활용해서 0 아닐때 넣어도 될 듯
			}							
		}
		
		boolean[] v=new boolean[N];
		int[] minEdge=new int[N]; //Arrays.fill(minEdge, Integer.MAX_VALUE); //프림  w[] 로 표현해도 뭐~
		for(int i=0; i<N; i++) minEdge[i]=Integer.MAX_VALUE/2;  //2로 나눠 10억 정도로 쓰는 사람도 있다!
		
		int sum=0, cnt=0;
		minEdge[0]=0;
		System.out.println(Arrays.toString(minEdge));System.out.println();
		for(int i=0; i<N; i++) {
			int minVertex=-1;
			int min=Integer.MAX_VALUE;
			for(int j=0; j<N; j++) {
				if(!v[j] && min>minEdge[j]) { //최소가중치 메모이제이션
					min=minEdge[j];
					minVertex=j;		// 몇번 정점이냐도 찾아야 한다.
				}
			}
			
			//step2
			v[minVertex]=true;
			sum+=min;							// MST에 누적 시키는~
			System.out.println(Arrays.toString(v));
			System.out.println("minVertex="+minVertex);
			System.out.println("min="+min+" sum="+sum);
			
			if(cnt++==N-1) break;		//++은 저기에 넣어야해 아직 간선을 연결한게 아니에여
		
			// 갱신하러 가
			for(int[] j:g[minVertex]) {
				if(!v[j[0]] && minEdge[j[0]]>j[1]) {
							   minEdge[j[0]]=j[1]; //갱신!
				}
			}
			System.out.println(Arrays.toString(minEdge)); System.out.println("=================");
		
		}
		System.out.println(sum);
		sc.close();
	}
}