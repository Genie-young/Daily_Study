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
	static int N, M, K; // N�� ���� ũ��, M���� ����, K�� ���� ���� ���� ����� ��� ĭ�� 5��ŭ
	static ArrayList<Integer> map[][]; // ����
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
