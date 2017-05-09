//Added
package Program4.main;

import Program1.Inputs.MyFileReader;
import Program1.collections.List;
import Program1.math.Calculator;
import Program4.data.SizeTable;

/**
 * Created by Víctor Martínez on 3/12/2017 at 2:01 PM.
 * Description:
 */
public class Main { //StartClass

    public static void main (String args[]){ //StartMethod
        MyFileReader fileReader = new MyFileReader();

        List numberList = fileReader.readNumbersAndDivide("C:\\Users\\Victor\\Desktop\\test.txt");
        SizeTable sizeTable = new SizeTable();
        Calculator calculator = new Calculator();
        sizeTable.setLogMean(calculator.calculateLogaritmicMean(numberList));
        sizeTable.setVariance(calculator.calculateVariance(numberList, sizeTable.getLogMean()));
        sizeTable.setStandardDesviation(Math.sqrt(sizeTable.getVariance()));
        sizeTable.calculateLogarithmicRanges();
        System.out.println(sizeTable.toString());
    }

}
//EndClass