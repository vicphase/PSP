package Program1.main;

import Program1.Inputs.MyFileReader;
import Program1.collections.List;
import Program1.math.Calculator;

/**
 * Created by Víctor Martínez on 1/29/2017 at 4:43 PM.
 * Description: class used to run PSP program 1
 */

public class Main {//StartClass

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {//StartMethod
        MyFileReader fileReader = new MyFileReader();
        
        List numbers = fileReader.readNumbersFromFile("C:\\Users\\Victor\\Desktop\\Prueba.txt");
        
        Calculator calculator = new Calculator();
        calculator.calculateMean(numbers);
        numbers = fileReader.readNumbersFromFile("C:\\Users\\Victor\\Desktop\\Prueba.txt");
        calculator.calculateStandardDeviation(numbers);
        
        System.out.println("Mean= "+calculator.getMean());
        System.out.println("Standard Deviation= "+calculator.getStandardDeviation());
        
    }//EndMethod
    
}//EndClass
