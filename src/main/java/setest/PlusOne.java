package setest;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zsl on 2018/7/6.
 */
public class PlusOne {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数组长度");
        int inLen = sc.nextInt();
        System.out.println("请输入"+inLen+"个数");
        List<Integer> inlist =new ArrayList<Integer>();
        for(int x=0;x<inLen;x++){
            inlist.add(sc.nextInt());
        }
        int inLength =inlist.size();

        int[] x=new int[inLength];
        for(int tmp=0;tmp<x.length;tmp++){
           x[tmp]=inlist.get(tmp);
        }
        int[] y=plusOne(x);

        List<Integer> outList =new ArrayList<Integer>();
        for (int tt:y){
            outList.add(tt);
        }
        System.out.println(outList.toString());

    }

    public static int[] plusOne(int[] digits){
        int p = digits.length - 1;
        if(digits[p]<9){
            digits[p] = ++digits[p];
        }else {
            do {
                digits[p--] = 0;
            }while (p >= 0 && digits[p] ==9);
            if (digits[0]!=0){
                ++digits[p];
            }else {
                digits = new int[digits.length+1];
                digits[0] = 1;
            }
        }
        return digits;
    }
}
