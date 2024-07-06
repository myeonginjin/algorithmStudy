package a0625.sortkmp;


//import java.util.*;
//import java.io.*;
//
//public class Main_1074_해결 {
//	static int n,ansR,ansC;
//	static int[][] arr;
//	static int cnt = 0;
//
//	static void div(int r, int rL , int c, int cL, int largeN) {
//		//정답 원소가 있는 2*2배열을 찾아 냈음
//		if(rL-r ==2) {
//			//해당 배열에서 가장 큰 원소의 값
//			largeN--;
//			
//			int t = ansR%2;
//			int t2 = ansC%2;
//			
//			if(t==1 && t2 ==0) largeN--;
//			else if (t==0 && t2 ==1) largeN -= 2;
//			else if (t==0 && t2 ==0) largeN -= 3;
//			cnt = largeN;
//
//			return;
//		}
//		
//
//		int rM = (r+rL)/2;
//		int cM = (c+cL)/2;
//		
//		//System.out.println(rM+" "+cM+" "+r+" "+c+" "+rL+" "+cL+" "+largeN);
//		
//		//정확한 위치는 모르지만, 왼쪽 위 구역에 포함되어 있음이 확실함
//		if(r <= ansR && ansR < rM && c <= ansC && ansC < cM ) {
//			//System.out.println("1");
//			div(r, rM, c, cM, largeN/4 *1);
//		}
//		
//		////정확한 위치는 모르지만, 오른쪽 위 구역에 포함되어 있음이 확실함 
//		else if (r <= ansR && ansR < rM && cM <= ansC && ansC < cL) {
//			//System.out.println("2");
//			div(r,rM, cM, cL, largeN/4 *2);
//		}
//		//정확한 위치는 모르지만, 왼쪽 아래
//		else if (rM <= ansR && ansR < rL && c <= ansC && ansC < cM) {
//			//System.out.println("3");
//			div(rM, rL, c, cM, largeN/4 *3);
//		}
//		//정확한 위치는 모르지만, 오른쪽 아래
//		else if (rM <= ansR && ansR < rL && cM <= ansC && ansC < cL) div(rM,rL, cM, cL, largeN/4 *4);
//	}
//
//	public static void main(String[] args) throws Exception {
//		//System.setIn(new FileInputStream("res/input_1074"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String str = br.readLine();
//		StringTokenizer st = new StringTokenizer(str);
//		n = Integer.parseInt(st.nextToken());
//		ansR = Integer.parseInt(st.nextToken());
//		ansC = Integer.parseInt(st.nextToken());
//		
//		arr = new int[(int) Math.pow(n,2)][(int)Math.pow(n,2)];
//		
//		div( 0 ,(int)Math.pow(2, n), 0, (int)Math.pow(2, n) , (int)Math.pow(2, n)*(int)Math.pow(2, n));
//		
//		System.out.println(cnt);
//	} 
//}

import java.util.*;
import java.io.*;

public class Main_1074_해결 {
    static int n, ansR, ansC;
    static int ansIndex = 0;

    static void div(int r, int rL, int c, int cL, int start) {
        // 2*2 크기의 배열이 되었을 때 처리
        if (rL - r == 2) {
        	//z순으로 첫번째 위치에 있
            if (ansR == r && ansC == c) ansIndex = start;
            //2번쨰 
            else if (ansR == r && ansC == c + 1) ansIndex = start + 1;
            //3번째 순...
            else if (ansR == r + 1 && ansC == c) ansIndex = start + 2;
            else if (ansR == r + 1 && ansC == c + 1) ansIndex = start + 3;
            return;
        }

        int rM = (r + rL) / 2;
        int cM = (c + cL) / 2;
        int halfSize = (rL - r) / 2;
        int areaSize = halfSize * halfSize;

        //정확한 위치는 모르지만, 왼쪽 위 구역에 포함되어 있음이 확실함
        if (ansR < rM && ansC < cM) {
            div(r, rM, c, cM, start);
        }
        //정확한 위치는 모르지만, 오른쪽 위 구역에 포함되어 있음이 확실함 
        else if (ansR < rM && ansC >= cM) {
            div(r, rM, cM, cL, start + areaSize);
        }
        // 왼쪽 아래
        else if (ansR >= rM && ansC < cM) {
            div(rM, rL, c, cM, start + 2 * areaSize);
        }
        // 오른쪽 아래
        else {
            div(rM, rL, cM, cL, start + 3 * areaSize);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        n = Integer.parseInt(st.nextToken());
        ansR = Integer.parseInt(st.nextToken());
        ansC = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, n);
        div(0, size, 0, size, 0);

        System.out.println(ansIndex);
    }
}

//
//
//import java.util.*;
//import java.io.*;
//
//public class Main_1074_해결 {
//	static int n,ansR,ansC;
//	static int[][] arr;
//	static int cnt = 0;
//
//	static void div(int r, int rL , int c, int cL, int largeN) {
//		//정답 원소가 있는 2*2배열을 찾아 냈음
//		if(rL-r ==2) {
//			//해당 배열에서 가장 큰 원소의 값
//			largeN--;
//			
//			int t = ansR%2;
//			int t2 = ansC%2;
//			
//			if(t==1 && t2 ==0) largeN--;
//			else if (t==0 && t2 ==1) largeN -= 2;
//			else if (t==0 && t2 ==0) largeN -= 3;
//			cnt = largeN;
//
//			return;
//		}
//		
//
//		int rM = (r+rL)/2;
//		int cM = (c+cL)/2;
//		
//		//System.out.println(rM+" "+cM+" "+r+" "+c+" "+rL+" "+cL+" "+largeN);
//		
//		//정확한 위치는 모르지만, 왼쪽 위 구역에 포함되어 있음이 확실함
//		if(r <= ansR && ansR < rM && c <= ansC && ansC < cM ) {
//			//System.out.println("1");
//			div(r, rM, c, cM, largeN/4 *1);
//		}
//		
//		////정확한 위치는 모르지만, 오른쪽 위 구역에 포함되어 있음이 확실함 
//		else if (r <= ansR && ansR < rM && cM <= ansC && ansC < cL) {
//			//System.out.println("2");
//			div(r,rM, cM, cL, largeN/4 *2);
//		}
//		//정확한 위치는 모르지만, 왼쪽 아래
//		else if (rM <= ansR && ansR < rL && c <= ansC && ansC < cM) {
//			//System.out.println("3");
//			div(rM, rL, c, cM, largeN/4 *3);
//		}
//		//정확한 위치는 모르지만, 오른쪽 아래
//		else if (rM <= ansR && ansR < rL && cM <= ansC && ansC < cL) div(rM,rL, cM, cL, largeN/4 *4);
//	}
//
//	public static void main(String[] args) throws Exception {
//		//System.setIn(new FileInputStream("res/input_1074"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String str = br.readLine();
//		StringTokenizer st = new StringTokenizer(str);
//		n = Integer.parseInt(st.nextToken());
//		ansR = Integer.parseInt(st.nextToken());
//		ansC = Integer.parseInt(st.nextToken());
//		
//		arr = new int[(int) Math.pow(n,2)][(int)Math.pow(n,2)];
//		
//		div( 0 ,(int)Math.pow(2, n), 0, (int)Math.pow(2, n) , (int)Math.pow(2, n)*(int)Math.pow(2, n));
//		
//		System.out.println(cnt);
//	} 
//}