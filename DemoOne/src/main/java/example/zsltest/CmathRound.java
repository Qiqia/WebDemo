package example.zsltest;

public class CmathRound {
    public static void main(String[] args) {
        Long amount1= 0L;
        Long amount2 = 2L;
        Long amount3 = 30L;
        float y = (amount1 - amount2)*amount3 / (float)amount1 ;
        System.out.println(y);
        float x =Math.round((amount1 - amount2)*amount3 / (float)amount1);
        System.out.println(x);
        System.out.println(Math.round(1.2));

    }
}
