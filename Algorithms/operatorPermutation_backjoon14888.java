import java.util.LinkedList;
import java.util.Scanner;

/*
 * ���� ������ ������ ���� �⺻ ������ ���߰�, 
 * next_permutation���� �ε��� ó���� ������.
 * �˰��� �� �� �� üũ�ϱ�
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
//		ù° �ٿ� ���� ���� N(2 �� N �� 11)�� �־�����. 
//		��° �ٿ��� A1, A2, ..., AN�� �־�����. (1 �� Ai �� 100) 
//		��° �ٿ��� ���� N-1�� 4���� ������ �־����µ�, ���ʴ�� ����(+)�� ����, ����(-)�� ����, ����(��)�� ����, ������(��)�� �����̴�. 

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		n = N-1; //operator �迭 ���� 
		int num[] = new int[N];
		op = new int[N - 1];
		for (int i = 0; i < N; i++)
			num[i] = sc.nextInt();

		int s = 0;
		for (int i = 0; i < 4; i++) {
			int tm = sc.nextInt(); // �����ڸ� �ϳ��� �޴µ�, ������ ������ 0�� ������ ����, ������ 1, ������ 2, �������� 3
			for (int j = 0; j < tm; j++) {
				op[s] = i;
				s++;
			}
		}
		boolean flag = true;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		while (flag) {
			// ���
			int temp = num[0];
//			���� ����� ������ �켱 ������ �����ϰ� �տ������� �����ؾ� �Ѵ�. 
//			��, �������� ���� ���������� �� ���Ѵ�. 
//			������ ����� ���� ���� C++14�� ������ ������. 
//			��, ����� �ٲ� �� ���� ���ϰ�, �� ���� ������ �ٲ� �Ͱ� ����. 
			for (int i = 1; i < N; i++) {
				int operator = op[i - 1]; // operator Order
				if (operator == 0) { // ����
					temp += num[i];
				} else if (operator == 1) { // ����
					temp -= num[i];
				} else if (operator == 2) { // ����
					temp *= num[i];
				} else if (operator == 3) { // ������
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
