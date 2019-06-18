import java.util.*;

public class EasyDP_backjoon10844 {

	public static void main(String[] args) {
		// N�� �־��� ��, ���̰� N�� ��� ���� �� �� �� �ִ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�. (0���� �����ϴ� ���� ����.)
		// ù° �ٿ� N�� �־�����. N�� 1���� ũ�ų� ����, 100���� �۰ų� ���� �ڿ����̴�
		// ������ 1000000000���� ���� �������� ���
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
