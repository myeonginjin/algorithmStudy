package study;


import java.util.*;

class AhoCorasick {
    private static final int ALPHABET_SIZE = 26;

    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        TrieNode failureLink;
        List<Integer> output = new ArrayList<>();
    }

    private final TrieNode root = new TrieNode();

    public void addPattern(String pattern, int index) {
        TrieNode node = root;
        for (char c : pattern.toCharArray()) {
            int charIndex = c - 'a';
            if (node.children[charIndex] == null) {
                node.children[charIndex] = new TrieNode();
            }
            node = node.children[charIndex];
        }
        node.output.add(index);
    }

    public void buildFailureLinks() {
        Queue<TrieNode> queue = new LinkedList<>();
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if (root.children[i] != null) {
                root.children[i].failureLink = root;
                queue.add(root.children[i]);
            } else {
                root.children[i] = root;
            }
        }

        while (!queue.isEmpty()) {
            TrieNode currentNode = queue.poll();

            for (int i = 0; i < ALPHABET_SIZE; i++) {
                if (currentNode.children[i] != null) {
                    TrieNode failure = currentNode.failureLink;
                    while (failure.children[i] == null) {
                        failure = failure.failureLink;
                    }
                    currentNode.children[i].failureLink = failure.children[i];
                    currentNode.children[i].output.addAll(failure.children[i].output);
                    queue.add(currentNode.children[i]);
                }
            }
        }
    }

    public List<Integer> search(String text) {
        List<Integer> result = new ArrayList<>();
        TrieNode node = root;

        for (int i = 0; i < text.length(); i++) {
            int charIndex = text.charAt(i) - 'a';

            while (node.children[charIndex] == null) {
                node = node.failureLink;
            }
            node = node.children[charIndex];

            if (!node.output.isEmpty()) {
                for (int patternIndex : node.output) {
                    result.add(i);  // Match found ending at index i
                }
            }
        }

        return result;
    }
}

    public class aho_corasick {
    	
        public static void main(String[] args) {
            AhoCorasick ahoCorasick = new AhoCorasick();

            // 패턴 추가
            String[] patterns = {"he", "she", "his", "hers"};
            for (int i = 0; i < patterns.length; i++) {
                ahoCorasick.addPattern(patterns[i], i);
            }

            // 실패 링크 빌드
            ahoCorasick.buildFailureLinks();

            // 텍스트 검색
            String text = "ahishers";
            List<Integer> result = ahoCorasick.search(text);

            for (int index : result) {
                System.out.println("Pattern found ending at index " + index);
            }
        }
    	
    }


