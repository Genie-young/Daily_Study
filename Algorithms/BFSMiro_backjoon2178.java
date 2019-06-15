import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. 
//(1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2) 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다.
//(1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.
class Nodes {
	int x, y;
	int level;

	Nodes(int x, int y, int level) {
		this.x = x;
		this.y = y;
		this.level = level;
	}
}

public class BFSMiro_backjoon2178 {
	static int location[][] = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
	static int w, h;
	static int map[][];
	static boolean visited[][];
	static int result;

	static void BFS(Nodes node, Queue<Nodes> queue) {

		int level = node.level + 1;
		for (int i = 0; i < 4; i++) {
			int x = node.x + location[i][0];
			int y = node.y + location[i][1];
			if (x == w - 1 && y == h - 1) {
				// System.out.println(level +" "+ level);
				result = level;
				return;
			}
			if (x < 0 || y < 0 || x > w - 1 || y > h - 1)
				continue;

			if (map[x][y] == 1 && !visited[x][y]) {
				visited[x][y] = true;
				// System.out.println(x+" "+y+" " +level);
				queue.offer(new Nodes(x, y, level));
			}
		}

		if (!queue.isEmpty()) {
			BFS(queue.poll(), queue);
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		w = sc.nextInt();
		h = sc.nextInt();
		map = new int[w][h];
		visited = new boolean[w][h];
		for (int i = 0; i < w; i++) {
			String tm = sc.next();
			String[] tmStr = tm.split("");
			for (int k = 0; k < h; k++)
				map[i][k] = Integer.parseInt(tmStr[k]);
		}
		Queue<Nodes> queue = new LinkedList<Nodes>();
		BFS(new Nodes(0, 0, 1), queue);

		System.out.println(result);

	}
}
