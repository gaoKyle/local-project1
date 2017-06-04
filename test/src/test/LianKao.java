package test;

import java.util.ArrayList;
import java.util.Scanner;

public class LianKao {
	public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        for(int i = 1; i <= n; i++){
        	if(isPerfact(i))
                count += i;
        }
        System.out.println(count);
        //System.out.println(isPerfact(n));
    }
    public static boolean isPerfact(int t){
    	ArrayList<Integer> list = new ArrayList<Integer>();
        int temp = 0;
        for(int i = 1; i <= t && !list.contains(i); i++){
        	if(t % i == 0){
            	list.add(i);
            	if(t / i != i)
            		list.add(t / i);
            }
        }
        for(Integer in : list){
        	temp = (int)(temp + in*in);
        }        
        return Math.sqrt(temp) - Math.round(Math.sqrt(temp)) == 0 ? true : false;
    }
}
