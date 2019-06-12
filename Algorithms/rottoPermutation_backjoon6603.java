import java.util.Scanner;

public class rottoPermutation_backjoon6603 {
	static int flag[];
	static int K;

	static boolean nextPermutation() {
		int i = K - 1;
		while (i > 0 && flag[i] <= flag[i - 1])
			i--;
		if (i == 0)
			return false;
		int j = K - 1;
		while (flag[i - 1] >= flag[j])
			j--;
		int temp = flag[i - 1];
		flag[i - 1] = flag[j];
		flag[j] = temp;
		j = K - 1;
		while (i < j) {
			temp = flag[i];
			flag[i] = flag[j];
			flag[j] = temp;
			i++;
			j--;
		}
		return true;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		K = sc.nextInt();
		while (K != 0) {
			int num[] = new int[K];
			for(int i=0;i<K;i++)
				num[i]=sc.nextInt();
			flag = new int[K];
			for (int i = 0; i < 6; i++)
				flag[i] = 0;
			for (int i = 6; i < K; i++)
				flag[i] = 1;

			boolean ch = true;
			while (ch) {
				for(int i = 0; i < K; i++) {
					if(flag[i]==0)
						System.out.print(num[i]+" ");
				}
				System.out.println();
				ch = nextPermutation();
			}
			System.out.println();
			K = sc.nextInt();
		}
	}

}
