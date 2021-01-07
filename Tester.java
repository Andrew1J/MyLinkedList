public class Tester {
    public static void main(String[] args) {
        MyLinkedList c = new MyLinkedList();
        c.add(0, "hello");
        c.add(0, "world");
        c.add(2, "foo");
        c.add(1, "bar");
        System.out.println(c.toString());
        //"[world, bar, hello, foo]"
        try{
            c.get(222);
        } catch (IndexOutOfBoundsException e){
            System.out.println("Index out of bounds");
        }
        System.out.println(c.get(2));
        c.set(1,"poopie");
        System.out.println(c.toString());
    }
}
