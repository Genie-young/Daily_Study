import java.util.Scanner;

public class backjoon6588_Goldbach {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		boolean prime[] = new boolean[1000001];
		prime[0] = prime[1] = true;
		for (int i = 2; i <= 1000000; i++)
			prime[i] = false;
		for (int i = 2; i <= 1000; i++)
			if (!prime[i])
				for (int j = i*i; j <=1000000 ; j+=i)
					prime[j]=true;

		int M;
		while (true) {
			M = sc.nextInt();

			if (M == 0) // 입력이 0이면 종료.
				return;
			boolean flag = false;
			for(int i=2;i+i<=M;i++)
				if(!prime[i]) 
					if(!prime[M-i]){
						System.out.println(M+" = "+i+" + "+(M-i));
						flag = true;
						break;
					}
			
			if(!flag)
				System.out.println("\"Goldbach's conjecture is wrong.\"");

		}
	}
}
