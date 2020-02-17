import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _01List {
    public static void main(String[] args) {
        List<String> l1 = initialiseStringList();
        List<String> l2 = initialiseStringList();
        List<String> l3 = initialiseStringList();
        List<String> l4 = initialiseStringList();
        

        // retain only the elements as in provided list, remove the rest
        l1.retainAll(Arrays.asList("a"));
        System.out.println(l1); // [a, a, a]
        
        
        // replace each element
        l2.replaceAll(e -> e + "1");
        System.out.println(l2); // [a1, b1, c1, d1, a1, e1, a1, f1]
        
        
        // replace element in index
        l3.set(0, "new");
        System.out.println(l3); // [new, b, c, d, a, e, a, f]


        // remove all elements that satisfy given predicate
        l4.removeIf(e -> "a".equalsIgnoreCase(e));
        System.out.println(l4); // [b, c, d, e, f]


        /*
        The returned list implements the optional Collection methods, 
        except those that would change the size of the returned list. 
        Those methods leave the list unchanged and throw UnsupportedOperationException.
        */
        List<String> l5 = Arrays.asList("a", "b", "c", "d", "a", "e", "a", "f");
        l5.remove(0);
    }

    public static List<String> initialiseStringList() {
        return new ArrayList<>(Arrays.asList("a", "b", "c", "d", "a", "e", "a", "f"));
    }
}