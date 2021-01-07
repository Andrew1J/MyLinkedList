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
            end.setNext(new Node(value));
            end = end.getNext();
            size++;
        }
        return true;
    }

    public boolean add(int index, String value){
        Node newValue = new Node(value);
        if(index<0||index>size){
            throw new IndexOutOfBoundsException();
        }
        if(index==0){
            start.setPrev(newValue);
            newValue.setNext(start);
            start = newValue;
            size++;
        } else if (index == size-1){
            end.setNext(newValue);
            newValue.setPrev(end);
            end = newValue;
            size++;
        } else if (size==0) {
            start = newValue;
            end = newValue;
            size++;
        }
         else {
            Node prevNode = getNode(index-1);
            Node nextNode = getNode(index);
            newValue.setPrev(prevNode);
            newValue.setNext(nextNode);
            prevNode.setNext(newValue);
            nextNode.setPrev(newValue);
            size++;
        }
        return true;
    }

    public String get(int index){
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException();
        }
        return getNode(index).getData();
    }

    public String set(int index, String value){
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException();
        }
        Node val = getNode(index);
        String old = val.getData();
        val.setData(value);
        return old;
    }

    public String toString(){
        if(size==0)return "[]";
        String val = "[";
        Node curr = start;
        for(int i=0;i<size;i++){
            val += getNode(i).getData() + ", ";
        }
        val += "]";
        return val;
    }

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
