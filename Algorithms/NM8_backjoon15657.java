import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class NM8_backjoon15657 {
	static int N;
	static int M;
	static int num[];
	static int ar[];
	static boolean visited[];
	
	static StringBuilder getArr(int order,int start) {
		
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
		for(int i=start;i<N;i++) {
			ar[order] =num[i];
			arn.append(getArr(order+1,i));
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
//		
//		int s = 0;
//		int e = N-1;
//		while(s < e){
//			int temp = num[s];
//			num[s] = num[e];
//			num[e] = temp;
//			s++;
//			e--;
//		}
		System.out.println(getArr(0,0));
	
		
	}
}
