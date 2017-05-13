//Reused
package Program3.collections;
/**
 * Created by Víctor Martínez on 1/29/2017 at 4:43 PM.
 * Description: used to create a dynamic list
 */
public class List { //StartClass

    private Node head;

    public List() { //StartMethod
        head = null;
    }

    //Methods
    //Insert a node at any position of the list
    public void add(int position, double number1, double number2){ //StartMethod
        if (position <= size() + 1) {
            Node newNode = new Node();
            newNode.setNumber1(number1);
            newNode.setNumber2(number2);
            if (position == 1) {
                newNode.setNext(head);
                head = newNode;
            } else {
                if (position == size() + 1) {
                    Node temporalNode = head;
                    while (temporalNode.getNext() != null)
                        temporalNode = temporalNode.getNext();

                    temporalNode.setNext(newNode);
                    newNode.setNext(null);
                } else {
                    Node temporalNode = head;
                    for (int f = 1; f <= position - 2; f++)
                        temporalNode = temporalNode.getNext();
                    Node nextNode = temporalNode.getNext();
                    temporalNode.setNext(newNode);
                    newNode.setNext(nextNode);
                }

            }
        }
    }
    //End of insertAt method

    //Insert a node at the end of the list
    public void addLast(double number1, double number2) //StartMethod
    {
        Node temporalNode;
        Node newNode = new Node();
        newNode.setNumber1(number1);
        newNode.setNumber2(number2);
        newNode.setNext(null);
        //Empty List
        if (head == null) {
            head = newNode;
            head.setNext(null);
        } else //List with at least 1 node
        {
            temporalNode = head;
            while (temporalNode.getNext() != null) {
                temporalNode = temporalNode.getNext();
            }

            temporalNode.setNext(newNode);
            newNode.setNext(null);
        }
    }
    //End of insertLastMethod

    //Remove the first node of the list
    public Node getFirst() { //StartMethod
        if (head != null) {
            return head;
        } else return null;
    }
    //End of removeFirstMethod

    public Node getAt(int position){//StartMethod
    if(position <=size()){
        Node information;
        if(position==1){
            information = head;
        }else{
            Node temporalNode;
            temporalNode = head;
            for (int f = 1 ; f <= position - 2 ; f++)
                temporalNode = temporalNode.getNext();
            Node nextNode = temporalNode.getNext();
            information = nextNode;
        }
        return information;
    }else
        return null;

    }

  //Gives the size of the list as an integer
            public int size() //StartMethod
            {
                int Size = 0;
                Node temporalNode = head;
                while (temporalNode != null)
                {
                    temporalNode = temporalNode.getNext();
                    Size++;
                }
                return Size;
            }
            //End of size method

            //Returns a boolean to see if the list is empty
            public Boolean empty() { //StartMethod
                return head == null;
            } //StartMethod
            //End of empty method

                        //Print the list
            public void print() //StartMethod
            {
                Node temporalNode = head;
                System.out.println("Printing list");
                while (temporalNode != null)
                {
                    System.out.println("Number 1= "+temporalNode.getNumber1() + "Number 2= " +temporalNode.getNumber2()+'\n');
                    temporalNode = temporalNode.getNext();
                }
            }
        //End of print method
}//EndClass