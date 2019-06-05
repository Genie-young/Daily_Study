import java.util.Scanner;

public class backjoon2609 {
	static int Gcd(int A,int B){
		if(A%B==0)
			return B;
		else 
			return Gcd(B, A%B);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B =sc.nextInt();
		if(B > A) {
			int temp =A;
			A =B;
			B= temp;
		}
		int gcd = Gcd(A,B);
		int lcm = A/gcd * B;
		System.out.println(gcd);
		System.out.println(lcm);
	}
}

//(A+B)%C, 둘째 줄에 (A%C + B%C)%C, 셋째 줄에 (A×B)%C, 넷째 줄에 (A%C × B%C)%C를 출력