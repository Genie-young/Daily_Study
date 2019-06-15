import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//ù° �ٿ� ������ ���� N�� ������ ���� M�� �־�����. 
//(1 �� N �� 1,000, 0 �� M �� N��(N-1)/2) ��° �ٺ��� M���� �ٿ� ������ �� ���� u�� v�� �־�����.
//(1 �� u, v �� N, u �� v) ���� ������ �� ���� �־�����.
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
				int v1 = sc.nextInt() - 1;// ���� ��ȣ�� 1������ N�������̴�
				int v2 = sc.nextInt() - 1;
				graph[v1].add(v2); // �Է����� �־����� ������ ������̴�.
				graph[v2].add(v1);
			}
			// 1. �̺� �Ǵ��ϱ�
			for (int i = 0; i < N; i++) {
				if (group[i] == 0)
					DFS(i, 1);
			}
			// 2. �ٸ� �Ͱ� ���� 2���� ����Ǵ� �� Ȯ���ϱ�
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
