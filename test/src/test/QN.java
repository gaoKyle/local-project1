package test;

import java.text.DecimalFormat;
import java.util.Scanner;

public class QN {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextLine()) {
			String str = in.nextLine().toLowerCase();
			char[] ch = str.toCharArray();
			DecimalFormat df = new DecimalFormat("0");
			double sum = 0;
			for (int j = 0; j < ch.length; j++) {
				if (ch[j] >= 'a' && ch[j] <= 'z') {
					sum += (double) Math.pow(26, ch.length - j - 1)
							* (ch[j] - 97);
				}
			}
			System.out.println(df.format(sum));
		}
	}
}
