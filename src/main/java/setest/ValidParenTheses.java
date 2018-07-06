package setest;

import java.util.Scanner;

/**
 * Created by zsl on 2018/7/6.
 */
public class ValidParenTheses {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String paretns =scanner.nextLine();
        boolean flag =valid(paretns);
        if(flag){
            System.out.println("TRUE");
        }else{
            System.out.println("FALSE");
        }
    }
    public static Boolean valid(String parents){
        char[] stack = new char[parents.length()+1];
        int top = 1;
        for (char c:parents.toCharArray()){
            if(c =='('||c =='['||c == '{'){
                stack[top++] =c;
            }else if(c ==')'&&stack[--top]!='('){
                return false;
            }else if(c ==']'&&stack[--top]!='['){
                return  false;
            }else if (c =='}'&&stack[--top]!='{'){
                return false;
            }
        }
        return top==1;
    }
}
