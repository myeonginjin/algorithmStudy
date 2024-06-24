package a0624.stackqueque;

import java.util.ArrayDeque;
import java.util.Arrays;

public class BfsDfsDepth {
	static final int[] di = {-1,0,1,0}; //상우하좌 
	static final int[] dj = {0,1,0,-1};
	static int N = 5, C=0;
	static int[][] a;
	static boolean[][] v;
	
	static boolean indexOk(int i, int j) {
		return i>=0 && i<N && j >= 0 && j<N;
	}
	
	static void bfs(int i, int j, int depth) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		
		//방문처리 먼저 하고 시작하기. 그래야 우선순위큐로 푸는 문제에서 큐가 안터지게 할 수 있다? 암튼 큐에 들어가는걸 최소한으로 해야됨
		v[i][j] = true;
		q.offer(new int[] {i,j, depth});
		
		while(!q.isEmpty()) {
			int[] ij = q.poll();
			i = ij[0];
			j = ij[1];
			depth = ij[2];
			a[i][j] = C++;
			System.out.println(depth);
			for (int[]b : a) System.out.println(Arrays.toString(b)); System.out.println();
			for (int d = 0; d<4; d++) {
				int ni = i+di[d];
				int nj = j+dj[d];
				if(indexOk(ni, nj) && !v[ni][nj]) {
					v[ni][nj] = true;
					q.offer(new int[] {ni,nj,depth+1});
				}
			}
		}
		
	}
	
	
	//이런 방법도 잇다고 한다
	static void bfs(int i, int j) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		
		//방문처리 먼저 하고 시작하기. 그래야 우선순위큐로 푸는 문제에서 큐가 안터지게 할 수 있다? 암튼 큐에 들어가는걸 최소한으로 해야됨
		v[i][j] = true;
		q.offer(new int[] {i,j});
		int depth = 0;
		while(!q.isEmpty()) {
			int S = q.size();
			
			System.out.println("=> "+q.size());
			for (int s = 0; s<S; s++) {
				int[] ij = q.poll();
				i = ij[0];
				j = ij[1];
				//depth = ij[2];
				a[i][j] = C++;
				System.out.println(depth);
				for (int[]b : a) System.out.println(Arrays.toString(b)); System.out.println();
				for (int d = 0; d<4; d++) {
					int ni = i+di[d];
					int nj = j+dj[d];
					if(indexOk(ni, nj) && !v[ni][nj]) {
						v[ni][nj] = true;
						q.offer(new int[] {ni,nj});
					}
				}
			}
			depth++;
		}
		
	}
	
	static void dfs(int i, int j, int depth) {
		v[i][j] = true;
		a[i][j] = depth;
		
		System.out.println(depth);
		for(int[]b : a) System.out.println(Arrays.toString(b)); System.out.println();
	
		for (int d = 0; d<4; d++) {
			int ni = i + di[d];
			int nj = j +dj[d];
			
			if(indexOk(ni,nj) && !v[ni][nj]) {
				dfs(ni,nj, depth+1);
			}
		}
		
	}

	public static void main(String[] args) throws Exception{
		a = new int[N][N];
		v = new boolean[N][N];
		C=1;
		//bfs(N/2,N/2,0);
		bfs(N/2,N/2);
		//dfs(N/2,N/2,0);
		for(int[] b : a) System.out.println(Arrays.toString(b)); System.out.println();

	}

}
