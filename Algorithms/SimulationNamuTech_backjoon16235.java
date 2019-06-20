import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class Node implements Comparable<Node> {
	int x, y, age;

	Node(int x, int y, int age) {
		this.x = x;
		this.y = y;
		this.age = age;
	}

	@Override
	public int compareTo(Node target) {
		return this.age > target.age ? 1 : -1;
	}

}

public class SimulationNamuTech_backjoon16235 {
	static int N, M, K;
	static Queue<Node> tree = new PriorityQueue<Node>(); // 나무
	static int direction[][] = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };
	static int ground[][];
	static int nut[][];
	static Queue<Node> dead = new LinkedList<Node>();
	static Queue<Node> treeAdd = new LinkedList<Node>();

	static void spring() {
		Queue<Node> temp = new PriorityQueue<Node>();
		while (!tree.isEmpty()) {
			Node node = tree.poll();
			int x = node.x;
			int y = node.y;
			int age = node.age;
			if (ground[x][y] >= age) {
				ground[x][y] -= age;
				temp.offer(new Node(x, y, age + 1));
				if ((age + 1) % 5 == 0)
					treeAdd.offer(new Node(x, y, 0));
			} else {
				dead.offer(new Node(x, y, age / 2));
			}
		}
		tree = temp;
	}

	static void summer() {
		while (!dead.isEmpty()) {
			Node node = dead.poll();
			ground[node.x][node.y] += node.age;
		}
	}

	static void autumn() {
		while (!treeAdd.isEmpty()) {
			Node node = treeAdd.poll();
			for (int i = 0; i < 8; i++) {
				int x = node.x + direction[i][0];
				int y = node.y + direction[i][1];
				if (x < 0 | y < 0 | x > N - 1 | y > N - 1)
					continue;
				tree.offer(new Node(x, y, 1));
			}
		}
	}

	static void winter() {
		for (int i = 0; i < N; i++)
			for (int k = 0; k < N; k++) {
				ground[i][k] += nut[i][k];
			}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // N은 땅의 크기
		M = sc.nextInt(); // M개의 나무
		K = sc.nextInt(); // K년 후의 나무 개수

		ground = new int[N][N];
		nut = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int k = 0; k < N; k++) {
				nut[i][k] = sc.nextInt();
				ground[i][k] = 5; // 처음 양분은 모든 칸에 5만큼
			}
		}
		for (int i = 0; i < M; i++) {
			int x = sc.nextInt()-1;
			int y = sc.nextInt()-1;
			int age = sc.nextInt();
			tree.offer( new Node(x, y, age));
		}
		for (int i = 0; i < K; i++) { // i=k일때도 확인해보기
			if (tree.isEmpty())
				break;
			spring();
			summer();
			autumn();
			winter();
		}
		System.out.println(tree.size());

	}
}
