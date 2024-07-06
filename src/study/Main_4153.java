package study;

import java.util.*;

public class Main_4153 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        while (true) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int n3 = sc.nextInt();
            if(n1==0 && n2 == 0 && n3==0) break;
            
            int max = 0, mid=0, min=0;
            
            int[] arr = {n1,n2,n3};
            Arrays.sort(arr);
            min = arr[0];
            mid = arr[1];
            max = arr[2];
            
            String ans = Math.pow(mid,2) + Math.pow(min,2) == Math.pow(max,2) && (min!=0 && max!=0 && mid!=0)  ? "right" : "wrong";
            sb.append(ans).append("\n");
            
        }
        System.out.println(sb);
        sc.close();
    }
}


