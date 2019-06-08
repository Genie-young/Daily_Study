import java.util.Arrays;
import java.util.Scanner;

public class Permutation_backjoon10974 {
	static int N;
	static int[] result;

	static boolean permutation() {

		int start=N-1;
		while (start > 0 && result[start - 1] >= result[start])
			start--;
		if (start == 0)
			return false;
		int i= N-1;
		while(result[i]<result[start-1])i--;
		
		int temp = result[i];
		result[i] = result[start-1];
		result[start-1]= temp;
		Arrays.sort(result,start,N);
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		boolean mid = true;
		result = new int[N];
		for (int i = 1; i < N + 1; i++)
			result[i - 1] = i;

		while (mid) {
			for (int i = 0; i < N; i++) {
				if (i == N - 1)
					System.out.println(result[i]);
				else
					System.out.print(result[i] + " ");
			}
			mid = permutation();
		}
	}
}