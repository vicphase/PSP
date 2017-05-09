package Program2.main;

import Program2.lineCounter.LineCounter;

/**
 * Created by Víctor Martínez on 2/16/2017 at 6:07 PM.
 * Description: used to run PSP program 2
 */
//Added
public class Main {//StartClass

    public static void main (String args[]){//StartMethod

        LineCounter lineCounter = new LineCounter();
        lineCounter.setFileName("C:\\Users\\Victor\\Desktop\\test.txt");
        lineCounter.countLines();
        lineCounter.print();

    }//EndMethod

}//EndClass