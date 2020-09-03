import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	
	static boolean[][] visit;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	public static void bfs(int[][] arr, int rows, int cols) {
		Queue<Integer> que = new LinkedList<>();
		que.add(arr[rows][cols]);
		int size = que.size();
		int count = 0;
		while(!que.isEmpty()) {
			if (size == 0) {
				size = que.size();
				count++;
			}
			size--;
			int current = que.poll();
			
		}
	}
}
