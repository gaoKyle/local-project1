import java.util.Scanner;
public class BD1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(getThirdMax(arr));
    }
    public static int getThirdMax(int[] arr){
        if(arr.length < 3)
            return -1;
        int count = 1;
        int temp = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = i; j < arr.length; j++){
                if(arr[i] > arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        temp = arr[0];
        int index = 0;
        for(int i = 1; i < arr.length; i++){      	
        	if(arr[i] != temp){
        		temp = arr[i];
        		count++;
        		if(count == 3 || count == arr.length){
        			index = i;
        			break;
        		}
        	}
        }
        return count == 3 ? arr[index] : -1;
    }
}
