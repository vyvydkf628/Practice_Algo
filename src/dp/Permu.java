package dp;
import java.util.*;
public class Permu {
	static int count;
	static int[][] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		count = 0;
		dp = new int[n+1][k+1];
		find(0, n, k );
		System.out.println(dp[0][0] % 1000000000);
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				System.out.print(dp[i][j]);
			}
		}
	}
	
	public static int find(int sum, int n, int k) {
		if (n == sum && k == 0) {
			dp[n][k] += 1;
			return 1;
		};
		int total = 0;
		if (k == 0) return 0;
		
		for (int i = 0; i <= n; i++) {
			if (i+ sum <= dp.length-1) {
				if (dp[i+sum][k-1] != 0) {
					total += dp[i+sum][k];
				}else {
					total += find(i + sum, n, k-1);
				}
				System.out.println(total);
			}
		}
		dp[sum][k] = total % 1000000000;
		return total;
	}
}
