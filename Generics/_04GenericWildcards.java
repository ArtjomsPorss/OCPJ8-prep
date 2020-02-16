import java.util.ArrayList;
import java.util.List;

public class _04GenericWildcards {

    public static void main(String[] args) {
        // Two problems with Generics:
        // 1. ArrayList<String> cannot be cast to List<Object>, thus will not compile
        //List<Object> list = new ArrayList<String>();
        
        // but if you change to wildcard, it will compile:
        List<?> list = new ArrayList<String>();
        
        // The unbounded wildcard type <?> means that the type of the list is unknown so that it can match ANY type.
        List<String> stringList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();
        // No Problem:
        List<?> unknownTypeList1 = stringList;
        List<?> unknownTypeList2 = integerList;
        // No Problem
        unknownTypeList1 = integerList;
        // No Problem either
        for (Object object : unknownTypeList1) {
            System.out.println(object);
        }
        // Both will not compile as compiler does not know the type of elements and cannot insure type safety
        // The lists created using wildcard type are IMMUTIBLE
        // unknownTypeList1.add(1);
        // unknownTypeList1.add("Hi");

        // Will compile
        unknownTypeList1.add(null);


        // will compile 
        unknownTypeList1.get(0);
        
        // will not compile - as compiler cannot infer the type
        // String s = unknownTypeList1.get(0);
    }

    // Wildcard is used in arguments of methods where the code just uses methods of the generic class or from Object:
    public static int getSize(List<?> list){
        return list.size();
    }
}