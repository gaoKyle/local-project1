package test;

import java.util.Scanner;
public class JuZheng {
	public static int count = 0;
	public static int temp = 0;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] arrStr = str.split(" ");
		int n = arrStr.length;
		int[][] arr = new int[n][n];
		for(int i = 0; i < n; i++){
			arr[0][i] = Integer.parseInt(arrStr[i]);
		}
		for(int i = 1; i < n; i++){
			for(int j = 0; j < n; j++){
				arr[i][j] = sc.nextInt();
			}
		}
		minBuShu(arr, 0, 0);
		
		System.out.println(count == 0 ? -1 : count);
	}
	public static void minBuShu(int[][] arr, int row, int col){
		if(arr == null || row < 0 || row >= arr.length || col < 0 || col >= arr.length)
			return;
		if(row == arr.length - 1 && col == arr.length - 1){
			if(count == 0)
				count = temp;
			else{
				count = count > temp ? temp : count;
			}
			return;
		}
		if(arr[row][col] == 0){
			temp++;
			arr[row][col] = 1;
			minBuShu(arr, row - 1, col);
			minBuShu(arr, row + 1, col);
			minBuShu(arr, row, col - 1);
			minBuShu(arr, row, col + 1);
			temp--;
			arr[row][col] = 0; 
		}
	}
}
