import java.util.*;

public class EasyDP_backjoon9095 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int dp[] = new int[11];
		int T = sc.nextInt();
		int num[] = new int[T];
		int max = Integer.MIN_VALUE;
		for (int roop = 0; roop < T; roop++) {
			num[roop] = sc.nextInt();
			if(max<num[roop])
				max = num[roop];
		}
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		//System.out.println(max);
		for(int i=4;i<=max;i++) {
			dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
		}
		for (int roop = 0; roop < T; roop++)
			System.out.println(dp[num[roop]]);
	}
}
