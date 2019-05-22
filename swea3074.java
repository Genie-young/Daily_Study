import java.util.Scanner;

public class Solution {
	static long min =1;
	static long max = Long.MAX_VALUE;
	static long M;
	static int N;
	static long arr[];
	static long BinarySearch(long lower,long upper) {
		long mid = (lower+upper)/2;
		long sum = 0;
		for(int i=0;i<N;i++){
			sum+= mid/arr[i];
		}
		if(lower == upper)
			return lower;
		if(sum >= M)
			return BinarySearch(lower,mid);
		else 
			return BinarySearch(mid+1, upper);
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			N =sc.nextInt();
			M =sc.nextLong();
			arr = new long[N];
			long minvalue = Long.MAX_VALUE;
			for(int j=0;j<N;j++){
				arr[j]=sc.nextLong();
				if(minvalue > arr[j])
					minvalue = arr[j];
			}
			
			long result = BinarySearch(min,minvalue*M);
			System.out.println("#"+(i+1)+" "+result);
		
		}
	}
}