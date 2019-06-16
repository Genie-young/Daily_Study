import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Spot {
	int x, y, breakwall;

	Spot(int x, int y, int breakwall) {
		this.x = x;
		this.y = y;
		this.breakwall = breakwall;
	}
}

public class splitNodeBFSBreakWall_backjoon2206 {
	static int map[][];
	static int visited[][][];
	static int w;
	static int h;
	static int direction[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	static void BFS(Queue<Spot> Q) {
		Spot spot = Q.poll();
		int prevx = spot.x;
		int prevy = spot.y;
		int prevwall = spot.breakwall;
		for (int i = 0; i < 4; i++) {
			int x = prevx + direction[i][0];
			int y = prevy + direction[i][1];

			if (x < 0 || y < 0 || x > h - 1 || y > w - 1)
				continue;
			if (prevwall == 1) { // 깬적이 있을 때 ==> 벽 있는 곳은 못감
				// 벽이 있다면 깨는 옵션 추가 가능
				if (map[x][y] == 1)
					continue; // 벽이 있으면 못감
				if (visited[x][y][1] == -1) {// 벽이 없는 곳중에서 이미 전에 한 번 깼고, 방문한 곳을 넣어줌.
					visited[x][y][1] = visited[prevx][prevy][prevwall] + 1;
					Q.offer(new Spot(x,y,1));
				}

			} else { // 깬적이 없을 때
				if (map[x][y] == 1) { // 벽이 있는 곳이면 깨고 가는 옵션 추가
					if (visited[x][y][1] == -1) {
						visited[x][y][1] = visited[prevx][prevy][prevwall] + 1;
						Q.offer(new Spot(x, y, 1));
					}
				}
				else if (visited[x][y][0] == -1) {//벽이 없으면 그냥 가기
					visited[x][y][0] = visited[prevx][prevy][prevwall] + 1;
					Q.offer(new Spot(x, y, 0));
				}

			}
			if (x == h - 1 && y == w - 1)
				return;
		}
		if (!Q.isEmpty())
			BFS(Q);

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		h = sc.nextInt();
		w = sc.nextInt();
		map = new int[h][w];

		for (int i = 0; i < h; i++) {
			String tm = sc.next();
			String tmStr[] = tm.split("");

			for (int k = 0; k < w; k++)
				map[i][k] = Integer.parseInt(tmStr[k]);
		}

		visited = new int[h][w][2];
		for (int i = 0; i < h; i++)
			for (int k = 0; k < w; k++)
				for (int j = 0; j < 2; j++)
					visited[i][k][j] = -1;

		Queue<Spot> Q = new LinkedList<Spot>();
		Q.offer(new Spot(0, 0, 0));
		visited[0][0][0] = 1;
		BFS(Q);
		if (visited[h - 1][w - 1][0] != -1)
			System.out.println(visited[h - 1][w - 1][0]);
		else {
			System.out.println(visited[h - 1][w - 1][1]);	
		}
	}
}
