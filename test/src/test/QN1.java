package test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QN1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String start = sc.nextLine();
		String end = sc.nextLine();
		String str = sc.nextLine();
		String[] strArr = str.split(" ");
		HashSet<String> set = new HashSet<String>();
		for(int i = 0; i < strArr.length; i++){
			set.add(strArr[i]);
		}
		System.out.println(ladderLength(start, end, set));
	}
    public static int ladderLength(String start, String end, HashSet<String> dict) {
        if (start == null || end == null || start.length() == 0 || end.length() == 0) return 0;
        dict.remove(start);
        dict.remove(end);
        if (isDifferOne(start, end)) return 2;
        int l = bfs(start, end, dict);
        return l < 0 ? 0 : l + 1;
    }
 
    private static int bfs(String start, String end, HashSet<String> dict) {
        Iterator<String> it = dict.iterator();
        Queue<String> queue = new LinkedList<>();
        while (it.hasNext()) {
            String str = it.next();
            if (isDifferOne(start, str)) {
                queue.add(str);
                it.remove();
            }
        }
        int l = bfs(queue, end, dict);
        return l < 0 ? -1 : l + 1;
    }
 
    private static int bfs(Queue<String> queue, String end, HashSet<String> dict) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            Iterator<String> it = dict.iterator();
            String str = queue.poll();
            if (isDifferOne(str, end)) return 1;//结束循环的条件
            while (it.hasNext()) {
                String next = it.next();
                if (isDifferOne(str, next)) {
                    queue.add(next);
                    it.remove();
                }
            }
        }
        if (queue.size() == 0) return -1;
        int l = bfs(queue, end, dict);
        return l < 0 ? -1 : l + 1;
    }
 
    private static boolean isDifferOne(String s1, String s2) {
        int differ = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) differ++;
            if (differ > 1) return false;
        }
        return true;
    }
 
}
