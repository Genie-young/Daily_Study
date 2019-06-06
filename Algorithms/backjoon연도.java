import java.util.LinkedList;
import java.util.Scanner;

public class backjoon¿¬µµ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int E = sc.nextInt()-1; //<=15
		int S = sc.nextInt()-1; //<=28
		int M = sc.nextInt()-1; //<=19
		//System.out.println(E+" "+ S +" " +M);
		int e = 0;
		int m =0;
		int year =1; 
		
		e=(e+S) %15;
		m=(m+S)%19;
		year += S;
		while(!(e==E && m == M)){
			e=(e+28) %15;
			m=(m+28)%19;
			year += 28;
		}
		System.out.println(year);
		
	}
}
