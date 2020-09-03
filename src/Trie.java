import java.util.ArrayList;
import java.util.Arrays;

public class Trie {
	TrieNode root;
	public Trie() {
		root = new TrieNode();
	}
	public void insert(String str) {
		TrieNode curNode = root;
		for (int i = 0; i < str.length(); i++) {
			if (curNode.child[str.charAt(i)-'a'] != null) {
				curNode = curNode.child[str.charAt(i)-'a'];
			} else {
				curNode = new TrieNode();
			}
		}
		curNode.isWord = true;
	}
	public boolean search(String str) {
		TrieNode curNode = root;
		for (int i = 0; i < str.length(); i++) {
			if (curNode.child[str.charAt(i)-'a'] != null) {
				curNode = curNode.child[str.charAt(i)-'a'];
			} else {
				return false;
			}
		}
		return true;
	}
}
class TrieNode {
	TrieNode[] child;
	boolean isWord;
	public TrieNode() {
		child = new TrieNode[26];
		isWord = false;
	}
	
}
