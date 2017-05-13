//Added
package Program8.main;

import Program1.Inputs.MyFileReader;
import Program8.math.RegressionParametersCalculator;

import java.util.Scanner;

/**
 * Created by Víctor Martínez on 5/11/2017 at 6:08 PM.
 * Description:
 */
public class Main {//StartClass
    public static void main(String args[]){//StartMethod
        RegressionParametersCalculator regressionParametersCalculator = new RegressionParametersCalculator();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type wk");
        double wk=scanner.nextDouble();
        regressionParametersCalculator.setWk(wk);
        System.out.println("Type xk");
        double xk=scanner.nextDouble();
        regressionParametersCalculator.setXk(xk);
        System.out.println("Type yk");
        double yk=scanner.nextDouble();
        regressionParametersCalculator.setYk(yk);
        MyFileReader myFileReader = new MyFileReader();
        regressionParametersCalculator.setW(myFileReader.readNumbersFromFileAt("C:\\Users\\Victor\\Desktop\\test.txt",0));
        regressionParametersCalculator.setX(myFileReader.readNumbersFromFileAt("C:\\Users\\Victor\\Desktop\\test.txt",1));
        regressionParametersCalculator.setY(myFileReader.readNumbersFromFileAt("C:\\Users\\Victor\\Desktop\\test.txt",2));
        regressionParametersCalculator.setZ(myFileReader.readNumbersFromFileAt("C:\\Users\\Victor\\Desktop\\test.txt",3));
        regressionParametersCalculator.calculateLinearEquationNumbers();
        regressionParametersCalculator.calculateGauss();
        regressionParametersCalculator.calculateStandardDeviation();
        regressionParametersCalculator.calculateRange();
        regressionParametersCalculator.calculateZK();
        regressionParametersCalculator.setUpl(regressionParametersCalculator.getZk()+regressionParametersCalculator.getRange());
        regressionParametersCalculator.setLPI(regressionParametersCalculator.getZk()-regressionParametersCalculator.getRange());
        System.out.println(regressionParametersCalculator.toString());
    }

}//EndClass
