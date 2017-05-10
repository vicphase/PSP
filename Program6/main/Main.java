//Added
package Program6.main;

import Program5.math.IntegralCalculator;

import java.util.Scanner;

/**
 * Created by Víctor Martínez on 5/8/2017 at 6:24 PM.
 * Description:
 */
public class Main {//StartClass

    public static void main (String args[]){//StartMethod
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type p");
        double p=scanner.nextDouble();
        System.out.println("Type dof");
        double dof = scanner.nextDouble();
        IntegralCalculator integralCalculator = new IntegralCalculator();
        integralCalculator.setP(p);
        integralCalculator.setDof(dof);
        integralCalculator.calculateUpperLimitOfIntegration();
        System.out.println("Result x= "+integralCalculator.getX());
    }

}//EndClass
