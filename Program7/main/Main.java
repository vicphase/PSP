//Added
package Program7.main;

import Program1.Inputs.MyFileReader;
import Program3.collections.List;
import Program7.math.CorrelationSignificanceCalculator;

import java.util.Scanner;

/**
 * Created by Víctor Martínez on 5/9/2017 at 8:18 PM.
 * Description:
 */
public class Main {//StartClass
    public static void main (String args[]){//StartMethod
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type xk");
        double xk=scanner.nextDouble();
        MyFileReader myFileReader = new MyFileReader();
        List list = myFileReader.readTwoNumbersFromFile("C:\\Users\\Victor\\Desktop\\test.txt");
        CorrelationSignificanceCalculator correlationSignificanceCalculator = new CorrelationSignificanceCalculator();
        correlationSignificanceCalculator.setSetOfNumbers(list);
        correlationSignificanceCalculator.setXk(xk);
        correlationSignificanceCalculator.calculateCorrelationSignificance();
        System.out.println(correlationSignificanceCalculator.toString());
    }
}
//EndClass