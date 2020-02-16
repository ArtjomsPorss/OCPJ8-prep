import java.util.ArrayList;
import java.util.List;

public class _05GenericsWildcards2 {
    // The Second Problem of Generics is that when working with a type parameter, 
    // we can only use methods from Object since we don't know the exact type of the parameter:
    static class Printer1<T> {
        public void print(T t){
            System.out.println(t.toUpperCase()); // Error
            // What if T doesn't represent a String
        }
    }
    /*
    the solution is to use the so-called bounded wildcards
    ? extends T (Upper-bounded wildcard)
    ? super T (Lower-bounded wildcard)
    */
    // UPPER BOUNDED WILDCARD
    static class Printer2<T extends String> {
        public void print(T t){
            System.out.println(t.toUpperCase()); // OK
        }
    }
    
    
    public static void main(String[] args) {
        // compiler error, toUpperCase() is undefined for type T
        // Printer1 p1 = new Printer1<String>();
        // p1.print("a");
        

        // OK - UPPER BOUNDED WILDCARD used
        // Printer2 p2 = new Printer2<String>();
        Printer2<String> p2 = new Printer2<>();
        p2.print("a");

        // compuler error - Byte does not extend String
        // Printer2<Byte> p2byte = new Printer2<>();

        // UPPER BOUNDED WILDCARD solves this problem:
        //List<Object> list = new ArrayList<String>(); // compiler error
        List<? extends Object> list2 = new ArrayList<String>();
        // but we still cannot modify the list:
        // list2.add("Hi");    // compiler error - because compiler doesn't know for sure what type will the list hold

        // When you know that the instances in the collection are of instances of Number or subclasses of Number,
        // it is safe to READ the instances of the collection and cast them to Number instances.

        // List<Number> is more restrictive than List<? extends Number>
        List<Integer> integerList = new ArrayList<>();
        List<Float> floatList = new ArrayList<>();
        List<Number> numberList = new ArrayList<>();
        List<Number> numberList3 = new ArrayList<>();
        numberList.add(new Integer(1)); //OK
        numberList.add(new Float(1.0F)); //OK
        // numberList = integerList;    // compiler Error
        // numberList = floatList;      // compiler Error
        List<? extends Number> listExtendsNum = new ArrayList<>();
        // listExtendsNum.add(new Integer(1));  // compiler error. Because List may be of any type - Integer or Float. And you are not able to insert Float into List of Integers
        // listExtendsNum.add(new Number()); // compiler error
        listExtendsNum = integerList;   //OK
        listExtendsNum = floatList;     //OK
        listExtendsNum = numberList3;   //OK

        Number num1 = listExtendsNum.get(0); //OK Since List generic type Must be a Number
        System.out.println(num1);

        // LOWER BOUNDED WILDCARD
        List<? super Integer> integerList2 = new ArrayList<>();
        // It means that list can be assigned to an Integer list or some supertype of Integer
        // we can add only instances of T or one of its subclasses because the are T also. 
        // Integer in this example doesn't hve subclasses, so we can only insert Integer instances.
        integerList2.add(1);    //OK
        // integerList2.add(0.2F); // Compiler Error
        // List<Number> numList = integerList2; // compiler Error
        
        // even if the list's type is List<Number>, an Integer can be assigned to a Number for that matter.
        // When you know that the list is typed to either Number, or a superclass of Number, 
        // it is safe to insert instances of Number or subclasses of Number (e.g. Float or Integer) into the list.
        List<? super Number> numberList2 = new ArrayList<>();
        numberList2.add(1);     //OK
        numberList2.add(0.2F);  //OK
        numberList2.add(null);  //OK


        List<Integer> listInteger = new ArrayList<>();
        List<Object> listObject = new ArrayList<>();
        List<? super Number> listSUperNum = new ArrayList<>();
        listSUperNum.add(new Integer(1));   //OK
        listSUperNum.add(new Float(1.0F));  //OK
        Object o1 = listSUperNum.get(0);    //OK
        // Integer i1 = listSUperNum.get(0);   // Compiler error. Type mismatch: cannot convert from capture#11-of ? super Number to Integer



        // listSUperNum = listInteger; // compiler error
        listSUperNum = listObject;          //OK
    }
}