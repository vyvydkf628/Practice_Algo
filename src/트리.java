import java.util.*;
public class 트리 {
	static ArrayList<ArrayList<Integer>> graph;
	static int count;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] parent = new int[N];
		int root;
		for (int i = 0; i < parent.length; i++) {
			parent[i] = sc.nextInt();
			if (parent[i] == -1) {
				root = i;
			}
		}
		int delete = sc.nextInt();
		graph = new ArrayList<>();
		for (int i = 0; i < N+1; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < parent.length; i++) {
			int start = parent[i];
			int end = i;
			if (start == -1) {
				start = N;
			}
			graph.get(start).add(end);
		}
		count = 0;
		dfs(graph.get(N), delete);
		findLeaf(graph.get(N));
		if (parent[delete] == -1) {
			System.out.println(0);
		}else {
			System.out.println(count);
			
		}
	}
	public static void dfs(ArrayList<Integer> node, int delete) {
		if (node.size() == 0) return;
		for (int i = 0; i < node.size(); i++) {
			if (node.get(i) == delete) {
				node.remove(i);
				return;
			}
			dfs(graph.get(node.get(i)), delete);
		}
	}
	public static void findLeaf(ArrayList<Integer> node) {
		if (node.size() == 0) {
			count++;
		}
		for (int i = 0; i < node.size(); i++) {

			findLeaf(graph.get(node.get(i)));
		}
	}


}
