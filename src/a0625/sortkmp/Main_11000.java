package a0625.sortkmp;

import java.util.*;
import java.io.*;

public class Main_11000 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_11000"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> {
			if(o1[0] == o2[0]) return Integer.compare(o1[1],o2[1]);
			return Integer.compare(o1[0],o2[0]);
		});
		String str;
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i<n; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			pq.offer(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
		}
		
		
		//while(!pq.isEmpty()) System.out.println(Arrays.toString(pq.poll()));
		
		
		PriorityQueue<Integer> classEndTime = new PriorityQueue<>();
		classEndTime.offer(pq.poll()[1]);
		
		while(!pq.isEmpty()) {
			int[] t = pq.poll();
			
			int fastestClassEndTime = classEndTime.peek();
			
			if(t[0] >= fastestClassEndTime) {
				classEndTime.poll();
			}
			
			classEndTime.offer(t[1]);
			
		}
		
		

		
		System.out.println(classEndTime.size());
	}
}

