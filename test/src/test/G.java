package test;

import java.util.ArrayList;
import java.util.Scanner;

public class G {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		int[] price = new int[n];
		for(int i = 0; i < n; i++){
			price[i] = sc.nextInt();
		}
		sc.nextLine();
		
		int[] weight = new int[n];
		for(int i = 0; i < n; i++){
			weight[i] = sc.nextInt();
		}
		sc.nextLine();
		int maxWeight = sc.nextInt();
				
		
		int index = 0;
		int danjia[] = new int[n];
		for(int i = 0; i < n; i++){
			danjia[i] = price[i] / weight[i];
		}
		int weightSum = 0;
		int priceSum= 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < n; i++){
			index = getMax(danjia, list);
			weightSum += weight[i];
			if(weightSum <= maxWeight){
				priceSum += price[i];
				continue;
			}
			weightSum -= weight[i];
		}
		System.out.println(priceSum);

	}
	public static int getMax(int[] arr , ArrayList<Integer> list){
		int temp = 0;
		for(int i = 0; i < arr.length; i++){
			if(arr[i] > temp && !list.contains(i)){
				list.add(i);
				temp = arr[i];
			}
		}
		return temp;
	}
}
