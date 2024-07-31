package study;

import java.io.*;
import java.util.*;

public class Main_9250 {
	
	static class Node {
		Node[] child;
		Node failLink;
		ArrayList<String> outPuts;
		
		public Node() {
			child = new Node[26];
			failLink = null;
			outPuts = new ArrayList<>();
		}
	}
	
	static Node root = new Node();
	
	static void makeTrie(String pattern) {
		Node node = root;
		
		for (char t : pattern.toCharArray()) {
			int c = t - 'a';
			
			
			if(node.child[c] == null) {
				node.child[c] = new Node();
				
				node = node.child[c];
			} else {
				node = node.child[c];
			}
		}
		node.outPuts.add(pattern);
	}
	
	static void makeFailLink() {
		Queue<Node> q = new LinkedList<>();
		
		for (int i = 0; i<root.child.length; i++) {
			if(root.child[i]!= null) {
				q.offer(root.child[i]);
				root.child[i].failLink = root;
			} else {
				root.child[i] = root;
				}
			}
			
			while(!q.isEmpty()) {
				Node node = q.poll();
				
				for (int i = 0; i<node.child.length; i++) {
						if(node.child[i]==null) continue;
						
						Node failNode = node.failLink;
						
						while(failNode.child[i] == null) {
							failNode = failNode.failLink;
						}
						
						if(failNode.child[i]==null) {
							node.child[i].failLink = root;
							continue;
						}
						
						node.child[i].failLink =  failNode.child[i];
						node.child[i].outPuts.addAll(failNode.child[i].outPuts);
						
						q.offer(node.child[i]);
					}
				}
		}
	
	static boolean search(String text) {
		Node node = root;
		
		for (int i = 0; i<text.length(); i++) {
			int c = text.charAt(i) - 'a';
			
			while(node.child[c] == null) {
				node = node.failLink;
			}
			
			node = node.child[c];
			if(node == null) {
				node = root;
				continue;
			}
			
			if(node.outPuts.size()>0) return true;
			
			
			
		}
		
		return false;
	}
		
		

	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		
		
		for (int i = 0; i<n; i++) {
			makeTrie(br.readLine());
		}
		
		makeFailLink();
		
		int q = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i<q; i++) {
			if(search(br.readLine())) sb.append("YES").append("\n");
			else sb.append("NO").append("\n");
		}
		
		System.out.println(sb);

		
	}

}
