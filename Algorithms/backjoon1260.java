import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
class Node{
	int ver;
	int N; 
	Queue<Integer>[] graph; 
	int[] status;
	
	public Node(int ver, int n, Queue<Integer>[] graph, int[] status) {
		super();
		this.ver = ver;
		N = n;
		this.graph = graph;
		this.status = status;
	}
	
	
	
	
}
public class backjoon1260 {
	static void DFS(int start, int N, Queue<Integer>[] graph) {
		int[] status = new int[N + 1]; //방문 정보 표시하는 배열 ,boolean 으로도 사용 가능
			//간선 상태 => 간선이 다녀왔으면 Default, Visited, Back 
		for (int i = 0; i < N; i++)
			status[i] = 0; // 0 으로 초기화 -> 방문하지 않았다(empty), 방문했다(visited) 
		
		status[start] = 1; //시작점을 방문하고
		System.out.print(start+" "); // 출력
		Node node = new Node(start, N, graph, status);
		rDFS(node); // 재귀함수 호출
		System.out.println();
	}

	static void rDFS(Node node) {
		int ver = node.ver;
		int N = node.N; 
		Queue<Integer>[] graph  = node.graph;
		int []status = node.status
		while (!node.graph[ver].isEmpty()) {
			int vertex = node.graph[ver].poll();
			if (node.status[vertex] == 0) {
				node.status[vertex] = 1;
				System.out.print(vertex + " ");
				rDFS(node);
			}
		}
	}

	static void BFS(int start, int N, Queue<Integer> []graph ) {
	
		int[] status = new int[N+1]; // 정점의 방문 상태를 저장하는 배열
		LinkedList<Integer> queue = new LinkedList<Integer>();
		for(int i=0;i<N+1;i++) 
			status[i] = 0; //방문안함. 
		
		status[start] = 1;  // 시작점을 방문하고
		System.out.print(start+" "); // 방문한 거 출력
		rBFS(start, N, graph, status, queue); // rBFS호출 , 재귀함수 
		System.out.println(); 
	}

	static void rBFS(int ver, int N, Queue<Integer>[] graph, int[] status, Queue<Integer> queue) {

		while(!graph[ver].isEmpty()) {
			// rBFS(N, graph, status);
			int vertex = graph[ver].poll();
			if(status[vertex] == 0) {
				status[vertex] = 1;
				queue.add(vertex);
				System.out.print(vertex+ " ");
			}
		}
		if(!queue.isEmpty())
			rBFS(queue.poll(), N, graph, status, queue);
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 초기화
		int M = sc.nextInt();
		int S = sc.nextInt(); // 시작 정점.
		Queue<Integer>graph[]  = new PriorityQueue[N + 1];
		//Qeuue 배열만 생성 
		Queue<Integer>[] graph1 = new PriorityQueue[N + 1];
		for (int i = 0; i <= N; i++) {
			graph[i] = new PriorityQueue<Integer>();
			graph1[i] = new PriorityQueue<Integer>();
		}
		for (int i = 0; i < M; i++) {
			int ver1 = sc.nextInt();
			int ver2 = sc.nextInt();

			graph[ver1].add(ver2);
			graph[ver2].add(ver1);
			graph1[ver1].add(ver2);
			graph1[ver2].add(ver1);
		}

		DFS(S,N, graph); 
		BFS(S,N, graph1);
	}
}
 