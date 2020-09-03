import java.util.ArrayList;
import java.util.List;

import useful.Function;
public class Turn90 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = new int[5][5];
		int count = 1;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j]= count++;
			}
		}
		int[][] test = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
		int[][] result = makeBack(test, test);
		Function.printArray(result);
		List<Integer> res = Function.toList(new int[] {1,2,3,4});
		for (int i = 0; i < res.size(); i++) {
			System.out.println("LIst " + res.get(i));
		}
		result = turn90(arr);
		Function.printArray(result);
	}
	public static int[][] turn90(int[][] arr) {
		int[][] rotate = new int[arr.length][arr[0].length];
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				rotate[i][j] = arr[arr[0].length-1-j][i];
			}
		}
		return rotate;
	}
	
	public static int[][] makeBack(int[][] key, int[][] lock) {
		int[][] background = new int[2* (key.length-1) + lock.length][2* (key[0].length-1) + lock[0].length];
		for (int i = key.length - 1; i < background.length -(key.length -1); i++) {
			for (int j = key[0].length - 1; j < background[0].length - (key[0].length -1); j++) {
				background[i][j] = lock[i-( key.length - 1)][j - ( key.length - 1)];
			}
		}
				
		return background;
	}
}
