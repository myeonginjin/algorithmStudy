package a0619.recu;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main_bj_16935_배열돌리기_진명인 {
	public static int n,m;
	public static int[][] arr = new int[100][100];
	
	public static void swap1() {
			int temp[] = null;
			
			for (int i = 0; i<n/2; i++) {
				temp = arr[i];
				arr[i] = arr[n - (i+1)];
				arr[n - (i+1)] = temp;
			}
	}
	
	public static void swap2() {
		
		int[] temp = new int[n];
		
		for (int i = 0; i<m/2; i++) {
			for (int j = 0; j<n; j++) {
				temp[j] = arr[j][i];	
				
				arr[j][i] = arr[j][m - (i+1)];
				arr[j][m - (i+1)] = temp[j];
			}
		}
	}
	
	public static void swap3() {
		int[][] temp = new int[100][100];
		
		for (int i = 0; i<n; i++) {
			for (int j = 0; j<m; j++) {
				temp[j][n - (i+1)] = arr[i][j];
			}
		}
		
		arr = temp;
		int t = n;
		n = m;
		m = t;
	}
	
	public static void swap4() {
		int[][] temp = new int[100][100];
		
		for (int i = 0; i<n; i++) {
			for (int j = 0; j<m; j++) {
				temp[j][i] = arr[i][m - (j+1)];
			}
		}
		
		arr = temp;
		int t = n;
		n = m;
		m = t;
	}
	
	public static void swap5() {
		
		int temp[][] = new int[n/2][m/2];
		

				//1번 그룹 미리 저장 
				for (int i = 0; i<n/2; i++) {
					for (int j = 0; j<m/2; j++) {
						temp[i][j] = arr[i][j];
					}
				}
				
				//1번 그룹에 4번 그룹 넣기 
				
				int r = 0;
				int c = 0;
				for (int i = n/2 ; i<n; i++) {
					//System.out.println(i+" "+c);
					
					for (int j = 0; j<m/2; j++) {
						arr[r][c++] = arr[i][j];
					}
					r++;
					c= 0;
				}
				

				int temp2[][] = new int[n/2][m/2];
				
				int c2 = 0;
				
				//2번 그룹 temp2에 저장 
				for (int i = 0; i<n/2; i++) {
					for (int j = m/2; j<m; j++) {
						temp2[i][c2++] = arr[i][j];
					}
					c2= 0;
				}
				
				int c7 = 0;
			
				//2번 그룹에 1번 넣어놧던 temp배열 옮기기 
				for (int i = 0; i<n/2; i++) {
					for (int j = m/2; j<m; j++) {
						arr[i][j] = temp[i][c7++]; 
					}
					c7=0;
				}
//				
//				
				//3번 그룹 저장하기
				int temp3[][] = new int[n/2][m/2];
				int r3 = 0;
				int c3 = 0;
				
				for (int i = n/2; i<n; i++) {
					for (int j = m/2; j<m; j++) {
						//System.out.println(r3+" " +c3);
						temp3[r3][c3++] = arr[i][j];
					
					}
					c3 = 0;
					r3++;
				}
				
				//3번 그룹에 temp2에 넣어둿던 그룹 2 넣기 
				r3 = 0;
				c3 = 0;
				for (int i = n/2; i<n; i++) {
					for (int j = m/2; j<m; j++) {
						arr[i][j] = temp2[r3][c3++];
					}
					r3++;
					c3 = 0;
				}
//				
				//temp3에 있는 3번 그룹 4번 그룹에 옮기기
				r3 = 0;
				c3 = 0;
				for (int i = n/2 ; i<n; i++) {
					for (int j = 0; j<m/2; j++) {
						arr[i][j] = temp3[r3][c3++];
					}
					r3++;
					c3 = 0;
				}
			
		 
	}
	
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_16935"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		str = br.readLine();
		st = new StringTokenizer(str);
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i<n; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			for (int j = 0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//for (int[] t : arr) System.out.println(Arrays.toString(t));
		
		int type;
		for (int i = 0; i<r; i++) {
			type = Integer.parseInt(br.readLine());
			
			switch (type) {
			
			case 1 :
				swap1();
				break;
			
			case 2 :
				swap2();
				break;
				
			case 3 :
				swap3();
				break;
				
			case 4 :
				swap4();
				break;
				
			case 5 :
				swap5();
				break;
			}
			
		}
		
		int maxNum = Math.max(m, n);
		
		for (int i = 0; i<n; i++) {
			for (int j = 0; j<m; j++) {
					System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}
