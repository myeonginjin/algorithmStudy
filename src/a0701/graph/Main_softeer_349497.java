package a0701.graph;

import java.io.*;
import java.util.*;

public class Main_softeer_349497 {
    static HashSet<Integer> hs = new HashSet<>();
    static HashSet<Integer> hs2 = new HashSet<>();
    static ArrayList<Integer>[] g;
    static ArrayList<Integer>[] reverseG;
    static int s,t;
    static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        g = new ArrayList[n+1]; for (int i = 0; i<=n; i++) g[i] = new ArrayList<>();
        reverseG = new ArrayList[n+1]; for (int i = 0; i<=n; i++) reverseG[i] = new ArrayList<>();
        
        for (int i = 0; i<m; i++) {
            int go = sc.nextInt();
            int to = sc.nextInt();

            g[go].add(to);
            reverseG[to].add(go);
        }

        s = sc.nextInt();
        t = sc.nextInt();

        boolean[] v1 = new boolean[n+1]; //출근길 순방향
        v1[t] = true;
        dfs(s, g, v1, t);

        boolean[] v4 = new boolean[n+1]; //퇴근길 역방향
        // v4[s] = true;
        dfs(t, reverseG, v4, s);  

        //여기까지 출근길 구하기


        boolean[] v2 = new boolean[n+1]; //출근길 역방향
        //v2[t] = true;
        dfs(s, reverseG, v2, t); 

        boolean[] v3 = new boolean[n+1]; //퇴근길 순방향
        v3[s] = true;
        dfs(t, g, v3, s);

        //여기까지 퇴근길 구하기

        for (int i = 1; i<=n; i++) {
            if(i == s || i == t ) continue;
            
            if(v1[i] && v2[i] && v3[i] && v4[i]) {
                cnt++;
            }
        }

        // System.out.println(Arrays.toString(v1));
        // System.out.println(Arrays.toString(v2));
        // System.out.println(Arrays.toString(v3));
        // System.out.println(Arrays.toString(v4));

       System.out.println(cnt);

    }

    static void dfs(int n, ArrayList<Integer>[] arr, boolean[] v, int stop) {
        if(v[n]) return;

        v[n] = true;
        
        for (int i = 0; i<arr[n].size(); i++){
            int next = arr[n].get(i);
                
            dfs(next, arr, v, stop);
        }

        
    }


}
