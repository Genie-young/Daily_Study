import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Position {
	int x, y, time;

	Position(int x, int y, int time) {
		this.x = x;
		this.y = y;
		this.time = time;
	}
}

class Shark {
	int x, y, size;

	Shark(int x, int y, int size) {
		this.x = x;
		this.y = y;
		this.size = size;
	}
}

public class Onworking_backjoon16236 {
	static int map[][];
	static Shark shark = null;
	static int N;
	static int direction[][] = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
	static boolean visited[][];
	static Queue<Position> queue = new LinkedList<Position>();
	static int cnt = 0;

	static int BFS() {
		Position now = queue.poll();
		//System.out.println(now.x + " " + now.y + " "+now.time);
		for (int i = 0; i < 4; i++) {
			int x = now.x + direction[i][0];
			int y = now.y + direction[i][1];
			if (x < 0 || y < 0 || x > N - 1 || y > N - 1)
				continue;
			if (visited[x][y] == true || map[x][y] > shark.size)
				continue;
			visited[x][y] = true;
			if (map[x][y] == 0 || map[x][y] == shark.size)
				queue.offer(new Position(x, y, now.time + 1));
			else {
				map[x][y] = 0;
				shark.x = x;
				shark.y = y;
				cnt++;
				if (cnt == shark.size) {
					shark.size++;
					cnt = 0;
				}
				return now.time + 1;
			}
		}
		if (!queue.isEmpty())
			return BFS();
		else
			return 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];

		visited = new boolean[N][N];
		for (int i = 0; i < N; i++)
			for (int k = 0; k < N; k++) {
				map[i][k] = sc.nextInt();
				if (map[i][k] == 9) {
					shark = new Shark(i, k, 2);
					map[i][k] =0;
				}
			}
		int flag = 1;
		int result = 0;
		
		while (flag != 0) {
			queue.clear();
			for (int i = 0; i < N; i++) {
				for (int k = 0; k < N; k++) //{
					//System.out.print(map[i][k]+" ");
					visited[i][k] = false;
//				}
//				System.out.println();
			}
			
			visited[shark.x][shark.y] = true;
			System.out.println("shark ==> "+shark.x+" "+ shark.y+" "+shark.size);
			queue.offer(new Position(shark.x, shark.y, 0));
			flag = BFS();
			//System.out.println(flag);
			result += flag;
		}
		System.out.println(result);
	}
}
