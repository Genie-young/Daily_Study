import java.util.LinkedList;
import java.util.Scanner;

public class backjoon1966 {

	static public int solution(int[] priorities, int location) {
		int answer = 0;
		int bigindex = 0;
		LinkedList<Integer>[] list = new LinkedList[2];
		
/*		if(location-1<0)
			location = 0;
		else location = location-1;*/
		list[0] = new LinkedList<Integer>();
		list[1] = new LinkedList<Integer>();

		for (int i = 0; i < priorities.length; i++) { // ÀÎµ¦½º
			list[0].offer(i+1);
			list[1].offer(priorities[i]);
			//System.out.println("0"+ list[0].get(i) + "1"+list[1].get(i));
		}
		

		while (true) {
			answer++;
			bigindex = 0;
			System.out.println("size = "+list[0].size());
			for (int i = 1; i < list[0].size(); i++) {
				if (list[1].get(i) > list[1].get(bigindex)) {
					bigindex = i;
					System.out.println("bigindex ="+bigindex);
					
				}
			}

			if (list[0].get(bigindex) == location)
				return answer;

			for (int j = 0; j <= bigindex; j++) {
				if (j == bigindex) {
					list[0].pop();
					list[1].pop();
					//System.out.println("out = 0"+ list[0].pop() + "1"+list[1].pop());
				} else {
					//int x = list[0].pop();
					//int y = list[1].pop();
					//list[0].offer(x);
					//list[1].offer(y);
					
					list[0].offer(list[0].pop());
					list[1].offer(list[1].pop());
					//System.out.println("0"+x  + "1"+y );
				}
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			int location = sc.nextInt();
			int[] priorities = new int[num];
			for (int j = 0; j < num; j++)
				priorities[j] = sc.nextInt();

			int answer = solution(priorities, location);
			System.out.println(answer);
		}

	}

}
