package Program2.main;

import Program2.lineCounter.LineCounter;

/**
 * Created by Víctor Martínez on 2/16/2017 at 6:07 PM.
 * Description: class used to run PSP program 2
 */
//Executes PSP program 2
public class Main {//StartClass

    public static void main (String args[]){//StartMethod

        LineCounter lineCounter = new LineCounter();
        lineCounter.setFileName("C:\\Users\\Victor\\Desktop\\Program2.java");
        lineCounter.countLines();
        lineCounter.print();

    }//EndMethod

}//EndClass
