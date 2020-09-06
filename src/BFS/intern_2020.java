package BFS;
import java.util.*;

public class intern_2020 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = {{0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0, 1},{0, 0, 1, 0, 0, 0, 1, 0},{0, 1, 0, 0, 0, 1, 0, 0},{1, 0, 0, 0, 0, 0, 0, 0}};
		
		
		System.out.println(new intern_2020().solution(arr));
	}
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int[] type = {2,3,4,5};
	public static int solution(int[][] board) {
        int answer = 0;
        Queue<Position> que = new LinkedList<Position>();
        Position root = new Position(0, 0, 0, 0);
        que.add(root);
        int[][] dp = new int[board.length][board[0].length];
        while (!que.isEmpty()) {
        	Position cur = que.poll();
        	int i = cur.i;
        	int j = cur.j;
        	int curStatus = cur.status;
        	int curSum = cur.sum;
        	if (dp[i][j] != 0 && dp[i][j] < curSum) continue;
        	else dp[i][j] = curSum;
        	for (int x = 0; x < dx.length; x++) {
				int rows = dx[x] + i;
				int cols = dy[x] + j;
				int status = type[x];
				if (rows < board.length && cols < board[0].length && rows >= 0 && cols >=0 && board[rows][cols] == 0) {
					if (curStatus == 0) {
						que.add(new Position(rows, cols, status, curSum + 100));
					} else if (status == curStatus) {
						que.add(new Position(rows, cols, status, curSum + 100));
					} else {
						que.add(new Position(rows, cols, status, curSum + 600));
					}
				}
			}
        }
        return dp[board.length-1][board[0].length-1];
    }
	static class Position {
		int i;
		int j;
		int status;
		int sum;
		public Position(int i, int j, int status, int sum) {
			// TODO Auto-generated constructor stub
			this.i = i;
			this.j = j;
			this.status = status;
			this.sum = sum;
		}
	}
}
