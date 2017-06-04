import java.util.ArrayList;
import java.util.Scanner;

public class TT {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int q = in.nextInt();

		int[] a = new int[n];
		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		for (int i = 0; i < n; i++) {
			b[i] = in.nextInt();
		}
        ArrayList<Integer> list = new ArrayList<Integer>();
        int x = 0;
        int y = 0;
        int count = 0;
		for (int i = 0; i < q; i++) {
			x = in.nextInt();
			y = in.nextInt();
			count = 0;
			for (int j = 0; j < n; j++) {
				if ((a[j] >= x) && (b[j] >= y)) {
					count++;
				}
			}
			list.add(count);
		}
		for(int i : list){
			System.out.println(i);
		}
	}
}
