package BFS;

import java.util.*;

public class Intern_2020_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public boolean solution(int n, int[][] path, int[][] order) {
        boolean answer = true;
        ArrayList<Node> graph = new ArrayList<>();
        for (int i = 0; i < path.length+1; i++) {
			graph.add(new ArrayList<Node>());
		}
        for (int i = 0; i < path.length; i++) {
        	int start = path[i][0];
        	int end = path[i][1];
        	graph.get(start).add(new Node(end));
        	graph.get(end).add(new Node(start));
        }
        for (int i = 0; i < order.length; i++) {
			int isFirst = order[i][0];
			int isEnd = order[i][1];
			graph.get(is)
		}/
        return answer;
    }
}
class Node {
	int end;
	boolean isFirst;
	boolean isEnd;
	int firstNumber;
	ArrayList<Node> child;
	public Node(int end) {
		// TODO Auto-generated constructor stub
		this.end = end;
		child = new ArrayList<Node>();
	}
}
