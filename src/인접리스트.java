import java.awt.Point;
import java.util.ArrayList;

public class 인접리스트 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] test = {{1,1,1},{1,1,1},{1,1,1},{1,1,1}};
		insertGraph(test, 4);
		
	}
	static ArrayList<ArrayList<Point>> graph;

	public static void insertGraph(int[][] arr, int point) {
		graph = new ArrayList<>(point);
		for (int i = 0; i < point; i++) {
			graph.add(new ArrayList<Point>());
		}
		System.out.println(graph.size());
		for (int i = 0; i < arr.length; i++) {
//			같은 경로에 두개의 가중치가 들어올 수 있다. 체크해야돼;
			int start = arr[i][0];
			int end = arr[i][1];
			int w = arr[i][2];
			
			graph.get(start).add(new Point(end, w));
			graph.get(end).add(new Point(start, w));
		}
	}

}
