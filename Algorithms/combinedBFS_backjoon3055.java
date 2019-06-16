import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Spot {
	int x, y, breakwall;

	Spot(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class combinedBFS_backjoon3055 {
	static int map[][];
	static int water[][];
	static int w;
	static int h;
	static int direction[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static Spot to;
	static int visited[][];

	static void waterBFS(Queue<Spot> Q) {
		Spot spot = Q.poll();
		int px = spot.x;
		int py = spot.y;
		for (int i = 0; i < 4; i++) {
			int x = px + direction[i][0];
			int y = py + direction[i][1];
			if (x < 0 || y < 0 || x > h - 1 || y > w - 1)
				continue;
			if (water[x][y] != Integer.MAX_VALUE || map[x][y] == -1 || map[x][y] == -2)
				continue;

			water[x][y] = water[px][py] + 1;
			Q.offer(new Spot(x, y));
		}
		if (!Q.isEmpty())
			waterBFS(Q);
	}

	static void gosumBFS(Queue<Spot> Q) {
		Spot spot = Q.poll();
		int px = spot.x;
		int py = spot.y;
		//System.out.println(px+" " +py);
		for (int i = 0; i < 4; i++) {
			int x = px + direction[i][0];
			int y = py + direction[i][1];

			if (x < 0 || y < 0 || x > h - 1 || y > w - 1)
				continue;
			if (visited[x][y] != -1 || map[x][y] == -1 || visited[spot.x][spot.y]+1 >= water[x][y])
				continue;
			visited[x][y] = visited[spot.x][spot.y] + 1;
			Q.offer(new Spot(x, y));
		}
		if (!Q.isEmpty())
			gosumBFS(Q);
	}

	public static void main(String[] args) {
		// ù° �ٿ� 50���� �۰ų� ���� �ڿ��� R�� C�� �־�����.
		// ����ִ� ���� '.'�� ǥ�õǾ� �ְ�, ���� ���ִ� ������ '*', ���� 'X'�� ǥ�õǾ� �ִ�. ����� ���� 'D'��, ����ġ�� ��ġ��
		// 'S'�� ��Ÿ������ �ִ�.
		// ���� R�� �ٿ��� Ƽ������ ������ �־�����, �������� ������ ���ڸ� �־�����. 'D'�� 'S'�� �ϳ����� �־�����.���� ����ġ�� ����
		// ����� �� ����.
		// ����ġ�� �����ϰ� ����� ���� �̵��ϱ� ���� �ʿ��� �ּ� �ð��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
		// ����ġ�� ���� �� ������ ĭ���� �̵��� �� ����. ��, ���� �ð��� ���� �� ������ ĭ���� ����ġ�� �̵��� �� ����.
		// �̵��� �� ������ ����ġ�� ���� ������ �����̴�.
		// �� �и��� ����ġ�� ���� �ִ� ĭ�� ������ �� ĭ �� �ϳ��� �̵��� �� �ִ�. (��, �Ʒ�, ������, ����) ���� �� �и��� ����ִ�
		// ĭ���� Ȯ���Ѵ�. ���� �ִ� ĭ�� �������ִ� ����ִ� ĭ(��� �� ���� ����)�� ���� ���� �ȴ�. ���� ����ġ�� ���� ����� �� ����.
		// ��, ����ġ�� ���� ���ִ� �������� �̵��� �� ����, ���� ����� �ұ��� �̵��� �� ����.
		// ����, �����ϰ� ����� ���� �̵��� �� ���ٸ�, "KAKTUS"�� ����Ѵ�.
		//ù° �ٿ� 50���� �۰ų� ���� �ڿ��� R�� C�� �־�����. 
		//==> �ð����⵵�� 50*50�� �� ���� Ž���ؾ��ϴ� 2500��, ���� ���� ����, ����ġ �̵�����, ��2���� �ؾ��ϴ� 2500*2�� 5000��. 1����� �ȵǴ� BFS��밡��
		Scanner sc = new Scanner(System.in);
		h = sc.nextInt();
		w = sc.nextInt();
		map = new int[h][w];
		water = new int[h][w];
		visited = new int[h][w];
		for (int i = 0; i < h; i++)
			for (int k = 0; k < w; k++) {
				water[i][k] = Integer.MAX_VALUE;
				visited[i][k] = -1;
			}
		Spot from = null;

		Queue<Spot> Q = new LinkedList<Spot>();
		for (int i = 0; i < h; i++) {
			String tm = sc.next();
			String tmStr[] = tm.split("");
			for (int k = 0; k < w; k++) {
				if (tmStr[k].equals("D")) { // ��� ��
					map[i][k] = -2;
					to = new Spot(i, k); // ������ ����
				} else if (tmStr[k].equals("S")) { // ����ġ ��ġ // ���� ��ġ ����
					map[i][k] = -3;
					from = new Spot(i, k);
				} else if (tmStr[k].equals(".")) // ����ִ� ��
					map[i][k] = 0;
				else if (tmStr[k].equals("*")) { // ���� �ִ� ��
					map[i][k] = 1;
					Q.add(new Spot(i, k));
					water[i][k] = 0;
				} else if (tmStr[k].equals("X")) // ���� �ִ� ��
					map[i][k] = -1;
			}
		}
		if (!Q.isEmpty())
			waterBFS(Q);
//		for (int i = 0; i < h; i++) {
//			for (int k = 0; k < w; k++)
//				System.out.print(water[i][k] + " ");
//			System.out.println();
//		}
		Q.clear();
		Q.add(from);
		visited[from.x][from.y] = 0;
		//System.out.println(from.x + " "+ from.y);
		gosumBFS(Q);
		if (visited[to.x][to.y] == -1)
			System.out.println("KAKTUS");
		else
			System.out.println(visited[to.x][to.y]);
	}
}
