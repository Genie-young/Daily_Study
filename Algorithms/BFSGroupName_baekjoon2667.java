import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

//첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. 
//(1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2) 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다.
//(1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.
class Nodes {
	int x, y;

	Nodes(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BFSGroupName_baekjoon2667 {

	static int N;
	static int map[][];
	static boolean visited[][];

	static int cnt = 0;

	static void BFS(Nodes node, Queue<Nodes> queue) {
		int x = node.x;
		int y = node.y;
		boolean flag = true;
		if (x + 1 < N && map[x + 1][y] == 1 && !visited[x + 1][y]) {
			cnt++;
			visited[x + 1][y] = true;
			// System.out.println((x+1)+" "+y );
			queue.offer(new Nodes(x + 1, y));
		}
		if (x - 1 >= 0 && map[x - 1][y] == 1 && !visited[x - 1][y]) {
			cnt++;
			visited[x - 1][y] = true;
			queue.offer(new Nodes(x - 1, y));
		}
		if (y + 1 < N && map[x][y + 1] == 1 && !visited[x][y + 1]) {
			cnt++;
			visited[x][y + 1] = true;
			queue.offer(new Nodes(x, y + 1));
		}
		if (y - 1 >= 0 && map[x][y - 1] == 1 && !visited[x][y - 1]) {
			cnt++;
			visited[x][y - 1] = true;
			queue.offer(new Nodes(x, y - 1));
		}
		while (!queue.isEmpty()) {
			BFS(queue.poll(), queue);
		}
		if (flag)
			return;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고, 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가
		// 입력된다.
		N = sc.nextInt();
		map = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String tmStr = sc.next();
			String str[] = tmStr.split("");
			for (int k = 0; k < N; k++)
				map[i][k] = Integer.parseInt(str[k]);
		}
		Queue<Integer> result = new PriorityQueue<Integer>();
		for (int i = 0; i < N; i++)
			for (int k = 0; k < N; k++)
				if (map[i][k] == 1 && !visited[i][k]) {
					// System.out.println(i+" "+k+" ");
					cnt = 1;
					visited[i][k] = true;
					Queue<Nodes> queue = new LinkedList<Nodes>();
					BFS(new Nodes(i, k), queue);
					result.add(cnt);
				}
		System.out.println(result.size());
		while (!result.isEmpty()) {
			System.out.println(result.poll());
		}
	}
}
