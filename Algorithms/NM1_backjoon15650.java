import java.util.LinkedList;
import java.util.Scanner;

/*
 * ���� ������ ������ ���� �⺻ ������ ���߰�, 
 * next_permutation���� �ε��� ó���� ������.
 * �˰��� �� �� �� üũ�ϱ�
 * */
public class NM_backjoon15650 {
	static int arr[];
	static int N;

	static boolean prev_permutation() {
		int i = N - 1;
		while (i > 0 && arr[i] >= arr[i - 1])
			i--;

		if (i == 0)
			return false;
		int j = N - 1;
		while (j > 0 && arr[i - 1] <= arr[j])
			j--;
		int temp = arr[i - 1];
		arr[i - 1] = arr[j];
		arr[j] = temp;
		j = N - 1;
		while (i < j) {
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 3 1
		N = sc.nextInt();
		int n = sc.nextInt();
		int num[] = new int[N];
		arr = new int[N];
		for (int i = 0; i < N; i++)
			num[i] = i + 1;
		for (int i = 0; i < n; i++)
			arr[i] = 1;
		for (int i = n; i < N; i++)
			arr[i] = 0;
		boolean flag = true;
		while (flag) {
			int tm = 0;
			for (int i = 0; i < N; i++) {
				if (arr[i] == 1) {
					tm++;
					if (tm == n) {
						System.out.println(num[i]);
						break;
					}
					System.out.print(num[i] + " ");

				}
			}
			flag = prev_permutation();

		}
	}
}
