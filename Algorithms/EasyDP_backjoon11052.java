import java.util.*;

public class EasyDP_backjoon11052 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int card[] = new int[N+1];
		for(int i=1;i<N+1;i++)
			card[i] = sc.nextInt();
		for(int i=2;i<=N;i++) {
			for(int j=1;j<i;j++) {
				if(card[i]<card[i-j]+card[j])
					card[i] =card[i-j]+card[j];
			}
		}
		System.out.println(card[N]);
	}
}
