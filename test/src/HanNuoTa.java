import java.util.Scanner;


public class HanNuoTa {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		hanNuo(n);
	}
	public static void hanNuo(int n){
		if(n > 0){
			func(n, "left", "mid", "right");
		}
	}
	public static void func(int n, String from, String mid, String to){
		if(n == 1){
			System.out.println("move from " + from + " to " + to);
		}else{
			func(n - 1, from, to, mid);
			func(1, from, mid, to);
			func(n - 1, mid, from, to);
		} 
	}
}
