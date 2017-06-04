import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class DD2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
        if(str == null || str.length() == 0)
            return;
		String[] strArr = str.split(" ");
		String num = sc.nextLine();
		
		HashMap<Character, String> map = new HashMap<Character, String>();
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jki");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");
		
		String stander = "";
		for(int i = 0; i < num.length(); i++){
			stander += map.get(num.charAt(i));
		}
		int max = 0;
		int temp = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < strArr.length; i++){
			temp = longSubStr(stander, strArr[i]);
			if(temp > max){
				max = temp;
				list.add(i);
			}
		}
		for(Integer index : list){	
			System.out.println(strArr[index]);
		}
	}
	public static int longSubStr(String str1, String str2) {
	    int len1 = str1.length();
	    int len2 = str2.length();
	    int result = 0; 
	    int dp[][] = new int[len1+1][len2+1];
        dp[0][0] = 0;
        for(int i = 1; i < len1; i++){
            dp[i][0] = Math.max(dp[i - 1][0], str1.charAt(i - 1) == str2.charAt(0) ? 1 : 0);
        }
        for(int j = 1; j < len2; j++){
            dp[0][j] = Math.max(dp[0][j - 1], str1.charAt(0) == str2.charAt(j - 1) ? 1 : 0);
        }
	    for (int i = 1; i <= len1; i++) {
	        for( int j = 1; j <= len2; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (str1.charAt(i-1) == str2.charAt(j-1))
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + 1); 
	        }
	    }
	    return dp[len1][len2];
	}
}
