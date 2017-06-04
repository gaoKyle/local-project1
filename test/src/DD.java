import java.util.Scanner;


public class DD {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.nextLine();
		char [][] arr = new char[n][m];
		for(int i = 0; i < n; i++){
			String s = sc.nextLine();
			for(int j = 0; j < s.length(); j++){
				arr[i][j] = s.charAt(j);
			}
		}
		int result = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if(arr[i][j]== '1'){
                    searchIsland(arr, i, j);
                    result++;
                }
            }
        }
		System.out.println(result);
	}
    private static void searchIsland(char[][] arr, int i, int j){
        arr[i][j]= 0;
        if(i>0 && arr[i-1][j]== '1') 
        	searchIsland(arr, i-1, j);
        if(j>0 && arr[i][j-1]== '1') 
        	searchIsland(arr, i, j-1);
        if(i<arr.length-1 && arr[i+1][j]== '1') 
        	searchIsland(arr, i+1, j);
        if(j<arr[0].length-1 && arr[i][j+1]== '1') 
        	searchIsland(arr, i, j+1);
    }
}
