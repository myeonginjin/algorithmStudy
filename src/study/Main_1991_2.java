//package study;
//
//import java.util.*;
//import java.io.*;
//
//class Node {
//	char data;
//	Node left;
//	Node right;
//	
//	public Node (char d) {
//		this.data = d;
//		this.left = null;
//		this.right = null;
//	}
//	
//	public void setChild (Node l, Node r) {
//		this.left = l;
//		this.right = r;
//	}
//}
//
//public class Main_1991_2 {
//	static int n;
//	static StringBuilder sb = new StringBuilder();
//	static Node[] arr;
//	
//	static void preOrder(Node node) {
//		sb.append(node.data);
//		if(node.data >= 'A' + n -1) return;
//		
//		if(node.left != null) preOrder(node.left);
//		if(!Objects.isNull(node.right)) preOrder(node.right);
//	}
//	
//	static void inOrder(Node node) {
//		if(node.left != null) inOrder(node.left);
//		sb.append(node.data);
//		if(node.data >= 'A' + n -1) return;
//		if(!Objects.isNull(node.right)) inOrder(node.right);
//	}
//	
//	static void postOrder(Node node) {
//		if(node.left != null) postOrder(node.left);
//		if(!Objects.isNull(node.right)) postOrder(node.right);
//		sb.append(node.data);
//		if(node.data >= 'A' + n -1) return;
//	}
//	
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String str;
//		StringTokenizer st;
//		
//		n = Integer.parseInt(br.readLine());
//		arr = new Node[n+1]; for (int i = 1; i<=n; i++) {
//			arr[i] = new Node((char)('A' + i - 1));
//		}
//		for (int i = 0; i<n; i++) {
//			str = br.readLine();
//			st = new StringTokenizer(str);
//			char root = st.nextToken().charAt(0);
//			char leftChild = st.nextToken().charAt(0);
//			char rightChild = st.nextToken().charAt(0);
//			
//			leftChild = leftChild=='.' ? (char)0 : (char)(leftChild - 'A' + 1);
//			rightChild = rightChild=='.' ? (char)0 : (char)(rightChild - 'A' + 1);
//			
//			
//			arr[root - 'A' +1].setChild(arr[leftChild], arr[rightChild]);
//		}
//		preOrder(arr[1]);
//		sb.append("\n");
//		inOrder(arr[1]);
//		sb.append("\n");
//		postOrder(arr[1]);
//		System.out.println(sb);
//		
//	}
//}
