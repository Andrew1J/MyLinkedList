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
        if (size==0){
            start = newValue;
            end = newValue;
            size++;
        } else if(index==size){
            add(value);
        } else if (index==0){
            start.setPrev(newValue);
            newValue.setNext(start);
            start = newValue;
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
                if(i!=size-1)val+=", ";
            }
        }
        val += "]";
        return val;
    }

    public String toStringReversed(){
        if(size==0)return "[]";
        String val = "[";
        Node curr = start;
        for(int i=size-1;i>=0;i--){
            if(getNode(i)!=null){
                val += getNode(i).getData();
                if(i!=0)val+=", ";
            }
        }
        val += "]";
        return val;
    }

    public String remove(int index){
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException();
        }
        String old=getNode(index).getData();
        if (size==1){
            start = null;
            end = null;
        } else if (index==0){
            Node nextNode = getNode(index+1);
            Node value = getNode(index);
            nextNode.setPrev(null);
            value.setNext(null);
            start = nextNode;
        } else if (index==size-1){
            Node prevNode = getNode(index-1);
            Node value = getNode(index);
            value.setPrev(null);
            prevNode.setNext(null);
            end = prevNode;
        } else {
            Node value = getNode(index);
            Node prevNode = getNode(index-1);
            Node nextNode = getNode(index+1);
            prevNode.setNext(nextNode);
            nextNode.setPrev(prevNode);
            value.setNext(null);
            value.setPrev(null);
        }
        size--;
        return old;
    }

    public void extend(MyLinkedList other){
        if(other.size>0){
            if(size==0){
                start = other.start;
                end = other.end;
            } else {
                end.setNext(other.start);
                other.start.setPrev(end);
                end = other.end;
            }
        }
        size+=other.size();
        other.size = 0;
        other.start = null;
        other.end = null;
    }

    private Node getNode(int n){
        Node curr = start;
        for(int i=0;i<n;i++){
            curr = curr.getNext();
        }
        return curr;
    }
}
