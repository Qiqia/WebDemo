package example.zsltest;

public class loigc {
    public static void main(String[] args) {
        if(first()&&second()){
            System.out.println("in");
        }

    }

    public static boolean first(){
        System.out.println("first");
        return false;
    }

    private static boolean second(){
        System.out.println("second");
        return true;
    }


}
