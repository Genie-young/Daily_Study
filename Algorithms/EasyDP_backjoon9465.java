import java.util.*;

public class EasyDP_backjoon9465 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int testcase = 0; testcase < T; testcase++) {
			int N = sc.nextInt();
			int sticker[][] = new int[2][N];
			for (int i = 0; i < 2; i++)
				for (int k = 0; k < N; k++)
					sticker[i][k] = sc.nextInt();
			int dp[][] = new int[N][3]; // 0�� �ƹ��͵� �ȶ��� ����, 1�� ������, 2�� �Ʒ���

			dp[0][1] = sticker[0][0];
			dp[0][2] = sticker[1][0];
			for (int i = 1; i < N; i++) {
				dp[i][0] = dp[i][1] = dp[i][2] = dp[i - 1][0];
				for (int k = 1; k < 3; k++) {
					if (dp[i][0] < dp[i - 1][k])
						dp[i][0] = dp[i - 1][k];
				}

				// ������ ������ �� ���̺��� ���� 0�̰ų� 2������.
				if (dp[i - 1][2] > dp[i - 1][0]) {
					dp[i][1] = dp[i-1][2];
				}
				dp[i][1] += sticker[0][i];
				// �Ʒ� ���̺��� ������ �� ���̺��� ���� 0�̰ų� 1�̿�����
				if (dp[i - 1][1] > dp[i - 1][0])
					dp[i][2] =dp[i-1][1];
				dp[i][2] += sticker[1][i];
//				for (int k = 0; k < 3; k++)
//					System.out.print(dp[i][k] + " ");
//				System.out.println();

			}
			long result = 0;
			for (int i = 0; i < 3; i++) {
				if (dp[N - 1][i] > result)
					result = dp[N - 1][i];
			}
			System.out.println(result);
		}
	}
}
