package 트리;
import java.util.*;
public class 트리1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); 
		for (int i = 0; i < n+1; i++) {
			graph.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < n-1; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			graph.get(start).add(end);
			graph.get(end).add(start);
		}
		int q = sc.nextInt();
		for (int i = 0; i < q; i++) {
			int t = sc.nextInt();
			int k = sc.nextInt();
			if (t == 1) {
				if (graph.get(k).size() >= 2) {
					System.out.println("Yes");
				} else {
					if (n == 2) {
						System.out.println("Yes");
					} else {
						System.out.println("No");
					}
				}
			} else {
				System.out.println("Yes");
			}
		}
	}

}
