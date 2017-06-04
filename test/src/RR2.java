import java.util.Scanner;

public class RR2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int workTime = 4 * 60 - m;
        int temp = 0;
        int num = 0;
       if(n >= 1 && n <= 10 && m >= 1 && m <= 240){   
           for(int i = 1; i <= n; i++){
               if(temp < workTime){
            	   temp += i * 5; 
            	   if(temp > workTime){
            		   num = i - 1;
            		   break;
            	   }
                   continue;
               }
               num = i - 1;
               break;
           }
           if(temp < workTime)
               num = n;
       }
        System.out.println(num);
    }
}
