import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RefArrayList {
/*
 * ArrayList
 * get(int index)
 * set(int index, <E>)
 * contains : return boolean
 * indexOf
 * ArrayList arr . as 
 * 
 * 
 * 중요 *배열 리스트로 바꾸기!!!!!!!!
 * ArrayList<String> arr = new ArrayList<>(Arrays.asList(int[] arr));
 * 
 * 중요 * 인트 리스트를 배열로!!!!
 * int[] array = list.stream().mapToInt(i->i).toArray();
 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new  int[4];
		ArrayList<String> s = new ArrayList<>();
		s.add("C");
		s.add("B");
		s.add("A");
		ArrayList<String> res = sort(s);
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}
	}
	
	public static ArrayList<String> sort(ArrayList<String> arr) {
		Collections.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				System.out.println(s1.compareTo(s2));
				// TODO Auto-generated method stub
				return s1.compareTo(s2);
			}
		});
		return arr;
	}
	
}
