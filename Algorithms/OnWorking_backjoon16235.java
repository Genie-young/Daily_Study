import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class Node {
	int x, y, age;

	Node(int x, int y, int age) {
		this.x = x;
		this.y = y;
		this.age = age;
	}
}

public class OnWorking_backjoon16235 {
	static int N, M, K;
	static Queue<Integer> map[][]; // ����
	// static boolean visited[][];
	static int direction[][] = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };
	static int sum = 0;
	static int ground[][];
	static int nut[][];

	static void springSummer() { //
		for (int i = 0; i < N; i++)
			for (int k = 0; k < N; k++) {

				if (!map[i][k].isEmpty()) {
					Queue<Integer> temp = new PriorityQueue<Integer>();

					while (!map[i][k].isEmpty()) {
						int age = map[i][k].poll();
						if (ground[i][k] > age) {
							ground[i][k] -= age;
							temp.offer(age + 1);
						} else {
							while (!map[i][k].isEmpty()) {
								ground[i][k] += age / 2;
								age = map[i][k].poll();
							}
							ground[i][k] += age / 2;
						}
					}
					map[i][k] = temp;
				}

			}
	}

	static void autumn() {
		for(int i=0;i<N;i++)
			for(int k=0;k<N;k++) {
				while(!map[i][k].isEmpty()) {
					int[] temp = map[i][k].toArrayInt();
				}
			}
	}

	static void winter() {

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // N�� ���� ũ��
		M = sc.nextInt(); // M���� ����
		K = sc.nextInt(); // K�� ���� ���� ����

		map = (Queue<Integer>[][])new PriorityQueue[N][N];
		ground = new int[N][N];
		nut = new int[N][N];
		dead = new int[N][N];
		for (int i = 0; i < N; i++)
			for (int k = 0; k < N; k++) {
				nut[i][k] = sc.nextInt();
				map[i][k] = new PriorityQueue<Integer>();
				ground[i][k] = 5; // ó�� ����� ��� ĭ�� 5��ŭ
			}

		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int age = sc.nextInt();
			map[x][y].offer(age);
		}
		for (int i = 0; i < K; i++) { // i=k�϶��� Ȯ���غ���
			springSummer();
			autumn();
			winter();
		}

		System.out.println();

	}
}
