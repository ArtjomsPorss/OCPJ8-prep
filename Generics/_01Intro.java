import java.util.ArrayList;
import java.util.List;

public class _01Intro {
    
    
    public static void main(String[] args) {
        // without generics - can put any object in the list
        List list = new ArrayList();
        list.add("a");
        list.add(new Integer(1));
        list.add(Boolean.TRUE);
        // have to cast to type when getting objects from list
        String a = (String)list.get(0);
        System.out.println(a);

        // by adding String type to list, we are telling to COMPILER that only String objects can be added to the list.
        List<String> stringList = new ArrayList<String>();
        stringList.add("b");
        /*
        // compiler error:
        stringList.add(new Integer(1));
        stringList.add(Boolean.TRUE);
        */
        // now we can safely get elements without a cast
        String b = stringList.get(0);
        System.out.println(b);

        /**
         * Generics are a thing of COMPILER.
         * At runtime Java doesn't know about Generics.
         * Underthe hood the compiler inserts all the checks and casts for you. 
         * But at runtime, a generic type is seen by Java as a java.lang.Object type.
         * The process of replacing all references to generic types with Object is called TYPE ERASURE.
         */

        // primitives don't work
        //List<int> intList = new ArrayList<int>();
         
        // Arrays are objects, so will work
        List<int[]> intList = new ArrayList<int[]>();

        // raw type is used
        List<List<String>> raw = new ArrayList();
        // note the diamond operator <> means generic is used
        List<List<String>> generic = new ArrayList<>();

        // since java 8 the compiler can infer generic type even when passing to a method:
        genericParamMethod(new ArrayList<>());
       
    }

    public static void genericParamMethod(List<String> stringList) {
        System.out.println("success - in genericParamMethod!");
    }
}