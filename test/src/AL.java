import java.util.*;

public class AL {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        if(line != null && !line.isEmpty()) {
            int res = resolve(line.trim());
            System.out.println(String.valueOf(res));
        }
    }

    // write your code here
    public static int resolve(String expr) {
       Stack<Integer> stack = new Stack<Integer>();
       String[] strArr = expr.split(" ");
       int temp = 0;
       for(int i = 0; i < strArr.length; i++){
           if(strArr[i].equals("*")){
               try{
                   int num1 = stack.pop();
                   int num2 = stack.pop();
                   temp= num1 * num2;
                   stack.push(temp);
                   continue;
               }catch(EmptyStackException e){
                   return -1;
               }catch(Exception e){
                   return -2;
               }
           }
           if(strArr[i].equals("+")){
               try{
                   int num1 = stack.pop();
                   int num2 = stack.pop();
                   temp= num1 + num2;
                   stack.push(temp);
                   continue;
               }catch(EmptyStackException e){
                   return -1;
               }catch(Exception e){
                   return -2;
               }
           } 
           if(strArr[i].equals("^")){
               try{
                   int num1 = stack.pop();
                   temp= num1 + 1;
                   stack.push(temp);
                   continue;
               }catch(EmptyStackException e){
                   return -1;
               }catch(Exception e){
                   return -2;
               }
           } 
           else
               stack.push(Integer.parseInt(strArr[i])); 
      }
      return stack.pop();
    }
}