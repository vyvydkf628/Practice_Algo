//package 트리;
//
//public class 트라이 {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//	}
//	
//}
//
//class Trie {
//	TrieNode root;
//	public Trie() {
//		root = new TrieNode();
//	}
//	public void insert(String str) {
//		TrieNode curNode = root;
//		for (int i = 0; i < str.length(); i++) {
//			if (curNode.child[str.charAt(i)-'a'] != null) {
//				curNode = curNode.child[str.charAt(i)-'a'];
//			} else {
//				TrieNode childNode = new TrieNode();
//				curNode.child[str.charAt(i)-'a'] = childNode;
//				curNode = childNode;
//				
//			}
//		}
//		curNode.isWord = true;
//	}
//	public boolean search(String str) {
//		TrieNode curNode = root;
//		for (int i = 0; i < str.length(); i++) {
//			if (curNode.child[str.charAt(i)-'a'] != null) {
//				curNode = curNode.child[str.charAt(i)-'a'];
//			} else {
//				return false;
//			}
//		}
//		return curNode.isWord;
//	}
//}
//class TrieNode {
//	TrieNode[] child;
//	boolean isWord;
//	public TrieNode() {
//		child = new TrieNode[26];
//		isWord = false;
//	}
//	
//}