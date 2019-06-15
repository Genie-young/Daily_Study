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
//ù° �ٿ� ����� �� N (5 �� N �� 2000)�� ģ�� ������ �� M (1 �� M �� 2000)�� �־�����.
//��° �ٺ��� M���� �ٿ��� ���� a�� b�� �־�����, a�� b�� ģ����� ���̴�. 
//(0 �� a, b �� N-1, a �� b) ���� ģ�� ���谡 �� �� �̻� �־����� ���� ����.
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
			// �������
			graph[v1][v2] = true;
			graph[v2][v1] = true;

			// ���� ����Ʈ
			edges.add(new Edge(v1, v2));
			edges.add(new Edge(v2, v1));

			// ���� ����Ʈ
			g[v1].add(v2);
			g[v2].add(v1);
		}
		int m = M * 2; // �� M���� ���� �������� ������̴� �� ��츦 �ɰ� M*2���� �������� ǥ�Ⱑ��
		for (int i = 0; i < m; i++) {
			for (int k = 0; k < m; k++) {
				if (k == i)
					continue;
				// �Ѱ��� ������ �������� �־���.
				int A = edges.get(i).to;
				int B = edges.get(i).from;
				int C = edges.get(k).to;
				int D = edges.get(k).from;
				// �� ������ ������ �ȵ�.
				if (A == B || A == C || A == D || B == C || B == D || C == D)
					continue;
				
				//B�� C�� ����Ǿ� ���� ������ ���� ���̽��� �Ѿ.
				if(!graph[B][C]) 
					continue;
				
				//g�� ������ �ִ� �������� ��� E�� ���ǿ� �´� �� Ȯ��. 
				for(int E : g[D]) {
					if(E==A || E== B || E==C||E==D) //���ǿ� �ȸ����� ���� ���̽��� �Ѿ
						continue;
					System.out.println("1"); // ���ǿ� ������ 1�����ϰ� ����
					System.exit(0);
				}
			}
		}
		//for���� �� ���Ƶ� ������� ������ �׷� ���踦 ã�� ���� ���̴� 0����ϰ� ����
		System.out.println("0");
	}
}
