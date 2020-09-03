import java.util.ArrayList;
import java.util.List;

public class CombiPermu {

	static boolean[] visit;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] target = {1,2,3,4,5,6};
		visit = new boolean[target.length];
//		combi(target, 3, new ArrayList<Integer>());
		permu(target, 3, new ArrayList<Integer>(), 0);

	}
	public static void permu(int[] arr, int max, ArrayList<Integer> cur, int index) {
		if (cur.size() == max) {
			for (int i = 0; i < cur.size(); i++) {
				System.out.print(cur.get(i));
			}
			System.out.println();
		}
		for (int i = index; i < arr.length; i++) {
			if (visit[i] == false) {
				visit[i] = true;
				cur.add(arr[i]);
				permu(arr, max, cur, i+1);
				visit[i] = false;
				cur.remove(cur.size()-1);
			}
		}
	}
	public static void combi(int[] arr, int max, ArrayList<Integer> cur) {
		if (cur.size() == max) {
			for (int i = 0; i < cur.size(); i++) {
				System.out.print(cur.get(i));
			}
			System.out.println();
		}
		for (int i = 0; i < arr.length; i++) {
			if (visit[i] == false) {
				visit[i] = true;
				cur.add(arr[i]);
				combi(arr, max, cur);
				visit[i] = false;
				cur.remove(cur.size()-1);
			}
		}
	}

}
