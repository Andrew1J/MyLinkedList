public class MyLinkedList{
    private int size;
    private Node start,end;

    public MyLinkedList(){
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean add(String value){
        if(size==0){
            start = new Node(value);
            end = new Node(value);
            size++;
        } else {
            end.setNext(value);
            end = end.getNext();
            size++;
        }
        return true;
    }

    public boolean add(int index, String value){
        if(index<0||index>size){
            throw new IndexOutOfBoundsException();
        }
        Node newValue = new Node(value);
        Node place = start;

    }
    public String get(int index);
    public String set(int index, String value);
    public String toString();
    //Any helper method that returns a Node object MUST BE PRIVATE!
    
    private Node getNode(int n){
        if(n==0)return start;
        if(n==size-1)return end;
        Node curr = start;
        for(int i=0;i<n;i++){
            curr = curr.getNext();
        }
        return curr;
    }
}
