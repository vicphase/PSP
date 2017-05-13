//Added
package Program3.main;

import Program1.Inputs.MyFileReader;
import Program1.math.Calculator;
import Program3.collections.List;

import java.util.Scanner;

/**
 * Created by Víctor Martínez on 2/27/2017 at 8:26 PM.
 * Description: run psp program 3
 */

public class Main {//StartClass

public static void main (String args[]){//StartMethod

    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter Xk");
    double xk=scanner.nextDouble();
    MyFileReader myFileReader = new MyFileReader();
    List list = myFileReader.readTwoNumbersFromFile("C:\\Users\\Victor\\Desktop\\test.txt");
    Calculator calculator = new Calculator();
    calculator.calculateLinearRegressionB1(list);
    calculator.calculateLinearRegressionB0(list);
    calculator.calculateCoefficientrxy(list);
    calculator.calculateCoefficientr2();
    calculator.calculateEstimateyk(xk);
    System.out.println(calculator.toString());
    }

}
//EndClass