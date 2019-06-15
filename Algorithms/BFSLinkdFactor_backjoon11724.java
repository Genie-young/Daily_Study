import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//ù° �ٿ� ������ ���� N�� ������ ���� M�� �־�����. 
//(1 �� N �� 1,000, 0 �� M �� N��(N-1)/2) ��° �ٺ��� M���� �ٿ� ������ �� ���� u�� v�� �־�����.
//(1 �� u, v �� N, u �� v) ���� ������ �� ���� �־�����.
public class BFSLinkdFactor_backjoon11724 {

	static int N;
	static boolean visited[];
	static ArrayList<Integer> graph[];
	static Queue<Integer> bfsque = new LinkedList<Integer>();
	int groupnum=0;
	int result =0;

	static void BFS(int node) {
		//System.out.print((node + 1) + " ");// �Է¹��� �� 1�� ���� ����� �� 1�� ������.
		for (int i = 0; i < graph[node].size(); i++) {
			int temp = graph[node].get(i);
			if (!visited[temp]) {
				visited[temp] = true;
				bfsque.offer(temp);
			}
		}
		if (!bfsque.isEmpty())
			BFS(bfsque.poll());
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		visited = new boolean[N];
		graph = (ArrayList<Integer>[]) new ArrayList[N];
		for (int i = 0; i < N; i++)
			graph[i] = new ArrayList<Integer>();

		// ���� M���� �ٿ��� ������ �����ϴ� �� ������ ��ȣ�� �־�����. � �� ���� ���̿� ���� ���� ������ ���� �� �ִ�.
		for (int i = 0; i < M; i++) {
			int v1 = sc.nextInt() - 1;// ���� ��ȣ�� 1������ N�������̴�
			int v2 = sc.nextInt() - 1;
			graph[v1].add(v2); // �Է����� �־����� ������ ������̴�.
			graph[v2].add(v1);
		}

		int cnt =0;
		for(int i=0;i<N;i++)
			if(!visited[i]) {
				BFS(i);
				cnt++;
			}
		System.out.println(cnt);
	}
}
