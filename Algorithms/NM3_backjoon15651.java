import java.util.*;

public class NM3_backjoon15651 {
	static int result;
	static int N;
	static int M;
	static int arr[];
	
	static StringBuilder permutation(int order) {
		if(order == M)
		{
			StringBuilder midstring = new StringBuilder();
			for(int i =0;i<M;i++)
			{
				midstring.append(arr[i]);
				if(i!= M-1) midstring.append(" ");
			}
			midstring.append("\n");
			return midstring;
		}
		StringBuilder arn = new StringBuilder();
		for(int i=1;i<=N;i++) {
			arr[order] = i;
			arn.append(permutation(order+1));
		}
		return arn;
	}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int [M];
		System.out.println(permutation(0));
	}
}
