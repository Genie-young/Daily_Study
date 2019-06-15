import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 

public class DFSandBFS_badkjoon1260 {

	static int N;
	static boolean visited[];
	static ArrayList<Integer> graph[];
	static Queue<Integer> bfsque = new LinkedList<Integer>();

	static void DFS(int node) {
		System.out.print((node + 1) + " ");// 입력받을 때 1씩 빼서 출력할 때 1씩 더해줌.
		for (int i = 0; i < graph[node].size(); i++) {
			int temp = graph[node].get(i);
			if (!visited[temp]) {
				visited[temp] = true;
				DFS(temp);
			}
		}
	}

	static void BFS(int node) {
		System.out.print((node + 1) + " ");// 입력받을 때 1씩 빼서 출력할 때 1씩 더해줌.
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
		// 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가
		// 주어진다.
		N = sc.nextInt();
		int M = sc.nextInt();
		int s = sc.nextInt() - 1; // 탐색을 시작할 점점 번호 //정점 번호는 1번부터 N번까지이다
		visited = new boolean[N];
		graph = (ArrayList<Integer>[]) new ArrayList[N];
		for (int i = 0; i < N; i++)
			graph[i] = new ArrayList<Integer>();

		// 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다.
		for (int i = 0; i < M; i++) {
			int v1 = sc.nextInt() - 1;// 정점 번호는 1번부터 N번까지이다
			int v2 = sc.nextInt() - 1;
			graph[v1].add(v2); // 입력으로 주어지는 간선은 양방향이다.
			graph[v2].add(v1);
		}

		// 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문
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
