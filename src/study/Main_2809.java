package study;

import java.io.*;
import java.util.*;

public class Main_2809 {
	
	static class Node {
		Node[] childs;
		Node failLink;
		ArrayList<String> outPuts;
		
		public Node() {
			childs = new Node[26];
			failLink = null;
			outPuts = new ArrayList<>();
		}
	}
	
	static Node root = new Node();
	
	static void makeTrie(String pattern) {
		Node node = root;
		
		for (int i = 0; i<pattern.length(); i++) {
			int c = pattern.charAt(i) - 'a';
			
			if(node.childs[c]==null) {
				node.childs[c] = new Node();
			} 
			
			node = node.childs[c];
		}
		node.outPuts.add(pattern);
	}
	
	static void makeFailLink() {
		Queue<Node> q = new LinkedList<>();
		
		for (int i = 0; i<26; i++) {
			if(root.childs[i]!=null){
				q.offer(root.childs[i]);
				root.childs[i].failLink = root;
			}
			else {
				root.childs[i] = root;
			}
		}
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			for (int i = 0; i<26; i++) {
				if(node.childs[i]!=null) {
					
					Node lastFailLink = node.failLink;
					
					while(lastFailLink.childs[i]==null) {
						lastFailLink = lastFailLink.failLink;
					}
					
					
					node.childs[i].failLink = lastFailLink.childs[i];
					node.childs[i].outPuts.addAll(lastFailLink.childs[i].outPuts);
					q.add(node.childs[i]);
				}
			}
		}
	}
	
	static boolean search(String text) {
		Node node = root;
		
		for (int i = 0; i<text.length(); i++) {
			
			int c = text.charAt(i) - 'a';
			
			//Node failNode = node;
			
			while(node.childs[c] == null) {
				node = node.failLink;
			}
			node = node.childs[c];   //왜?
			
			if(node.outPuts.size()>0) return true;
			
		}
		
		
		return false;
	}

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		int n = Integer.parseInt(br.readLine());
//		String text = br.readLine();
//		
//		int m = Integer.parseInt(br.readLine());
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i<n; i++) {
			makeTrie(br.readLine());
		}
		makeFailLink();
		
		int m = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i<m; i++) {
			if(search(br.readLine())) sb.append("YES").append("\n");
			else sb.append("NO").append("\n");
		}
		
		System.out.println(sb);
		
		
	}

}
