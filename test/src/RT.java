import java.util.Scanner;

public class RT {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
		    int n = in.nextInt();
		    System.out.println(integerBreak(n)); 
        }
	}

	private static int integerBreak(int n) {
		int[] arr = new int[100];
		int k =1, sum = 1, s = 0;
		if(n < 5)
			sum =  n;
		else{
			arr[1] = 2;
			n -= 2;
			while(n > arr[k]){
				k++;
				arr[k] = arr[k - 1] + 1;
				
				n -= arr[k];
				s = k;
			}
			if(n == arr[k]){
				arr[k]++;
				n--;
			}
			for(int i = 0; i < n; i++)
				arr[k - i]++;
			for(int j = 1; j <= s; j++)
				sum *= arr[j];
		}
		return sum;
	}
    public int calculateMax(int[] prices, int k) {
		int firstBuy = Integer.MIN_VALUE;
        int firstSell = 0;
        int secondBuy = Integer.MIN_VALUE;
        int secondSell = 0;
        for(int i = 0; i < prices.length; i=i+k){
            firstBuy = Math.max(firstBuy, -prices[i]);
            firstSell = Math.max(firstSell, prices[i] + firstBuy);
            secondBuy = Math.max(secondBuy, firstSell - prices[i]);
            secondSell = Math.max(secondSell, prices[i] + secondBuy);
        }
		return secondSell;
    }
}
