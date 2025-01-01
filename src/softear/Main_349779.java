package softear;

import java.io.*;
import java.util.*;

public class Main_349779 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = 0;

        int weight = sc.nextInt();
        int n = sc.nextInt();

        int[] w = new int[n];

        PriorityQueue<int[]> q = new PriorityQueue<>( (o1, o2) -> -Integer.compare(o1[1] , o2[1] )  );

        for (int i = 0; i<n; i++) {
            q.add(new int[]{sc.nextInt(), sc.nextInt()});
        }

        for (int i = 0; i<n; i++) {
            int[] t = q.poll();

            int wei = t[0];
            int price = t[1];
            
            if(weight >= wei) { //모두 담을 수 있음
                total += wei * price;
                weight -= wei;
            }

            else { //톱으로 잘라 넣기
                total += weight * price;
                break;
            }
        }
        System.out.print(total);
    }
}