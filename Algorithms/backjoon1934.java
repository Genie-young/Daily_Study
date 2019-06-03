import java.util.Scanner;

public class backjoon1934 {
	static int Gcd(int A, int B) {
		if (A % B == 0)
			return B;
		else
			return Gcd(B, A % B);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {

			int A = sc.nextInt();
			int B = sc.nextInt();
			if (B > A) {
				int temp = A;
				A = B;
				B = temp;
			}
			int gcd = Gcd(A, B);
			int lcm = A / gcd * B;
			System.out.println(lcm);
		}
	}
}

//(A+B)%C, ��° �ٿ� (A%C + B%C)%C, ��° �ٿ� (A��B)%C, ��° �ٿ� (A%C �� B%C)%C�� ���