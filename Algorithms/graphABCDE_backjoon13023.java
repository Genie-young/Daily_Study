import java.util.ArrayList;
import java.util.Scanner;

class Edge {
	int from;
	int to;

	Edge(int from, int to) {
		this.from = from;
		this.to = to;
	}
}

public class graphABCDE_backjoon13023 {
//첫째 줄에 사람의 수 N (5 ≤ N ≤ 2000)과 친구 관계의 수 M (1 ≤ M ≤ 2000)이 주어진다.
//둘째 줄부터 M개의 줄에는 정수 a와 b가 주어지며, a와 b가 친구라는 뜻이다. 
//(0 ≤ a, b ≤ N-1, a ≠ b) 같은 친구 관계가 두 번 이상 주어지는 경우는 없다.
	static int N;
	static boolean visited[];
	static boolean graph[][];
	static ArrayList<Integer> g[];
	static ArrayList<Edge> edges = new ArrayList<Edge>();
//
//	static boolean dfs(int node, int order) {
//		if (order == 4) {
//			int cnt = 0;
//			for (int i = 0; i < N; i++) {
//				if (visited[i])
//					cnt++;
//			}
//			if (cnt >= 5)
//				return true;
//			else
//				return false;
//		}
//		for (int i = 0; i < N; i++) {
//			if (graph[node][i] && !visited[i]) {
//				visited[i] = true;
//				boolean result = dfs(i, order + 1);
//				if (result)
//					return true;
//				visited[i] = false;
//			}
//		}
//		return false;
//	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		graph = new boolean[N][N];
		g = (ArrayList<Integer>[]) new ArrayList[N];
		for (int i = 0; i < N; i++)
			g[i] = new ArrayList<Integer>();
		for (int i = 0; i < M; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			// 인접행렬
			graph[v1][v2] = true;
			graph[v2][v1] = true;

			// 간선 리스트
			edges.add(new Edge(v1, v2));
			edges.add(new Edge(v2, v1));

			// 인접 리스트
			g[v1].add(v2);
			g[v2].add(v1);
		}
		int m = M * 2; // 총 M개의 간선 개수에서 양방향이니 각 경우를 쪼개 M*2개의 간선으로 표기가능
		for (int i = 0; i < m; i++) {
			for (int k = 0; k < m; k++) {
				if (k == i)
					continue;
				// 한개의 간선의 정점들을 넣어줌.
				int A = edges.get(i).to;
				int B = edges.get(i).from;
				int C = edges.get(k).to;
				int D = edges.get(k).from;
				// 각 정점은 같으면 안됨.
				if (A == B || A == C || A == D || B == C || B == D || C == D)
					continue;
				
				//B와 C가 연결되어 있지 않으면 다음 케이스로 넘어감.
				if(!graph[B][C]) 
					continue;
				
				//g와 인접해 있는 정점들을 골라서 E의 조건에 맞는 지 확인. 
				for(int E : g[D]) {
					if(E==A || E== B || E==C||E==D) //조건에 안맞으면 다음 케이스로 넘어감
						continue;
					System.out.println("1"); // 조건에 맞으면 1츨력하고 종료
					System.exit(0);
				}
			}
		}
		//for문이 다 돌아도 종료되지 않으면 그런 관계를 찾지 못한 것이니 0출력하고 종료
		System.out.println("0");
	}
}
