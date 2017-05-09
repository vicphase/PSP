//Added

package Program5.main;

import Program5.math.IntegralCalculator;

import java.util.Scanner;

/**
 * Created by Víctor Martínez on 5/2/2017 at 6:07 PM.
 * Description:
 */
public class Main { //StartClass

    public static void main (String args[]){ //StartMethod
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type x");
        double x=scanner.nextDouble();
        System.out.println("Type dof");
        double dof = scanner.nextDouble();
        IntegralCalculator integralCalculator = new IntegralCalculator();
        integralCalculator.setX(x);
        integralCalculator.setDof(dof);
      //  integralCalculator.calculateResult();
        System.out.println("Result p= "+integralCalculator.getP());
    }

}
//EndClass
