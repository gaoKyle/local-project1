package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BB {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        String[] strArr = new String[n];
        sc.nextLine();
        int count = 0;
        for(int i = 0; i < n; i++){
            strArr[i] = sc.nextLine();
        }
        for(int i = 0; i < n; i++){
        	if(strArr[i] == " ")
        		count++;	
        }
        int res = n - count;
		for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n; j++){
                if(judgeStr(strArr[i], strArr[j])){
                   res -= 1;
                   
                }
            }
        }  
		if(res <= 0)
			res = 1;
        System.out.println(res - count);
    }
    public static boolean judgeStr(String str1, String str2){
        if(str1.length() != str2.length())
            return false;
        char[] ch1 = str1.toCharArray(); 
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int j = 0; j < ch1.length; j++){
            if(map.containsKey(ch1[j]))
                map.put(ch1[j], map.get(ch1[j]) + 1);
            else
                map.put(ch1[j], 1);
        }
        char[] ch2 = str2.toCharArray(); 
        for(int j = 0; j < ch2.length; j++){
            if(map.containsKey(ch2[j]))
                map.put(ch2[j], map.get(ch2[j]) - 1);
            else
                return false;
        }
        for(Character cha : map.keySet()){
            if(map.get(cha) != 0)
                return false;
        }
        return true;
    }
}
