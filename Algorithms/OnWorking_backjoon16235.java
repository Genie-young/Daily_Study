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

public class OnWorking_backjoon16235 {
	static int N, M, K; // N은 땅의 크기, M개의 나무, K년 후의 나무 개수 양분은 모든 칸에 5만큼
	static ArrayList<Integer> map[][]; // 나무
	static boolean visited[][];
	static ArrayList<Node> ali = new ArrayList<Node>();
	static int direction[][] = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };
	static int sum = 0;
	static int ground[][];
	static int nut[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		map = new ArrayList[N][N];
		ground= new int[N][N];
		nut= new int[N][N];
		for(int i=0;i<N;i++) {
			for(int k=0;k<N;k++)
				nut[i][k] = sc.nextInt();
		}
		for(int i=0;i<M;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int age = sc.nextInt();
		}
			
		System.out.println();

	}
}
