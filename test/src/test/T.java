package test;

import java.util.Scanner;

public class T {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++){
			arr[i] = sc.nextInt();
		}
		
		if(n < 1 || arr == null || arr.length == 0){
			System.out.println("-1 -1");
			return;
		}
		int start = 0;
		int end = 0;
		int max = 0;
		int lstart = 0;
		int lend = 0;
		boolean flag = true;
		for(int i = 0; i < n - 1; i++){
			if(flag){
				if(arr[i] < arr[i+1]){
					continue;
				}
				else
					flag = false;
			}
			if(!flag){
				if(arr[i] > arr[i+1]){
					continue;
				}else{
					flag = true;
					end = i;
				}
			}
			if(end - start > max){
				max = end - start;
				lstart = start;
				lend = end;
			}	
			start = i;
			end = i;
		}
        if(n >2 && arr[n - 1] < arr[n - 2] && !flag)
			lend = n-1;
        if( max == 0 && flag){
			System.out.println("-1 -1");
			return;
		}		
		System.out.println(lstart +" " + lend);
	}

}
