package test;

import java.util.Scanner;

public class AA {
	public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        String str  = sc.nextInt() + "";
	        char[] ch = str.toCharArray();
	        test(ch);

	}
    public static void test(char[] ch){
        int left = 1;
        int right = 1;
        for(int i = 0; i < ch.length - 1; i++){
            left *= Integer.parseInt(String.valueOf(ch[i]));
            for(int j = i + 1; j < ch.length; j++){
                right *= Integer.parseInt(String.valueOf(ch[j])); 
            }
            if(left == right){
                System.out.println(true);
                return;
            }else
            	right = 1;
        }
        System.out.println(false);
        
    }
}
