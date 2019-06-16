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
		// 첫째 줄에 50보다 작거나 같은 자연수 R과 C가 주어진다.
		// 비어있는 곳은 '.'로 표시되어 있고, 물이 차있는 지역은 '*', 돌은 'X'로 표시되어 있다. 비버의 굴은 'D'로, 고슴도치의 위치는
		// 'S'로 나타내어져 있다.
		// 다음 R개 줄에는 티떱숲의 지도가 주어지며, 문제에서 설명한 문자만 주어진다. 'D'와 'S'는 하나씩만 주어진다.물과 고슴도치는 돌을
		// 통과할 수 없다.
		// 고슴도치가 안전하게 비버의 굴로 이동하기 위해 필요한 최소 시간을 구하는 프로그램을 작성하시오.
		// 고슴도치는 물이 찰 예정인 칸으로 이동할 수 없다. 즉, 다음 시간에 물이 찰 예정인 칸으로 고슴도치는 이동할 수 없다.
		// 이동할 수 있으면 고슴도치가 물에 빠지기 때문이다.
		// 매 분마다 고슴도치는 현재 있는 칸과 인접한 네 칸 중 하나로 이동할 수 있다. (위, 아래, 오른쪽, 왼쪽) 물도 매 분마다 비어있는
		// 칸으로 확장한다. 물이 있는 칸과 인접해있는 비어있는 칸(적어도 한 변을 공유)은 물이 차게 된다. 물과 고슴도치는 돌을 통과할 수 없다.
		// 또, 고슴도치는 물로 차있는 구역으로 이동할 수 없고, 물도 비버의 소굴로 이동할 수 없다.
		// 만약, 안전하게 비버의 굴로 이동할 수 없다면, "KAKTUS"를 출력한다.
		//첫째 줄에 50보다 작거나 같은 자연수 R과 C가 주어진다. 
		//==> 시간복잡도는 50*50을 한 번씩 탐색해야하니 2500번, 물이 차는 과정, 고슴도치 이동과정, 총2번을 해야하니 2500*2는 5000번. 1억번이 안되니 BFS사용가능
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
				if (tmStr[k].equals("D")) { // 비버 굴
					map[i][k] = -2;
					to = new Spot(i, k); // 목적지 저장
				} else if (tmStr[k].equals("S")) { // 고슴도치 위치 // 시작 위치 저장
					map[i][k] = -3;
					from = new Spot(i, k);
				} else if (tmStr[k].equals(".")) // 비어있는 곳
					map[i][k] = 0;
				else if (tmStr[k].equals("*")) { // 물이 있는 곳
					map[i][k] = 1;
					Q.add(new Spot(i, k));
					water[i][k] = 0;
				} else if (tmStr[k].equals("X")) // 돌이 있는 곳
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
