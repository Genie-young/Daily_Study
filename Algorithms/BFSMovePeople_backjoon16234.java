import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
	int x, y;

	Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BFSMovePeople_backjoon16234 {
	static int L, R, N;
	static int map[][];
	static boolean visited[][];
	static ArrayList<Node> ali = new ArrayList<Node>();
	static Queue<Node> que = new LinkedList<Node>();
	static int direction[][] = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };
	static int sum = 0;

	static void BFS() {
		Node node = que.poll();

		for (int i = 0; i < 4; i++) {
			int x = node.x + direction[i][0];
			int y = node.y + direction[i][1];
			if (x < 0 || y < 0 || x > N - 1 || y > N - 1)
				continue;
			int dis = Math.abs(map[x][y] - map[node.x][node.y]);
			if (visited[x][y] == true || dis < L || dis > R)
				continue;
			visited[x][y] = true;
			ali.add(new Node(x, y));
			que.offer(new Node(x, y));
		}
		if (!que.isEmpty())
			BFS();

	}

	static void movepeople() {
		int sum = 0;
		Node node;
		for (int i = 0; i < ali.size(); i++) {
			node = ali.get(i);
			sum += map[node.x][node.y];
			// System.out.println(sum);
			//System.out.println("node.x , node.y ==> "+node.x +" " + node.y);
		}
		int avg = sum / ali.size();
		//System.out.println("avg ==> " + avg);
		for (int i = 0; i < ali.size(); i++) {
			node = ali.get(i);
			map[node.x][node.y] = avg;
		}
//		for (int i = 0; i < N; i++) {
//			for (int k = 0; k < N; k++)
//				System.out.print(map[i][k] + " ");
//			System.out.println();
//		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		map = new int[N][N];

		for (int i = 0; i < N; i++)
			for (int k = 0; k < N; k++)
				map[i][k] = sc.nextInt();

		visited = new boolean[N][N];
		boolean flag = true;
		int result = 0;
		while (flag) {
			flag = false;
			for (int i = 0; i < N; i++)
				for (int k = 0; k < N; k++)
					visited[i][k] = false;

			for (int i = 0; i < N; i++)
				for (int k = 0; k < N; k++)
					if (visited[i][k] == false) {
						ali.clear();
						que.offer(new Node(i, k));
						ali.add(new Node(i, k));
						visited[i][k] = true;
						BFS();
						if (ali.size() != 1) {
							flag = true;
							movepeople();
						}

					}
			if (flag)
				result++;
		}
		System.out.println(result);

	}
}
