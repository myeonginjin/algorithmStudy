package softear;

import java.io.*;
import java.util.*;


public class Main_349775 {
	   static int n,m;
	    static ArrayList<int[]> load;
	    static boolean[][] v;
	    static int[][] arr;
	    static int cnt;

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        n = sc.nextInt();
	        m = sc.nextInt();

	        arr = new int[n][n];
	        v = new boolean[n][n];

	        for (int i = 0; i<n; i++){
	            for (int j = 0; j<n; j++){
	                arr[i][j] = sc.nextInt();
	            }
	        }

	        load = new ArrayList<>();
	        for (int i = 0; i<m; i++){
	            int r = sc.nextInt()-1;
	            int c = sc.nextInt()-1;
	            load.add(new int[]{r,c});
	        }

	        v[load.get(0)[0]][load.get(0)[1]] = true;
	        move(load.get(0)[0], load.get(0)[1] , 1);

	        System.out.print(cnt);
	        
	    }
	    
	    static void move(int r, int c, int step) {
	        int[] dr = new int[]{-1,1,0,0};
	        int[] dc = new int[]{0,0,-1,1};

	        if(step == m) {
	             cnt++;
	            return;
	        }

	        for (int i = 0; i<4; i++) {
	            int nr = r + dr[i];
	            int nc = c + dc[i];

	            if(indexOk(nr, nc) && arr[nr][nc] != 1 && !v[nr][nc]) {
	                if(cantStep(r, c, step)) continue;

	                v[nr][nc] = true;

	                if (nextStep(nr, nc, step)) { //방문해야할 지점 제때 도착
	                    move(nr, nc, step + 1);
	                }
	                else { //그냥
	                    move(nr, nc, step);
	                }

	                v[nr][nc] = false;
	            }
	        }
	    }

	    static boolean nextStep(int r, int c , int s) {
	        int[] t = load.get(s);
	        if(r == t[0] && c == t[1]) return true; 
	        return false;
	    }

	    static boolean cantStep(int r, int c , int s) {

	        for (int i = s+1; i<load.size(); i++) {
	            int[] t = load.get(i);
	            if(r == t[0] && c == t[1]) {
	                return true;   
	            }
	        }
	        
	        return false;
	    }

	    static boolean indexOk (int r , int c) {
	        return r >= 0 && c >= 0 && r < n && c < n;
	    }
	}
