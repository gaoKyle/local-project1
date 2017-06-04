package test;

import java.util.ArrayList;
import java.util.Scanner;

public class DD {
		public static ArrayList<Integer> list = new ArrayList<Integer>();
		public static int time = Integer.MAX_VALUE;
		public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int x = sc.nextInt();
	        sc.nextLine();
	        int y = sc.nextInt();
	        list.add(5);
	        
	        int temp = 0;

	        int[][] tableFly = {{0,2,10,5,3,-1},{-1,0,12,-1,-1,10},{-1,-1,0,-1,7,-1},
	                            {2,-1,-1,0,2,-1},{4,-1,-1,1,0,-1},{3,-1,1,-1,2,0}};
	        if(y == 5){
	            System.out.println("[]"); 
	            return;
	        }
	        for(int i = 0; i < 6; i++){
	            tableFly[y - 1][i] = -1;
	        }
	        for(int j = 0; j < 6; j++){
	            tableFly[j][y - 1] = -1;
	        }
	        if(tableFly[4][x - 1] != -1){
	            list.add(x);
	            time = tableFly[4][x-1];
	            System.out.println(list.toString());
	            System.out.println(time);
	        }else{
	            for(int i = 0; i < 6; i++){
	                if(tableFly[4][i] != -1 && tableFly[4][i] != 0){
	                    temp += tableFly[4][i];
	                    list.add(i+1);
	                    for(int j = 0; j < 6; j++){
	                        if(tableFly[i][x-1] != -1){
	                            list.add(x);
	         				    temp += tableFly[i][x-1];	
	                        }
	                        if(temp < time){
	                            time = temp;
	                            System.out.println(time);
	                            System.out.println(list.toString());
								return;
	                        }else{
	                            temp = 4;
	                            list.clear();
	                        }
	                    }     
	                }
	            }
	        }
	        
	        //getList(tableFly, );
	        //System.out.println();
		}
	    public static void getList(int[][] tableFly, int row,int x){
	        if(tableFly[row][x-1] != -1){
	            list.add(tableFly[row][x-1]);
	            time += tableFly[row][x-1];
	        }
	        for(int i = 0; i < 6; i++){
	            if(tableFly[row][i] != -1){
	                getList(tableFly, i, x); 
	            }
	        }
	    }
}

