import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		String[] grade = new String[10];
		grade[0] = "A+";
		grade[1] = "A0";
		grade[2] = "A-";
		grade[3] = "B+";
		grade[4] = "B0";
		grade[5] = "B-";
		grade[6] = "C+";
		grade[7] = "C0";
		grade[8] = "C-";
		grade[9] = "D0";
		
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int k = sc.nextInt();
			double[] score = new double[N + 1];
			for (int j = 1; j < N + 1; j++) {
				int mid = sc.nextInt();
				int fin = sc.nextInt();
				int assi = sc.nextInt();
				score[j] = mid * 0.35 + fin * 0.45 + assi * 0.2;

			}
			double cnt = 0;
			double div = N/10;
			for (int j = 1; j < N + 1; j++) {
				if (score[j] >= score[k])
					cnt++;
			}
			System.out.println("#" + (i + 1) + " "+grade[ (int)Math.ceil(cnt/div)-1] );
		}
	}
}