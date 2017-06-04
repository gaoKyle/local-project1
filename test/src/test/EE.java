package test;

import java.util.Scanner;

public class EE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pos = sc.nextInt();
        sc.nextLine();

        int[][] arrPos = new int[2][pos];
        for(int i = 0; i < pos && sc.hasNextInt(); i++){
            arrPos[0][i] = sc.nextInt();
        }
        sc.nextLine();
        for(int j = 0; j < pos && sc.hasNextInt(); j ++){
            arrPos[1][j] = sc.nextInt();
        }
        
        sc.nextLine();
        int row = sc.nextInt();
        int col = sc.nextInt();
        
        sc.nextLine();
        int time = 0;
        int walkTime = sc.nextInt();
        int taxiTime = sc.nextInt();
        sc.close();
        //找到最近打车点
        double temp = Double.MAX_VALUE;
        double len = 0;
        int zd = 0;
        for(int i = 0; i < pos; i++){
            len = Math.sqrt(arrPos[0][i]*arrPos[0][i] + arrPos[1][i]*arrPos[1][i]);
            if(temp > len){
                temp = len;
                zd = i;
            }
        }
        if((arrPos[0][zd] == 0 || arrPos[1][zd] == 0)&&(row == 0 || col == 0) && ((arrPos[0][zd]*arrPos[0][zd] + arrPos[1][zd]*arrPos[1][zd]) == (col*col + row*row))) {
        	time = Math.abs(walkTime*(row + col));
            System.out.println(time);
            return;
        }
        time = walkTime*(Math.abs(arrPos[0][zd]) + Math.abs(arrPos[1][zd])) + taxiTime*(Math.abs(row-arrPos[0][zd]) + Math.abs(col - arrPos[1][zd]));
        System.out.println(Math.abs(time));
    }
}
