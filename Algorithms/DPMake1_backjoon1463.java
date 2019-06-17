import java.util.*;

public class DPMake1_backjoon1463 {
	// static boolean[] c = new boolean[10];
	static int[] a = new int[10];

	static void go(int index, int n, int m) {
		if (index == m) {
			// StringBuilder sb = new StringBuilder();
			for (int i = 0; i < m; i++) {
				System.out.print(a[i]);
				if (i != m - 1)
					System.out.print(" ");
			}
			System.out.println();
			return;
			// return sb;
		}

		// StringBuilder ans = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			// if (c[i]) continue;
			// c[i] = true;
			a[index] = i;
			go(index + 1, n, m);
			// c[i] = false;
		}
		// System.out.println("ans ==> "+ans);
		// return ans;
		return;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int dp[] = new int[n + 1];
		if (n == 1) {
			System.out.println("0");
			return;
		}
		if (n <= 3) {
			System.out.println("1");
			return;
		}
		dp[1] = 0;
		dp[2] = dp[3] = 1;
		for (int i = 4; i <= n; i++) {
			int min = Integer.MAX_VALUE;

			if (dp[i - 1] < min)
				min = dp[i - 1];
			if (i % 3 == 0 && dp[i / 3] < min)
				min = dp[i / 3];
			if (i % 2 == 0 && dp[i / 2] < min)
				min = dp[i / 2];

			dp[i] = min + 1;
		}
		System.out.println(dp[n]);
	}
}