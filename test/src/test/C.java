package test;

import java.util.Scanner;

public class C {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strArr = str.split(",");
        int a = Integer.parseInt(strArr[0]);
        int b = Integer.parseInt(strArr[1]);
        
        System.out.println(reverseAdd(a, b));
	}
    public static int reverseAdd(int a, int b){
        if(a > 70000 || a < 1 || b > 70000 || b < 1)
            return -1;
        String str1 = String.valueOf(a);
        String str2 = String.valueOf(b);
        
        StringBuffer sb1 = new StringBuffer(str1);
        StringBuffer sb2 = new StringBuffer(str2);
        sb1.reverse();
        sb2.reverse();
        a = Integer.parseInt(sb1.toString());
        b = Integer.parseInt(sb2.toString());
        return a + b;
    }
}
