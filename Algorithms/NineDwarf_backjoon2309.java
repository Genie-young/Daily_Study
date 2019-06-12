import java.util.Arrays;
import java.util.Scanner;

public class NineDwarf_backjoon2309 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int dwarf[] = new int[9];
		int total = 0;

		for (int i = 0; i < 9; i++) {
			dwarf[i] = sc.nextInt();
			total += dwarf[i];
		}
		Arrays.sort(dwarf);
		for (int i = 0; i < 8; i++)
			for (int j = i + 1; j < 9; j++)
				if ((total - dwarf[i] - dwarf[j]) == 100) {
					for (int k = 0; k < 9; k++) {
						if (k == i || k == j)
							continue;
						System.out.println(dwarf[k]);
					}
					break;
				}

	}
}
