import java.util.Arrays;
import java.util.Scanner;

public class TSP_UsingPermutation_backjoon10971 {
	static int[] result;
	static int N;

	static boolean permutation() {
		int start = N - 1;
		while (start > 0 && result[start - 1] > result[start])
			start--;
		if (start == 0)
			return false;
		int i = N - 1;
		while (result[i] < result[start - 1])
			i--;
		int temp = result[i];
		result[i] = result[start - 1];
		result[start - 1] = temp;
		Arrays.sort(result, start, N);
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		result = new int[N];
		for (int i = 0; i < N; i++)
			result[i] = i;
		int arr[][] = new int[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				arr[i][j] = sc.nextInt();
		boolean flag = true;
		int small = Integer.MAX_VALUE;
		while (flag) {
			boolean flag2 = false;
			int temp = 0;
			for (int i = 0; i < N ; i++) {
				int j;
				if(i==N-1)
					j=0;
				else
					j= i+1;
				if (arr[result[i]][result[j]] == 0) {
					flag2 = true;
					break;
				}
				temp += (arr[result[i]][result[j]]);
			}
			if (!flag2 && temp < small)
				small = temp;
			flag = permutation();
		}
		System.out.println(small);
	}
}