import java.util.Scanner;

public class RR1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(getMaxNum(arr));
	}

	public static int getMaxNum(int[] arr) {
		int max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < max) {
				max = arr[i];
			}
		}

		while (max >= 1) {
			boolean flag = true;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] % max != 0) {
					flag = false;
					break;
				}
			}

			if (flag) {
				break;
			}
			max--;
		}
		return max;
	}
}
