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
        c.add("bob");
        c.remove(4);
        c.remove(0);
        c.remove(1);
        System.out.println(c.toString());
        MyLinkedList d = new MyLinkedList();
        d.add(0, "hello");
        d.add(0, "world");
        d.add(2, "foo");
        d.add(1, "bar");
        c.extend(d);
        System.out.println(c.toString());
        System.out.println(d.toString());

    }
}
