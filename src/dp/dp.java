package dp;
import java.util.*;
public class dp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		int[] dp = new int[n+1];
		for (int i = 1; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i] = Math.max(dp[i], dp[i-j] + arr[j]);
			}
		}
		System.out.println(dp[arr.length-1]);
	}

}
