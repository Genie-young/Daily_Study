import java.util.*;

public class EasyDP_backjoon11057 {

	public static void main(String[] args) {
		// N�� �־��� ��, ���̰� N�� ��� ���� �� �� �� �ִ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�. (0���� �����ϴ� ���� ����.)
		// ù° �ٿ� N�� �־�����. N�� 1���� ũ�ų� ����, 100���� �۰ų� ���� �ڿ����̴�
		// ������ 1000000000���� ���� �������� ���
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int dp[][] = new int[N + 1][10];
		for (int k = 0; k < 10; k++) {
			dp[1][k] = 1;
		}
		for (int i = 2; i <= N; i++) {
			for (int k = 0; k < 10; k++)
				for (int j = 0; j <= k; j++)
					dp[i][k] += (dp[i - 1][j]) % 10007;

		}
		long result = 0;
		for (int k = 0; k < 10; k++) {
			result = (result + dp[N][k]) % 10007;
		}
		System.out.println(result);

	}
}
