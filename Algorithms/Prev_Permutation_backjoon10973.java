import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Prev_Permutation_backjoon10973 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int num[] = new int[N];
		for(int i=0;i<N;i++)
			num[i] = sc.nextInt();
		
		int start;
		for(start=N-1;start>=1;start--)
			if(num[start] <num[start-1])
				break;
		if(start==0) {
			System.out.println("-1");
			return;
		}
		for(int i=N-1;i>=start;i--)
			if(num[start-1]>num[i]){
				int temp = num[start-1];
				num[start-1] = num[i];
				num[i] = temp;
				break;
			}
		int j = N-1;
		while(start < j) {
			int temp = num[start];
			num[start] = num[j];
			num[j] = temp;
			start ++; j --;
		}
		
		for(int i=0;i<N;i++) {
			if(i==N-1)
				System.out.println(num[i]);
			else
			System.out.print(num[i]+" ");
			
		}
		
	}

}
