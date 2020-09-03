package useful;

import java.util.ArrayList;
import java.util.List;

public class Function {
	public static void printArray(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	public static List<Integer> toList(int[] ints ){
		List<Integer> intList = new ArrayList<Integer>(ints.length);
		for (int i : ints)
		{
		    intList.add(i);
		}
		return intList;
	}
}
