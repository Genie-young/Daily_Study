import java.util.Arrays;
import java.util.Scanner;

public class AdvancedPermutation_baekjoon10819 {
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
		int arr[] = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		boolean flag = true;
		int big = 0;
		while (flag) {
			int temp = 0;
			for (int i = 0; i < N - 1; i++)
				temp += Math.abs(arr[result[i]] - arr[result[i + 1]]);
			if (temp > big)
				big = temp;
			// ÃÖ´ñ°ª È®ÀÎ
			flag = permutation();
		}
		System.out.println(big);
	}
}