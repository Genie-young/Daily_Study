import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. 
//(1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2) 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다.
//(1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.
public class BFSLinkdFactor_backjoon11724 {

	static int N;
	static boolean visited[];
	static ArrayList<Integer> graph[];
	static Queue<Integer> bfsque = new LinkedList<Integer>();
	int groupnum=0;
	int result =0;

	static void BFS(int node) {
		//System.out.print((node + 1) + " ");// 입력받을 때 1씩 빼서 출력할 때 1씩 더해줌.
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

		// 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다.
		for (int i = 0; i < M; i++) {
			int v1 = sc.nextInt() - 1;// 정점 번호는 1번부터 N번까지이다
			int v2 = sc.nextInt() - 1;
			graph[v1].add(v2); // 입력으로 주어지는 간선은 양방향이다.
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
