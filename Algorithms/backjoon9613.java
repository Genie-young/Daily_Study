import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int gcd(int a,int b)
	{
		if(b%a==0)
			return a;
		else 
			return gcd(b%a,a);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			long result = 0;
			for(int j=0;j<N;j++) 
				arr[j] = sc.nextInt();
			
			Arrays.sort(arr);

			for(int j=0;j<N-1;j++) {
				for(int k=j+1;k<N;k++) {
					result+=gcd(arr[j],arr[k]);
				}
			}
			System.out.println(result);
		}
	}
}