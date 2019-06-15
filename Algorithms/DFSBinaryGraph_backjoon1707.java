import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. 
//(1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2) 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다.
//(1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.
public class DFSBinaryGraph_backjoon1707 {

	static int N;
	static int group[];
	static ArrayList<Integer> graph[];

	static void DFS(int node, int gnum) {
		group[node] = gnum;
		for (int y : graph[node])
			if (group[y] == 0)
				DFS(y, 3 - gnum);

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int roop = 0; roop < T; roop++) {
			N = sc.nextInt();
			int M = sc.nextInt();
			graph = (ArrayList<Integer>[]) new ArrayList[N];
			group = new int[N];
			for (int j = 0; j < N; j++)
				graph[j] = new ArrayList<Integer>();

			for (int k = 0; k < M; k++) {
				int v1 = sc.nextInt() - 1;// 정점 번호는 1번부터 N번까지이다
				int v2 = sc.nextInt() - 1;
				graph[v1].add(v2); // 입력으로 주어지는 간선은 양방향이다.
				graph[v2].add(v1);
			}
			// 1. 이분 판단하기
			for (int i = 0; i < N; i++) {
				if (group[i] == 0)
					DFS(i, 1);
			}
			// 2. 다른 것과 비교해 2분이 적용되는 지 확인하기
			boolean flag = true;
			for (int i = 0; i < N; i++) {
				for (int k : graph[i]) {
					if (group[i] == group[k]) {
						flag = false;
						break;
					}
				}
			}
			if(flag)
				System.out.println("YES");
			else 
				System.out.println("NO");

		}
	}
}
