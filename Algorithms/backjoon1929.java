import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		int result=0;
		boolean map[] = new boolean[N+1];
		for(int i=2;i<=N;i++) 
			map[i]=false;
		
		map[0] = map[1]=true;
		
		for(int i=2;i*i<=N;i++) 
			if(!map[i]){
				int temp = i*i;
				while(temp <= N){
					int tem = temp;
					map[temp]=true;
					temp+=i;
				}
			}
		
		for (int i = M; i <= N; i++)
			if (!map[i])
				System.out.println(i);
	}
}
