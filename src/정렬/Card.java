package 정렬;
import java.util.*;
public class Card {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] arr = new long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextLong();
		}
		Arrays.sort(arr);
		long max = arr[0];
		int count = 1;
		long temp = arr[0];
		int tempCount = 1;
		long result = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i-1] == arr[i]) {
				count++;	
			} else {

				if (count > tempCount) {
					result = max;
				} else if (tempCount == count) {
					result = Math.min(temp, max);
					max = result;
				}
				tempCount = count;
				temp = max;
				max = arr[i];
				count = 1;
			}
			
		}
		if (count > tempCount) {
			result = max;
		} else if (tempCount == count) {
			result = Math.min(temp, max);
		}

		System.out.println(result);
	}

}
