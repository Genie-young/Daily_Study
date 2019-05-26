
import java.util.LinkedList;
import java.util.Scanner;

public class backjoon2178 {

	static void rBFS(int N, int M, int status[][], int miro[][], LinkedList<Integer>[] queue, int i, int j) {
		if (i == N - 1 && j == M - 1)
			return;
		int length = status[i][j];
		if (i + 1 < N)
			if (miro[i + 1][j] == 1)
				if (status[i + 1][j] == -1) {
					queue[0].add(i + 1);
					queue[1].add(j);
					status[i + 1][j] = length + 1;
				} else {
					if (status[i + 1][j] > length + 1)
						status[i + 1][j] = length + 1;
				}
		if (i - 1 >= 0)
			if (miro[i - 1][j] == 1)
				if (status[i - 1][j] == -1) {
					queue[0].add(i - 1);
					queue[1].add(j);
					status[i - 1][j] = length + 1;
				} else {
					if (status[i - 1][j] > length + 1)
						status[i - 1][j] = length + 1;
				}

		if (j + 1 < M)
			if (miro[i][j + 1] == 1)
				if (status[i][j + 1] == -1) {
					queue[0].add(i);
					queue[1].add(j + 1);
					status[i][j + 1] = length + 1;
				} else {
					if (status[i][j + 1] > length + 1)
						status[i][j + 1] = length + 1;
				}

		if (j - 1 >= 0)
			if (miro[i][j - 1] == 1)

				if (status[i][j - 1] == -1) {
					queue[0].add(i);
					queue[1].add(j - 1);
					status[i][j - 1] = length + 1;
				} else {
					if (status[i][j - 1] > length + 1)
						status[i][j - 1] = length + 1;
				}

		i = queue[0].pop();
		j = queue[1].pop();

		rBFS(N, M, status, miro, queue, i, j);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N, M;
		int status[][];
		int miro[][];

		LinkedList<Integer> queue[] = new LinkedList[2];
		queue[0] = new LinkedList<Integer>();
		queue[1] = new LinkedList<Integer>();
		N = sc.nextInt();
		M = sc.nextInt();
		miro = new int[N][M];
		status = new int[N][M];
		sc.nextLine();	

		for (int i = 0; i < N; i++) {
			String temp = sc.nextLine();
			String temp1[] = temp.split("");
			
			 for (int j = 0; j < M; j++) 
				 miro[i][j] = Integer.parseInt(temp1[j]);
			 
		}
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				status[i][j] = -1;

		status[0][0] = 1;
		rBFS(N, M, status, miro, queue, 0, 0);
		System.out.println(status[N - 1][M - 1]);
	}

}
