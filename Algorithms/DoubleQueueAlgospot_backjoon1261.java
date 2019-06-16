import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Spot {
	int x, y;

	Spot(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class DoubleQueueAlgospot_backjoon1261 {
	static int map[][];
	static int visited[][];
	static int w;
	static int h;
	static int direction[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	static void BFS(Queue<Spot> Q, Queue<Spot> nextQ) {
		Spot spot = Q.poll();
		//System.out.println(spot.x + " " + spot.y);
		for (int i = 0; i < 4; i++) {
			int x = spot.x + direction[i][0];
			int y = spot.y + direction[i][1];
			if (x == h - 1 && y == w - 1) {
				if (map[x][y] == 1)
					visited[x][y] = visited[spot.x][spot.y] + 1;
				else
					visited[x][y] = visited[spot.x][spot.y];
				return;
			}
			if (x < 0 || y < 0 || x > h - 1 || y > w - 1)
				continue;
			if (visited[x][y] != -1)
				continue;
			
			if (map[x][y] == 0) {
				visited[x][y] = visited[spot.x][spot.y];
				Q.offer(new Spot(x, y));
			} else {
				visited[x][y] = visited[spot.x][spot.y] + 1;
				nextQ.offer(new Spot(x, y));
			}
		}
		if (Q.isEmpty()) {
			if (nextQ.isEmpty())
				return;
			BFS(nextQ, Q);
		} else
			BFS(Q, nextQ);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		w = sc.nextInt();
		h = sc.nextInt();
		map = new int[h][w];
		for (int i = 0; i < h; i++) {
			String tm = sc.next();
			String tmStr[] = tm.split("");
			for (int k = 0; k < w; k++)
				map[i][k] = Integer.parseInt(tmStr[k]);
		}
//		for (int i = 0; i < h; i++) {
//			for (int k = 0; k < w; k++)
//				System.out.print(map[i][k] + " ");
//			System.out.println();
//		}
		visited = new int[h][w];
		for (int i = 0; i < h; i++)
			for (int k = 0; k < w; k++)
				visited[i][k] = -1;
		Queue<Spot> Q = new LinkedList<Spot>();
		Queue<Spot> nextQ = new LinkedList<Spot>();
		Q.offer(new Spot(0, 0));
		visited[0][0] = map[0][0];
		BFS(Q, nextQ);
		System.out.println(visited[h - 1][w - 1]);

	}
}
