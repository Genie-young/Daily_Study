import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFSFindSubinSister_backjoon1697 {

	static int visited[];
	static int subin;
	static int sister;

	static void BFS(int now, Queue<Integer> queue) {
		int next =0;
		for(int i=0;i<3;i++) {
			if(i==0)
				next =now-1;
			if(i==1)
				next =now+1;
			if(i==2)
				next =now*2;
			if (next == sister) {
				visited[next] = visited[now]+1;
				return;
			}
			if (next > -1 && next < 100001) {
				if(visited[next] == -1) {
					visited[next] = visited[now]+1;
					//System.out.println(next +" "+visited[next]);
					queue.offer(next);
				}
			}	
		}
		if(!queue.isEmpty())
			BFS(queue.poll(), queue);
		
	}

	public static void main(String[] args) {
		// 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)
		Scanner sc = new Scanner(System.in);
		subin = sc.nextInt();
		sister = sc.nextInt();
		if(sister <= subin){
			System.out.println(subin-sister);
			return;
		}
		visited = new int[100001];
		for (int i = 0; i < 100001; i++)
			visited[i] = -1;
		Queue<Integer> queue = new LinkedList<Integer>();
		visited[subin]=0;
		BFS(subin, queue);
		System.out.println(visited[sister]);

	}
}
