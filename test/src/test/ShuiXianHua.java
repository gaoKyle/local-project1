package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShuiXianHua {
	public static List<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = 0;
		int n = 0;
		while (sc.hasNextLine()) {
			m = sc.nextInt();
			n = sc.nextInt();
			sc.nextLine();
			getFla(m, n);
			if (list.size() == 0)
				System.out.println("no");
			else {
				for (int i = 0; i < list.size() - 1; i++) {
					System.out.print(list.get(i) + " ");
				}
				System.out.print(list.get(list.size() - 1));
			}
			list.clear();
		}
	}

	public static void getFla(int m, int n) {
		String str = "";
		int temp = 0;
		for (int i = m; i <= n; i++) {
			temp = 0;
			str = String.valueOf(i);
			char[] ch = str.toCharArray();
			for(int j = 0; j < ch.length; j++){
				temp += Math.pow(Integer.parseInt(String.valueOf(ch[j])), 3);
			}
			if (i == temp) {
				list.add(temp);
			}
		}
	}
}
