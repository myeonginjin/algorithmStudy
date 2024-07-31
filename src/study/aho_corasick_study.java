package study;


import java.util.*;



public class aho_corasick_study {
	static Node rootNode = new Node();
		
	static class Node {
		Node[] childs;
		ArrayList<Integer> outPuts;
		Node failLink;
		
		public Node() {
			childs = new Node[26];
			outPuts = new ArrayList<>();
			failLink = null;
		}
	}
	
	static void makeTrie (String pattern, int index) {	
		Node node = rootNode;
		
		for (char c : pattern.toCharArray()) {
			int t = c - 'a';
			if(node.childs[t]==null) {
				node.childs[t] = new Node();
			}
			
			node = node.childs[t];
		}
		node.outPuts.add(index);
	}
	
	static void makeFailLink() {
		Queue<Node> q = new LinkedList<>();
		
		for (int i = 0; i<rootNode.childs.length; i++) {
			if(rootNode.childs[i] != null) {
				q.offer(rootNode.childs[i]);
				rootNode.childs[i].failLink = rootNode;
			} else {
				//없어도 동작하지만, 루트의 26개의 자식 중 링크될 노드가 있는지 모두 탐색하다가 없어서
				//루드노드를 페일링크로 연결하는 비효율적인 작업을 바로 끝내줌 (해당 값의 자식이 루트 노드의 자식으로 없으면 바로 루트로 링크)
				rootNode.childs[i] = rootNode;
			}
		}
		
		while (!q.isEmpty()) {
			Node curNode = q.poll();
			
			
			for (int i = 0; i<curNode.childs.length; i++) {
				if(curNode.childs[i]!= null) {
					
					//curNode.childs[i]에 i값이 바뀌며 새로운 자식을 찾을 때마다 failLink는 다시 curNode(i들의 부모노드)의 페일링크로 초기화되어야함. 왜? 특정 자식이 이 페일링크의 위치를 타고타고 트리 위에다가 가져다놨을 수도 있기 때
					Node failLink = curNode.failLink;
					
					while (failLink.childs[i] == null) {
						//부모노드의 페일 링크 노드의 자식 중 이어질 곳이 없다면(현재 내 노드의 알파벳을 가진 노드가 없다면) 부모노드의 페일링크의 페일링크로 이동 이걸 무한반복 
						failLink = failLink.failLink;
					}
					//현재 노드의 부모 노드의 페일링크로 이동 -> 이 페일링크 노드의 자식 노드중 현재 노드의 알파벳 값을 가진 노드를 페일링크로 연결
					curNode.childs[i].failLink = failLink.childs[i];
					//현재 노드외 연결된 페일링크 노드의 아웃풋 패턴이 있었다면 이 패턴을 현재 노드에서도 반환할 수 있도록 해줌  (ex. she he)
					curNode.childs[i].outPuts.addAll(failLink.childs[i].outPuts);
					
					q.offer(curNode.childs[i]);
				}
				
			}
		}
		
	}
	
	//공부하기 
    static List<int[]> search(String text) {
        List<int[]> results = new ArrayList<>();
        Node node = rootNode;
        
        for (int i = 0; i < text.length(); i++) {
            int t = text.charAt(i) - 'a';
            
            while (node.childs[t] == null && node != rootNode) {
                node = node.failLink;
            }
            
            node = node.childs[t];
            if (node == null) {
                node = rootNode;
                continue;
            }
            
            for (int patternIndex : node.outPuts) {
                results.add(new int[]{patternIndex, i});
            }
        }
        
        return results;
    }
	
	
	
	public static void main(String[] args) {	
		String[] patterns = new String[] {"achy", "cache","chef","he"};
		
		for (int i = 0; i<patterns.length; i++) {
			makeTrie(patterns[i],i);
		}
		makeFailLink();
		
        String text = "achefache";
        List<int[]> results = search(text);
        
        for (int[] result : results) {
            System.out.println("Pattern " + patterns[result[0]] + " found ending at index " + result[1]);
        }
        
	}

}
