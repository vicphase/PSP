package Program1.collections;

/**
 * Created by Víctor Martínez on 1/29/2017 at 4:43 PM.
 * Description: class used to store data to create dynamic lists
 */


public class Node { //StartClass
    
    private double data;
    private Node next;

    public Node() { //StartMethod
    }

    public double getData() { //StartMethod
        return data;
    }//EndMethod

    public void setData(double data) { //StartMethod
        this.data = data;
    }//EndMethod

    public Node getNext() { //StartMethod
        return next;
    }//EndMethod

    public void setNext(Node next) { //StartMethod
        this.next = next;
    }//EndMethod
         
}//EndClass
