import java.util.*;

public class EasyDP_backjoon2579 {
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
		int stairs[] = new int[N];
		for(int i=0;i<N;i++)
			//stairs[i] =10000;
			stairs[i] = sc.nextInt();
		
		int dp[][] = new int[N][3];
		dp[0][1] =dp[0][2] = stairs[0];
		for(int i=1;i<N;i++) {
			//������ ���� ����� �ݵ�� ��ƾ� �Ѵ�.
			//���ӵ� �� ���� ����� ��� ��Ƽ��� �� �ȴ�. ��, �������� ��ܿ� ���Ե��� �ʴ´�.
			//��, �� ����� �����鼭 �̾ ���� ����̳�, ���� ���� ������� ���� �� �ִ�.
			if(i==N-1) {
				dp[i][1] = dp[i-1][0]+stairs[i];
				dp[i][2] = dp[i-1][1]+stairs[i];
				continue;
			}
			dp[i][0] = Math.max(dp[i-1][1], dp[i-1][2]);
			dp[i][1] = dp[i-1][0]+stairs[i];
			dp[i][2] = dp[i-1][1]+stairs[i];
		}

		System.out.println(ArrayMax(dp[N-1]));
	}
}
