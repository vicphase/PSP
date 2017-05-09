//Added
package Program3.collections;

/**
 * Created by Víctor Martínez on 2/27/2017 at 8:27 PM.
 * Description: node containing 2 numbers
 */

public class Node { //StartClass

    private double number1;
    private double number2;
    private Node next;

    public Node() { //StartMethod
    }

    public double getNumber1() { //StartMethod
        return number1;
    }

    public void setNumber1(double number1) { //StartMethod
        this.number1 = number1;
    }

    public double getNumber2() { //StartMethod
        return number2;
    }

    public void setNumber2(double number2) { //StartMethod
        this.number2 = number2;
    }

    public Node getNext() { //StartMethod
        return next;
    }

    public void setNext(Node next) { //StartMethod
        this.next = next;
    }
}//EndClass