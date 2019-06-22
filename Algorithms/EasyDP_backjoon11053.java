import java.util.Scanner;

public class EasyDP_backjoon11053 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Anum = sc.nextInt();
		int A[] = new int[Anum];
		int dp[] = new int[Anum];
		for(int i=0;i<Anum;i++)
			A[i] = sc.nextInt();
		dp[0] = 1;
		for (int i = 1; i < Anum; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++)
				if (A[i] > A[j] && dp[j]+1 > dp[i] )
					dp[i] = dp[j] + 1;

		}
		int max = dp[0];
		for(int i=0;i<Anum;i++)
			if(max < dp[i]) max = dp[i];
		System.out.println(max);
	}
}
