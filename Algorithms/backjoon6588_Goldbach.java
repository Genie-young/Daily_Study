import java.util.Scanner;

public class backjoon6588_Goldbach {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		boolean prime[] = new boolean[10001];
		prime[0] = prime[1] = true;
		for (int i = 2; i <= 10000; i++)
			prime[i] = false;
		for (int i = 2; i <= 100; i += 2) {
			if (!prime[i])
				for (int j = i * i; j <= 10000; j += i)
					prime[j] = true;
			if (i == 2)
				i--;
		}
		int T = sc.nextInt();
		// ���� ������ n�� ������ ��Ƽ���� ���� ������ ��쿡�� �� �Ҽ��� ���̰� ���� ���� ���� ����Ѵ�.
		for (int round = 0; round < T; round++) {
			int min = Integer.MAX_VALUE;
			int M = sc.nextInt();
			boolean flag = false;
			for (int i = 2; i + i <= M; i++)
				if (!prime[i] && !prime[M - i]) {
					if ((M - 2 * i) < (M - 2 * min))
						min = i;
					flag = true;
				}

			if (!flag)
				System.out.println("\"Goldbach's conjecture is wrong.\"");
			else
				System.out.println(min + " " + (M - min));

		}

	}
}
