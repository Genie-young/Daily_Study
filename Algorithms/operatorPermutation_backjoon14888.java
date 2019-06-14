import java.util.LinkedList;
import java.util.Scanner;

/*
 * 이제 오류만 잡으면 끝남 기본 구현은 다했고, 
 * next_permutation에서 인덱싱 처리가 미흡함.
 * 알고리즘 한 번 더 체크하기
 * */
public class operatorPermutation_backjoon14888 {
	static int op[];
	static int n;

	static boolean next_permutation() {
		int i = n - 1;
		while (i > 0 && op[i] <= op[i - 1])
			i--;
		
		if (i == 0)
			return false;
		int j = n - 1;
		while (j > 0 && op[i - 1] >= op[j])
			j--;
		int temp = op[i - 1];
		op[i - 1] = op[j];
		op[j] = temp;
		j = n - 1;
		while (i < j) {
			temp = op[i];
			op[i] = op[j];
			op[j] = temp;
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
//PermutationOperator_backjoon14888
//		첫째 줄에 수의 개수 N(2 ≤ N ≤ 11)가 주어진다. 
//		둘째 줄에는 A1, A2, ..., AN이 주어진다. (1 ≤ Ai ≤ 100) 
//		셋째 줄에는 합이 N-1인 4개의 정수가 주어지는데, 차례대로 덧셈(+)의 개수, 뺄셈(-)의 개수, 곱셈(×)의 개수, 나눗셈(÷)의 개수이다. 

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		n = N-1; //operator 배열 길이 
		int num[] = new int[N];
		op = new int[N - 1];
		for (int i = 0; i < N; i++)
			num[i] = sc.nextInt();

		int s = 0;
		for (int i = 0; i < 4; i++) {
			int tm = sc.nextInt(); // 연산자를 하나씩 받는데, 덧셈의 갯수는 0의 갯수와 같고, 뺄셈은 1, 곱셈은 2, 나눗셈은 3
			for (int j = 0; j < tm; j++) {
				op[s] = i;
				s++;
			}
		}
		boolean flag = true;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		while (flag) {
			// 계산
			int temp = num[0];
//			식의 계산은 연산자 우선 순위를 무시하고 앞에서부터 진행해야 한다. 
//			또, 나눗셈은 정수 나눗셈으로 몫만 취한다. 
//			음수를 양수로 나눌 때는 C++14의 기준을 따른다. 
//			즉, 양수로 바꾼 뒤 몫을 취하고, 그 몫을 음수로 바꾼 것과 같다. 
			for (int i = 1; i < N; i++) {
				int operator = op[i - 1]; // operator Order
				if (operator == 0) { // 덧셈
					temp += num[i];
				} else if (operator == 1) { // 뺄셈
					temp -= num[i];
				} else if (operator == 2) { // 곱셈
					temp *= num[i];
				} else if (operator == 3) { // 나눗셈
					boolean minus = false;
					if (temp < 0) {
						minus = true;
						temp = Math.abs(temp);
					}
					temp /= num[i];
					if (minus)
						temp = -temp;
				}
			}
			if(temp < min)
				 min= temp;
			if(temp> max)
				max = temp;
			
			flag = next_permutation();
			
		}

		System.out.println(max);
		System.out.println(min);
		
	}
}
