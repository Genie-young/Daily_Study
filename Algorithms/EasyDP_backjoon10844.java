import java.util.*;

public class EasyDP_backjoon10844 {

	public static void main(String[] args) {
		// N이 주어질 때, 길이가 N인 계단 수가 총 몇 개 있는지 구하는 프로그램을 작성하시오. (0으로 시작하는 수는 없다.)
		// 첫째 줄에 N이 주어진다. N은 1보다 크거나 같고, 100보다 작거나 같은 자연수이다
		// 정답을 1000000000으로 나눈 나머지를 출력
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long dp[][] = new long[N + 1][10];
		for (int k = 1; k < 10; k++) {
			dp[1][k] = 1;
		}
		for (int i = 2; i <= N; i++) {
			for (int k = 0; k < 10; k++) {
				if (k == 0)
					dp[i][k] = (dp[i - 1][k + 1]) % 1000000000;
				else if (k == 9)
					dp[i][k] = (dp[i - 1][k - 1]) % 1000000000;
				else
					dp[i][k] = (dp[i - 1][k - 1] + dp[i - 1][k + 1]) % 1000000000;
			}
		}
		long result=0;
		for (int k = 0; k < 10; k++) {
			result= (result+dp[N][k])% 1000000000;
		}
		System.out.println(result);

	}
}
