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

//(A+B)%C, 둘째 줄에 (A%C + B%C)%C, 셋째 줄에 (A×B)%C, 넷째 줄에 (A%C × B%C)%C를 출력