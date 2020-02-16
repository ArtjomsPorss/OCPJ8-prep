import java.util.ArrayList;
import java.util.List;

public class _03GenericMethods {

    static class Utils {

        // generic parameter types can also be declared for any methods (not necessarily a class)
        public static <T> void print(T t) {
            System.out.println(t);
        }
        
        public static <T> void setList(List<T> list) {}

        public static <T, U> T twoParamMethod(T t, U u) {
            if(u == null) {
                return t;
            }
            return null;
        }
    }

    public static void main(String[] args) {
        Utils.print("t");    
        Utils.setList(new ArrayList<String>());    
        System.out.println(Utils.twoParamMethod(1, null));
        System.out.println(Utils.twoParamMethod(1, "abba"));
        // you can explicitly specify type between the dot and name of the method
        Utils.<Integer>print(100);
           
    }
}