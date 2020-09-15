package 트리;
import java.util.*;
public class 트라이해쉬 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie tree = new Trie();
		tree.insert("abc");
		tree.insert("ab");
		tree.insert("abcd");
		tree.insert("xad");
		System.out.println(tree.search("ab"));
	}

}

class TrieNode {
	public Map<Character, TrieNode> child;
	boolean isWord;
	public TrieNode() {
		// TODO Auto-generated constructor stub
		child = new HashMap<>();
		isWord = false;
	}
}

class Trie {
	TrieNode root;
	public Trie() {
		root = new TrieNode();
	};
	public void insert(String word) {
		TrieNode curNode = root;
		for (int i = 0; i < word.length(); i++) {
			if (curNode.child.containsKey(word.charAt(i))) {
				curNode = curNode.child.get(word.charAt(i));
			} else {
				TrieNode childNode = new TrieNode();
				
				curNode.child.put(word.charAt(i), childNode);
				curNode = childNode;
			}
		}
		curNode.isWord = true;
	}
	boolean search(String word) {
		TrieNode curNode = root;
		for (int i = 0; i < word.length(); i++) {
			char character = word.charAt(i);
			TrieNode childNode = curNode.child.get(character);
			if (childNode == null) return false;
			curNode = childNode;
		}
		return curNode.isWord;
	}
	
}
