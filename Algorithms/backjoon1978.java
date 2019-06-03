import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static boolean isPrime(int a) {
		for (int i = 2; i * i <= a; i++) {
			if (a % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int arr[] = new int[T];
		for (int i = 0; i < T; i++)
			arr[i] = sc.nextInt();
		int result = 0;
		for (int i = 0; i < T; i++) {
			if (arr[i] != 1 && isPrime(arr[i]))
				result++;
			
		}
		System.out.println(result);

	}
}

//(A+B)%C, ��° �ٿ� (A%C + B%C)%C, ��° �ٿ� (A��B)%C, ��° �ٿ� (A%C �� B%C)%C�� ���