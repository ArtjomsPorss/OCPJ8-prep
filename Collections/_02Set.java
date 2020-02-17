import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class _02Set {
    public static void main(String[] args) {
        // main feature of Set is that doesn't allow duplicates 
        // two most common implementations are HashSet and TreeSet

        // HashSet doesn't guarantee order of the elements
        // HashSet can contain nulls
        Set<String> s1 = new HashSet<>();
        s1.addAll(Arrays.asList("a","b","c","d","e", null, "a"));
        System.out.println(s1);
        
        
        
        // TreeSet guarantees the order of the elements
        // TreeSet cannot contain null
        Set<String> s2 = new TreeSet<>();
        s2.addAll(Arrays.asList("a","b","c","d","e","a"));
        
    }
}