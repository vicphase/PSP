package Program1.collections;

/**
 * Created by Víctor Martínez on 1/29/2017 at 4:43 PM.
 */


public class Node {
    
    private double data;
    private Node next;

    public Node() {
    }

    public double getData() {
        return data;
    }

    public void setData(double data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
         
}
