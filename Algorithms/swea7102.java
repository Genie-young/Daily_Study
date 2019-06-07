import java.util.Scanner;

class swea7102
{
	public static void main(String args[]) throws Exception
	{
        Scanner sc= new Scanner(System.in);
        int T =sc.nextInt();
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			int biggest = 0; 
			int N = sc.nextInt();
            int M = sc.nextInt();
            int map[] = new int[N+M+1];
            System.out.print("#"+(test_case));
            for(int i=0;i<N+M+1;i++)
            	map[i] =0;
            for(int i=1;i<=N;i++) {
            	for (int j=1;j<=M;j++) {
            		map[i+j] ++;
            		if(map[i+j]>biggest)
            			biggest = map[i+j];
            	}
            }
            for(int i=0;i<N+M+1;i++) {
            	if(map[i]==biggest)
            		System.out.print(" "+i);
            }
            System.out.println();
		}
	}
}