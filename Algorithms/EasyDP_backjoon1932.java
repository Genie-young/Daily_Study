import java.util.*;

public class EasyDP_backjoon1932 {
	static int ArrayMax(int[] a) {
		int max = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] > max)
				max = a[i];
		}
		return max;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int triangle[][] = new int[N][N];
		int dp[][] = new int[N][N];

		for (int i = 0; i < N; i++)
			for (int k = 0; k <= i; k++)
				//triangle[i][k] = 9999;
				triangle[i][k] = sc.nextInt();
		dp[0][0] = triangle[0][0];
		for (int i = 1; i < N; i++)
			for (int k = 0; k <= i; k++) {
				dp[i][k] = triangle[i][k];
				if (k == 0)
					dp[i][k] += dp[i - 1][k];
				else if (k == i)
					dp[i][k] += dp[i - 1][k - 1];
				else {
					//System.out.println("MAX= "+  dp[i - 1][k - 1] + " " +  dp[i - 1][k]+" "+Math.max(dp[i - 1][k - 1], dp[i - 1][k + 1]));
					dp[i][k] += Math.max(dp[i - 1][k - 1], dp[i - 1][k]);
				}
			}

		System.out.println(ArrayMax(dp[N - 1]));
	}
}
