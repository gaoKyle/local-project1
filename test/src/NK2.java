import java.util.ArrayList;
import java.util.Scanner;


public class NK2 {
    public static ArrayList<ArrayList<Integer>> res;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }
        permution(arr, 0);
        int max = Integer.MIN_VALUE;
        for(ArrayList<Integer> list : res){
            int temp = list.get(1) + list.get(4);
            if(temp > max)
                max = temp;
        }
    }
    public static void permution(int[] nums, int i){
        if(i == nums.length - 1){
            ArrayList<Integer> list = new ArrayList<>();
            for(int j = 0; j < nums.length; j++){
                list.add(nums[j]);
            }
            res.add(list);
        }
        for(int j = i; j < nums.length; j++){
            swap(nums, i, j);
            permution(nums, i + 1);
            swap(nums, i, j);
        }
    }
    public static void swap(int[] nums, int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
