package a0625.sortkmp;

import java.util.*;
import java.io.*;

public class Main_11000 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_11000"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> {
			if(o1[1] == o2[1]) return -Integer.compare(o1[0],o2[0]);
			return Integer.compare(o1[1],o2[1]);
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
		
		
		int cnt = 1;
		
		
		while(true) {
			
			int[] fir = pq.poll();
			int preClassEndTime = fir[1];
			
			PriorityQueue<int[]> temp = new PriorityQueue<>((o1,o2) -> {
				if(o1[1] == o2[1]) return -Integer.compare(o1[0],o2[0]);
				return Integer.compare(o1[1],o2[1]);
			});
			

			
			while (!pq.isEmpty()) {
				int[] t = pq.poll();
				
				
				if(t[0] >= preClassEndTime) {
					preClassEndTime = t[1];
				}
				else {

					temp.offer(t);
				}				
			}
			
			if(temp.isEmpty()) break;
			
			if(temp.size()==1) {
				cnt++;
				break;
			}
			
			cnt++;
			pq = temp;

		}
		
		
		
		System.out.println(cnt);
	}
}


//public static void main(String[] args) throws Exception {
//    System.setIn(new FileInputStream("res/input_11000"));
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
//    
//    int n = Integer.parseInt(br.readLine());
//    for (int i = 0; i < n; i++) {
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int Si = Integer.parseInt(st.nextToken());
//        int Ti = Integer.parseInt(st.nextToken());
//        pq.offer(new int[] { Si, Ti });
//    }
//    
//    // 최소 힙 사용
//    PriorityQueue<Integer> rooms = new PriorityQueue<>();
//    rooms.offer(pq.poll()[1]); // 첫 번째 수업의 종료 시간을 넣음
//    
//    while (!pq.isEmpty()) {
//        int[] current = pq.poll();
//        int start = current[0];
//        int end = current[1];
//        
//        // 가장 빨리 끝나는 강의실을 찾음
//        if (rooms.peek() <= start) {
//            rooms.poll(); // 기존 강의실의 종료 시간을 업데이트
//        }
//        
//        rooms.offer(end); // 새로운 강의실을 할당
//    }
//    
//    // 필요한 강의실의 개수는 강의실의 크기(강의실 개수)
//    System.out.println(rooms.size());
//}
