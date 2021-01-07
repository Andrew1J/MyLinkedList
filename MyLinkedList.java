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
        Node newValue = new Node(value);
        if(size==0){
            start = newValue;
            end = newValue;
            size++;
        } else {
            end.setNext(newValue);
            newValue.setPrev(end);
            end = newValue;
            size++;
        }
        return true;
    }

    public void add(int index, String value){
        Node newValue = new Node(value);
        if(index<0||index>size){
            throw new IndexOutOfBoundsException();
        }
        if(index==size){
            add(value);
        } else if (index==0){
            start.setPrev(newValue);
            newValue.setNext(start);
            start = newValue;
            size++;
        } else if (index==size-1) {
            end.setNext(newValue);
            newValue.setPrev(end);
            end = newValue;
            size++;
        } else {
            Node prevNode = getNode(index-1);
            Node nextNode = getNode(index);
            newValue.setPrev(prevNode);
            newValue.setNext(nextNode);
            prevNode.setNext(newValue);
            nextNode.setPrev(newValue);
            size++;
        }
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
            if(getNode(i)!=null){
                val += getNode(i).getData();
            }
            if(i!=size-1)val+=", ";
        }
        val += "]";
        return val;
    }

    private Node getNode(int n){
        Node curr = start;
        for(int i=0;i<n;i++){
            curr = curr.getNext();
        }
        return curr;
    }
}
