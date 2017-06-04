import java.util.Scanner;


public class JD {
	public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	while(sc.hasNextLine()){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int count = 0;
            if(k < 0 || n < 0){
                System.out.println(0);
                return;
            }
            if(k > n){
            	System.out.println(0);
                return;
            }
                
            if(k == 1){
            	if(n == 2){
                	System.out.println(1);
                    return;
                }else{
                    int temp = n % 3;
                	if(temp == 0){
                    	System.out.println((n / 3) * 2);
                        return;
                    }else{
                    	System.out.println((n / 3) * 2 + 1);
                        return;
                    }
                }
            }
            if(n == k){
                System.out.println(1);
                return;
            }
            int m1 = n % (k + 1);
            int m2 = n / (k + 1);
            if(m1 == 0){
                System.out.println(m2);
                return;
            }else{
                if(m1 >= k)
                     System.out.println(m2 + 1);
                else
                    System.out.println(m2);
                return;                 
            }
    	}

    }
}
