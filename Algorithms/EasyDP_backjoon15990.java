import java.util.*;

public class EasyDP_backjoon15990 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int num[] = new int[T];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < T; i++) {
			num[i] = sc.nextInt();
			if (num[i] > max)
				max = num[i];
		}
		if (max <= 3)
			for (int i = 1; i <= T; i++)
				System.out.println();

		int dp[][] = new int[max + 1][4];
		dp[1][1] = dp[2][2] = dp[3][1] = dp[3][2] = dp[3][3] = 1;
		for (int i = 4; i <= max; i++) {
			dp[i][1] = (dp[i-1][2]+dp[i-1][3])%1000000009;
			dp[i][2] = (dp[i-2][1]+dp[i-2][3])%1000000009;
			dp[i][3] = (dp[i-3][1]+dp[i-3][2])%1000000009;
		}
		for (int i =0;i<T;i++) {
			long result =0;
			for(int k=1;k<4;k++) {
				result+= dp[num[i]][k];  
			}
			System.out.println(result%1000000009);
		}
	}
}
