import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//�׷����� DFS�� Ž���� ����� BFS�� Ž���� ����� ����ϴ� ���α׷��� �ۼ��Ͻÿ�. 

public class DFSandBFS_badkjoon1260 {

	static int N;
	static boolean visited[];
	static ArrayList<Integer> graph[];
	static Queue<Integer> bfsque = new LinkedList<Integer>();

	static void DFS(int node) {
		System.out.print((node + 1) + " ");// �Է¹��� �� 1�� ���� ����� �� 1�� ������.
		for (int i = 0; i < graph[node].size(); i++) {
			int temp = graph[node].get(i);
			if (!visited[temp]) {
				visited[temp] = true;
				DFS(temp);
			}
		}
	}

	static void BFS(int node) {
		System.out.print((node + 1) + " ");// �Է¹��� �� 1�� ���� ����� �� 1�� ������.
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
		// ù° �ٿ� ������ ���� N(1 �� N �� 1,000), ������ ���� M(1 �� M �� 10,000), Ž���� ������ ������ ��ȣ V��
		// �־�����.
		N = sc.nextInt();
		int M = sc.nextInt();
		int s = sc.nextInt() - 1; // Ž���� ������ ���� ��ȣ //���� ��ȣ�� 1������ N�������̴�
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

		// �湮�� �� �ִ� ������ ���� ���� ��쿡�� ���� ��ȣ�� ���� ���� ���� �湮
		for (int i = 0; i < N; i++)
			Collections.sort(graph[i]);
		
		visited[s] = true;
		DFS(s);
		System.out.println();
		for (int i = 0; i < N; i++)
			visited[i]=false;
		visited[s] = true;
		BFS(s);
	}
}
