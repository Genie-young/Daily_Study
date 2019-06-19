import java.util.*;

public class EasyDP_backjoon2156 {
	static int ThreeMax(int a, int b, int c) {
		int tem = Math.max(a,b);
		return Math.max(tem, c);
	}	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int p[] = new int[N];
		for (int i = 0; i < N; i++) {
			//p[i] = i;
			p[i] = sc.nextInt();
		}
		if(N==1){
			System.out.println(p[0]);
			return;
		}
		int dp[][] = new int[N][3];
		dp[0][1] = dp[0][1] = p[0];
		for(int i = 1;i<N;i++) {
			dp[i][0] = ThreeMax(dp[i-1][0],dp[i-1][1],dp[i-1][2]);
			dp[i][1] = dp[i-1][0]+p[i];
			dp[i][2] = dp[i-1][1]+p[i];
		}
	
		System.out.println(ThreeMax(dp[N-1][0],dp[N-1][1],dp[N-1][2]));

	}
}
