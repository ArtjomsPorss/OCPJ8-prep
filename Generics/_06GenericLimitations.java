import java.util.List;

public class _06GenericLimitations {
    public static void main(String[] args) {
        // 1. Generics don't work with primitive types, use Wrappers instead

    }

    static class GenT<T> {
        // you cannot create instance of a type parameter
        T field = new T();    // you don't know the type's constructors

        //You cannot decalre static field of a type parameter.
        // If static member is shared by many isntances,
        // and each instance can declare different type
        // what is the actual type of var?
        static T var;


        // Due to type erasure instanceof cannot be used with generic types
        public boolean checkListInteger(List<?> list){
            if(list instanceof List<Integer>) {
                return true;
            }
            return false;
        }

        // instanceof works only with unbounded wildcard to verify that obj is a List
        public boolean checkIsList(List<?> list){
            if(list instanceof List<?>) {
                return true;
            }
            return false;
        }

        // you cannot instantiate an array of generic types
        T[] array; //OK
        T[] array1 = new T[100];    // compiler errror
        List<String>[] array2 = new List<String>[10]; // compiler error

        // you cannot create, catch or throw generic types
        <E extends Exception> void method(){
            try {
                // ...
            } catch(E e){   // Compiler Error
                // ...
            }
        }

        // You cannot overload a method where type erasure will leave the parameters with the same type
        public void method1(List<String> list) {}
        public void method1(List<Integer> list) {}
    }
}