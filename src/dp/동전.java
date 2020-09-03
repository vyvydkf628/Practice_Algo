package dp;
import java.util.*;
public class 동전 {
	static int count;
	static boolean[] checked;
	static int index;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			int cur = sc.nextInt();
			arr.add(cur);
		}
		count = 0;
		checked = new boolean[k+1];
		index = 0;
		Collections.sort(arr, Collections.reverseOrder());
		dfs(arr, k, 0);
		System.out.println(count);
	}
	public static boolean dfs(ArrayList<Integer> arr, int target, int sum) {
		if (target == sum) {
			count++;
			index++;
			return true;
		}
		for (int i = index; i < arr.size(); i++) {
			System.out.print(arr.get(i)+ " ");
			if (sum+ arr.get(i) < checked.length) {
				if (checked[sum+ arr.get(i)]== false) {
					checked[sum+ arr.get(i)] = dfs(arr, target, sum+ arr.get(i));
				}else {
					count++;
				}
			}
				
		}
		System.out.println();
		return false;
	}

}
