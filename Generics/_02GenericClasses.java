public class _02GenericClasses {
    
    // we need a class to store and print the object. 
    // it can accept only String, what if we need it to accept several types, e.g. Integer?
    static class StringHolder {
        private String s;
        public StringHolder(String s) {
            this.s = s;
        }
        public String get() {
            return s;
        }
        public void print(){
            System.out.println(s);
        }
    }

    // Integer version
    static class IntegerHolder {
        private Integer s;
        public IntegerHolder(Integer s) {
            this.s = s;
        }
        public Integer get() {
            return s;
        }
        public void print(){
            System.out.println(s);
        }
    }
    // duplicate feels and looks wrong, how class taking in Object? No, we will need to add casts everywhere.

    // Generics to the rescue.
    static class Holder<T> {
        private T t;
        public Holder(T t) {
            this.t = t;
        }
        public T get(){
            return t;
        }
        public void print(){
            System.out.println(t);
        }
    }

    public static void main(String[] args) {
        Holder<String> stringHolder = new Holder<>("Hello from StringHOlder");
        Holder<Integer> integerHolder = new Holder<>(1);
        String s = stringHolder.get();
        int i = integerHolder.get();
        System.out.println(s);
        System.out.println(i);
    }

}