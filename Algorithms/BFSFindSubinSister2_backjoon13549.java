import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFSFindSubinSister2_backjoon13549 {

	static int visited[];
	static int subin;
	static int sister;

	static void BFS(Queue<Integer> Q, Queue<Integer> nextQ) {
		int now = Q.poll();
		int next = now+now;
		if(next <=100000 &&visited[next] == -1) {
			visited[next] = visited[now];
			if(next == sister) return;
			Q.add(next);	
		}
		next = now+1;
		if(next <=100000 &&visited[next] == -1){
			visited[next] = visited[now]+1;
			if(next == sister) return;
			nextQ.add(next);
		}
		next = now-1;
		if(next >-1 &&visited[next] == -1){
			visited[next] = visited[now]+1;
			if(next == sister) return;
			nextQ.add(next);
		}
		if(Q.isEmpty()) {
			if(nextQ.isEmpty()) return;
			BFS(nextQ, Q);
		}
		else
			BFS(Q,nextQ);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		subin = sc.nextInt();
		sister = sc.nextInt();
		visited = new int[100001];
		if (subin >= sister) {
			System.out.println(subin-sister);
			return;
		}
		for (int i = 0; i <= 100000; i++)
				visited[i] = -1;
		visited[subin] = 0;
		Queue<Integer> Q = new LinkedList<Integer>();
		Queue<Integer> nextQ = new LinkedList<Integer>();
		Q.add(subin);
		BFS(Q,nextQ);
		System.out.println(visited[sister]);

	}
}
