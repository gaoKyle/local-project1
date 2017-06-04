import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arr = str.split(" ");
        int B = Integer.parseInt(arr[0]);
        int len = arr.length / 2 ;
        int[] p = new int[len];
        int[] v = new int[len];
        
        for(int i = 0; i < len; i++){
        	p[i] = Integer.parseInt(arr[i*2 + 1]);
        }
        for(int i = 1; i <= len; i++){
        	 v[i - 1] = Integer.parseInt(arr[2*i]);
        }
        System.out.println(getMaxPlay(B, len, p, v));
    }
    public static int getMaxPlay(int B, int n, int[] p, int[] v){ 
        int[][] dp = new int[n + 1][B + 1];
        for(int i = 0; i < n + 1; i++){
            dp[i][0] = 0;
        }
        for(int j = 0; j < B + 1; j++){
            dp[0][j] = 0;
        }
        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < B + 1; j++){
                if(p[i - 1] <= j){
                    if(dp[i - 1][j] < (dp[i - 1][j-p[i - 1]] + v[i - 1]))
                        dp[i][j] = dp[i - 1][j - p[i - 1]] + v[i - 1];
                    else
                        dp[i][j] = dp[i - 1][j]; 
                }else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][B];
    }
}