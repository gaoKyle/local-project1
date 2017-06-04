package test;

import java.util.Scanner;

public class F {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
			arr[i] = sc.nextInt();
        } 
        int cycle = k / n;
        int last = k % n;
        for(int i = 0; i < cycle; i++){
            for(int j = 0; j < n ; j++){
                if(j != n - 1){
                    arr[j] = (arr[j+1] + arr[j])%100;
                }else
                    arr[j] =(arr[j] + arr[0]);
            }  
        }
        for(int i = 0; i < last; i++){
            for(int j = 0; j < n ; j++){
                if(j != n - 1){
                    arr[j] = (arr[j+1] + arr[j])%100;
                }else
                    arr[j] =(arr[j] + arr[0]);
            }  
        }       
        for(int i=0;i<arr.length - 1;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.print(arr[arr.length - 1]);
	}
}
