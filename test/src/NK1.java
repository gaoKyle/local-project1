import java.util.Scanner;
public class NK1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }
        System.out.println(minSplit(arr));
    }
    public static int minSplit(int[] arr){
        if(arr == null || arr.length == 0)
            return 0;
        int n = arr.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 0;
        for(int i = 3; i <= n; i++){
        	if(arr[i - 1] != arr[i - 2] ){
        		if(dp[i - 1] > dp[i - 2])
        			dp[i] = dp[i - 1];
        		else{
        			if((arr[i - 2] >= arr[i- 3] && arr[i - 1] >= arr[i - 2]) ||
        					(arr[i - 2] <= arr[i- 3] && arr[i - 1] <= arr[i - 2]))
        				dp[i] = dp[i - 1];
        			else
        				dp[i] = dp[i - 1] + 1;
        		}
        	}else{
        		dp[i] = dp[i - 1];
        	}
        		
        }
        return dp[n] + 1;
    }
}
