import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFSEmoticon_backjoon14226 {

	static int visited[][];
	static int S;
	static int result;

	static void BFS(Queue<Integer> sque, Queue<Integer> cque) {
		int s = sque.poll();
		int c = cque.poll();

		// 화면의 이모티콘 복사 && 클립보드 저장
		int ctemp, stemp;

		stemp = s;
		ctemp = s;
		if (visited[stemp][ctemp] == -1) {
			if(stemp == S) {
				result = visited[s][c]+1;
				return;
			}
			visited[stemp][ctemp] = visited[s][c] + 1;
			sque.add(stemp);
			cque.add(ctemp);
		}
		if (c != 0 && s + c <= 1000) {
			stemp = s + c;
			ctemp = c;
			if(stemp == S) {
				result = visited[s][c]+1;
				return;
			}
			if (visited[stemp][ctemp] == -1) {
				visited[stemp][ctemp] = visited[s][c] + 1;
				sque.add(stemp);
				cque.add(ctemp);
			}
		}
		if (s > 0) {
			stemp = s - 1;
			ctemp = c;
			if(stemp == S) {
				result = visited[s][c]+1;
				return;
			}
			if (visited[stemp][ctemp] == -1) {
				visited[stemp][ctemp] = visited[s][c] + 1;
				sque.add(stemp);
				cque.add(ctemp);
			}
		}
		if(!sque.isEmpty())
			BFS(sque, cque);

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		S = sc.nextInt();
		visited = new int[1001][1001];
		Queue<Integer> sque = new LinkedList<Integer>();
		Queue<Integer> cque = new LinkedList<Integer>();
		if (S == 1) {
			System.out.println("0");
			return;
		}
		for (int i = 0; i <= 1000; i++)
			for (int k = 0; k <= 1000; k++)
				visited[i][k] = -1;
		sque.add(1);
		cque.add(0);
		visited[1][0] = 0;
		BFS(sque, cque);
		System.out.println(result);

	}
}
