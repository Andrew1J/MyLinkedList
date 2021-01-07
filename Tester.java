public class Tester {
    public static void main(String[] args) {
        MyLinkedList a = new MyLinkedList();
        MyLinkedList b = new MyLinkedList();
        for(int i = 0; i < 10; i++){
            if(i < 5){
                a.add(i+"");
            }else{
                b.add(i+"");
            }
        }
        MyLinkedList c = new MyLinkedList();
        c.add(0, "hello");
        c.add(0, "world");
        c.add(2, "foo");
        c.add(1, "bar");
        System.out.println(c.toString());
        //"[world, bar, hello, foo]"
    }
}
