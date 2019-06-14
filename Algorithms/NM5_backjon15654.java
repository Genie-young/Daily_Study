import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class NM5_backjon15654 {
	static int result;
	static int N;
	static int M;
	static int num[];
	static int ar[];
	static boolean visited[];
	
	static StringBuilder getArr(int order) {
		if(order == M) {
			StringBuilder midStr = new StringBuilder();
			for(int i=0;i<M;i++)
			{
				midStr.append(ar[i]);
				if(i!=M-1) midStr.append(" ");
			}
			midStr.append("\n");
			return midStr;
		}
		StringBuilder arn = new StringBuilder();
		for(int i=0;i<N;i++) {
			if(visited[i]) continue;
			visited[i] = true;
			ar[order] =num[i];
			arn.append(getArr(order+1));
			visited[i] = false;
		}
		return arn;
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		num = new int [N];
		ar = new int[M];
		visited = new boolean[N];
		for(int i=0;i<N;i++) {
			num[i] = sc.nextInt();
			visited[i] = false;
		}
		Arrays.sort(num);
		System.out.println(getArr(0));
	
		
	}
}
