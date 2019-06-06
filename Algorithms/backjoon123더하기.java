import java.util.LinkedList;
import java.util.Scanner;

public class backjoon123¥ı«œ±‚ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int result = 0;
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			result =0;
			for (int one = 1; one < 4; one++) {
				if (one == N) {
					result++;
					break;
				}
				for (int two = 1; two < 4; two++) {
					if (one + two == N) {
						result++;
						break;
					}
					for (int three = 1; three < 4; three++) {
						if (one + two + three == N) {
							result++;
							break;
						}
						for (int four = 1; four < 4; four++) {
							if (one + two + three + four == N) {
								result++;
								break;
							}
							for (int five = 1; five < 4; five++) {
								if (one + two + three + four + five == N) {
									result++;
									break;
								}
								for (int six = 1; six < 4; six++) {
									if (one + two + three + four + five + six == N) {
										result++;
										break;
									}
									for (int seven = 1; seven < 4; seven++) {
										if (one + two + three + four + five + six + seven == N) {
											result++;
											break;
										}
										for (int eight = 1; eight < 4; eight++) {
											if (one + two + three + four + five + six + seven + eight == N) {
												result++;
												break;
											}
											for (int nine = 1; nine < 4; nine++) {
												if (one + two + three + four + five + six + seven + eight + nine == N) {
													result++;
													break;
												}
												for (int ten = 1; ten < 4; ten++) {
													if (one + two + three + four + five + six + seven + eight + nine+ ten == N) {
														result++;
														break;
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}

			}
			System.out.println(result);

		}
	}
}
