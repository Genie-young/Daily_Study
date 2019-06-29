import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Simulation_swea_1859 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int testcase=0;testcase<T;testcase++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			Queue<Integer> que = new PriorityQueue<Integer>(Collections.reverseOrder());
			Queue<Integer> que2 = new PriorityQueue<Integer>(Collections.reverseOrder());
			for(int i=0;i<N;i++) {
				arr[i] = sc.nextInt();
				que.offer(arr[i]);
			}
			int index = 0;
			int sum =0;
			
			//���� ���� 2�� ������ ��� �� �� �����غ���! 
			while(!que.isEmpty()) {
				int max = que.poll();
				if(que2.contains(max))
					continue;
				//System.out.println(max);0
				while(index <N && max != arr[index]) {
					que2.offer(arr[index]);
					sum+= max - arr[index];
					index++;
				}
				index++;
			}
			System.out.println("#"+(testcase+1)+" "+sum);
		}
	}
}
