	package a0619.recu;
	
	import java.io.*;
	import java.util.*;
	import java.lang.*;
	
	public class Main_bj_1244_스위치켜고끄기_진명인 {
		public static int n;
		public static int[] switchs;
		
		public static void manDo (int num) {
			int mul = 1;
			
			while(num*mul <= n) {
				int onOff = switchs[num*mul -1] == 1 ? 0 : 1;
				switchs[num*mul -1] = onOff;
				
				mul++;
			}
		}
		
		public static void girlDo(int num) {
			int index = num -1;
			
			int strIndex = index-1;
			int lastIndex = index+1;
			
			//System.out.println(num+" "+strIndex+" "+lastIndex);
			

		
			if((strIndex < 0 || lastIndex >=n) || switchs[strIndex] != switchs[lastIndex]) {
				int temp = switchs[index] == 1 ? 0 : 1;
				switchs[index] = temp;
				return;
			}
			
			while (true) {
				if((strIndex < 0 || lastIndex >=n) || switchs[strIndex] != switchs[lastIndex]) {
					break;
				}
				strIndex--;
				lastIndex++;
			}
			
			for (int i = strIndex+1; i<lastIndex; i++) {
				//System.out.println(strIndex+" "+lastIndex);
				
				int onOff = switchs[i] == 1 ? 0 : 1;
				switchs[i] = onOff;
			}
			
		}
		
		public static void main (String[] args) throws Exception {
			System.setIn(new FileInputStream("res/input_bj_1244"));
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb = new StringBuilder();
			String str;
			StringTokenizer st = null;
			
			n = Integer.parseInt(br.readLine());
			switchs = new int[n];
			
			str = br.readLine();
			st = new StringTokenizer(str);
			
			for (int i = 0; i<n; i++) {
				switchs[i] = Integer.parseInt(st.nextToken()); 
			}
			
			int sNum = Integer.parseInt(br.readLine());
			
			for (int i = 0; i<sNum; i++) {
				str = br.readLine();
				st = new StringTokenizer(str);
				
				if (Integer.parseInt(st.nextToken()) == 1) {
					manDo(Integer.parseInt(st.nextToken()));
				}
				else {
					girlDo(Integer.parseInt(st.nextToken()));
				}
				//System.out.println(Arrays.toString(switchs));
			}

			//System.out.println("=====");
			for (int i = 0; i<n; i++) {
				System.out.print(switchs[i]+" ");
				
				if (i != 0 && (i+1) % 20 == 0) {
					System.out.println();
				}
			}
			
		}
	
	}
