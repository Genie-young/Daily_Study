import java.util.Scanner;

public class swea5601 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int N=sc.nextInt();
			System.out.print("#"+(i+1));
			for(int j=0;j<N;j++)
				System.out.print(" 1/"+N);
			System.out.println();

		}
	}
}