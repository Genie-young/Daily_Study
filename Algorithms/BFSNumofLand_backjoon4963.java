import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

//ù° �ٿ� ������ ���� N�� ������ ���� M�� �־�����. 
//(1 �� N �� 1,000, 0 �� M �� N��(N-1)/2) ��° �ٺ��� M���� �ٿ� ������ �� ���� u�� v�� �־�����.
//(1 �� u, v �� N, u �� v) ���� ������ �� ���� �־�����.
class Nodes {
	int x, y;

	Nodes(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BFSNumofLand_backjoon4963 {
	static int location[][] = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 0 }, { 0, 1 }, { 1, -1 }, { 1, 0 },{ 1, 1 } };
	static int w, h;
	static int map[][];
	static boolean visited[][];

	static void BFS(Nodes node, Queue<Nodes> queue) {

		for (int i = 0; i < 9; i++) {
			int x = node.x + location[i][0];
			int y = node.y + location[i][1];
			if (x < 0 || y < 0 || x > w - 1 || y > h - 1)
				continue;
			if (map[x][y] == 1 && !visited[x][y]) {
				visited[x][y] = true;
				queue.offer(new Nodes(x, y));
			}
		}

		while(!queue.isEmpty()) {
			BFS(queue.poll(), queue);
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			h = sc.nextInt();
			w = sc.nextInt();
			if (w == 0 && h == 0)
				break;
			map = new int[w][h];
			visited = new boolean[w][h];
			for (int i = 0; i < w; i++) {
				for (int k = 0; k < h; k++)
					map[i][k] = sc.nextInt();
			}
			int result = 0;
			for (int i = 0; i < w; i++)
				for (int k = 0; k < h; k++)
					if (map[i][k] == 1 && !visited[i][k]) {
						visited[i][k] = true;
						Queue<Nodes> queue = new LinkedList<Nodes>();
						result++;
						BFS(new Nodes(i, k), queue);
					}
			System.out.println(result);

		}
	}
}
