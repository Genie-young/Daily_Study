import java.util.*;

public class EasyDP_backjoon1149 {
	static int ThreeMin(int a, int b, int c) {
		int tem = Math.min(a,b);
		return Math.min(tem, c);
	}
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int map[][] = new int[N][3];
		for(int i=0;i<N;i++) 
			for(int k=0;k<3;k++)
				//map[i][k] = 1000;
				map[i][k] = sc.nextInt();
		
		int dp[][] = new int[N][3];
		dp[0][0] = map[0][0];
		dp[0][1] = map[0][1];
		dp[0][2] = map[0][2];
		for(int i=1;i<N;i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + map[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + map[i][1];
			dp[i][2] = Math.min(dp[i-1][1], dp[i-1][0]) + map[i][2];
		}
		System.out.println(ThreeMin(dp[N-1][0],dp[N-1][1],dp[N-1][2]));
	}
}
