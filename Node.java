public class Node{
    private String data;
    private Node next,prev;
    
    public Node(String value){
        data = value;
    }

    public void setData(String data){
        this.data = data;
    }

    public void getData(){
        return data;
    }

    public void setNext(Node next){
        this.next = next;
    }

    public void getNext(){
        return next;
    }

    public void setPrev(Node prev){
        this.prev = prev;
    }

    public void getPrev(){
        return prev;
    }
}
