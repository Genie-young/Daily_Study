import java.util.Scanner;

public class swea1249_OnWorking {
	static int result;
	static int N;
	static int map[][];

	static void BFS(int sum, int x, int y) {
		sum += map[x][y];
		
		if (result < sum)
			return;
		if (x == N - 1 && y == N - 1) {
			result = sum;
			return;
		}
		if (y + 1 < N)
			BFS(sum, x, y + 1);
		if (x + 1 < N)
			BFS(sum, x + 1, y);
		if (x - 1 >= 0)
			BFS(sum, x - 1, y);
		if (y - 1 >= 0)
			BFS(sum, x, y - 1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			N = sc.nextInt();
			result = Integer.MAX_VALUE;
			map = new int[N][N];
			//sc.next();
			for (int j = 0; j < N; j++) {
				String temp = sc.next();
				String temp1[] = temp.split("");
				for (int k = 0; k < N; k++)
					map[j][k] = Integer.parseInt(temp1[k]);
				
			}
			BFS(0, 0, 0);
			System.out.println(result);
		}

	}
}
