package example.zsltest;

public class Zuoye {
    public static void main(String[] args) {
        int x;
        int y;
        for(int a=0;a<=9;a++ ){
            for(int b=1;b<=9;b++){
                for(int c=1 ;c<=9;c++){
                    for(int d=0; d<=9;d++){
                        x=2202+a*10;
                        y=c*100+70+d;
                        if(x==y*b){
                            System.out.println(a+""+b+""+c+""+d);
                        }
                    }
                }
            }
        }
    }
}
