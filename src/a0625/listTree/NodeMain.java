package a0625.listTree;

public class NodeMain {
	static class Node {
		int vertex;
		Node link;
		Node(int vertex, Node link) {
			this.vertex = vertex;
		}
		
		@Override
		public String toString() {
			return vertex+ "->" + link;
		}
	}
	
	public static void main(String[] args) {
		
	}

}
