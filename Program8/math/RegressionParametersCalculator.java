//Added
package Program8.math;

import Program1.collections.List;
import Program1.math.Calculator;
import Program5.math.IntegralCalculator;

/**
 * Created by Víctor Martínez on 5/11/2017 at 6:08 PM.
 * Description:
 */
public class RegressionParametersCalculator {//StartClass

    private List w;
    private List x;
    private List y;
    private List z;
    private double wk;
    private double xk;
    private double yk;
    private double zk;
    private double B0;
    private double B1;
    private double B2;
    private double B3;
    private double standardDeviation;
    private double range;
    private double Upl;
    private double LPI;
    private double linearEquationNumbers[][];

    public RegressionParametersCalculator() {//StartMethod
    }

    public List getW() {//StartMethod
        return w;
    }

    public void setW(List w) {//StartMethod
        this.w = w;
    }

    public List getX() {//StartMethod
        return x;
    }

    public void setX(List x) {//StartMethod
        this.x = x;
    }

    public List getY() {//StartMethod
        return y;
    }

    public void setY(List y) {//StartMethod
        this.y = y;
    }

    public List getZ() {//StartMethod
        return z;
    }

    public void setZ(List z) {//StartMethod
        this.z = z;
    }

    public double getWk() {//StartMethod
        return wk;
    }

    public void setWk(double wk) {//StartMethod
        this.wk = wk;
    }

    public double getXk() {//StartMethod
        return xk;
    }

    public void setXk(double xk) {//StartMethod
        this.xk = xk;
    }

    public double getYk() {//StartMethod
        return yk;
    }

    public void setYk(double yk) {//StartMethod
        this.yk = yk;
    }

    public double getZk() {//StartMethod
        return zk;
    }

    public void setZk(double zk) {//StartMethod
        this.zk = zk;
    }

    public double getB0() {//StartMethod
        return B0;
    }

    public void setB0(double b0) {//StartMethod
        B0 = b0;
    }

    public double getB1() {//StartMethod
        return B1;
    }

    public void setB1(double b1) {//StartMethod
        B1 = b1;
    }

    public double getB2() {//StartMethod
        return B2;
    }

    public void setB2(double b2) {//StartMethod
        B2 = b2;
    }

    public double getB3() {//StartMethod
        return B3;
    }

    public void setB3(double b3) {//StartMethod
        B3 = b3;
    }

    public double getStandardDeviation() {//StartMethod
        return standardDeviation;
    }

    public void setStandardDeviation(double standardDeviation) {//StartMethod
        this.standardDeviation = standardDeviation;
    }

    public double getRange() {//StartMethod
        return range;
    }

    public void setRange(double range) {//StartMethod
        this.range = range;
    }

    public double getUpl() {//StartMethod
        return Upl;
    }

    public void setUpl(double upl) {//StartMethod
        Upl = upl;
    }

    public double getLPI() {//StartMethod
        return LPI;
    }

    public void setLPI(double LPI) {//StartMethod
        this.LPI = LPI;
    }

    public double[][] getLinearEquationNumbers() {//StartMethod
        return linearEquationNumbers;
    }

    public void setLinearEquationNumbers(double[][] linearEquationNumbers) {//StartMethod
        this.linearEquationNumbers = linearEquationNumbers;
    }

    public void calculateLinearEquationNumbers(){//StartMethod
        Calculator calculator = new Calculator();
        double matrix[][]= new double[4][5];
        matrix[0][0]=getW().size();
        matrix[0][1]=calculator.summatory(getW(),null,1);
        matrix[0][2]=calculator.summatory(getX(),null,1);
        matrix[0][3]=calculator.summatory(getY(),null,1);
        matrix[0][4]=calculator.summatory(getZ(),null,1);
        matrix[1][0]=calculator.summatory(getW(),null,1);
        matrix[1][1]=calculator.summatory(getW(),null,2);
        matrix[1][2]=calculator.summatory(getX(),getW(),1);
        matrix[1][3]=calculator.summatory(getY(),getW(),1);
        matrix[1][4]=calculator.summatory(getZ(),getW(),1);
        matrix[2][0]=calculator.summatory(getX(),null,1);
        matrix[2][1]=calculator.summatory(getW(),getX(),1);
        matrix[2][2]=calculator.summatory(getX(),null,2);
        matrix[2][3]=calculator.summatory(getY(),getX(),1);
        matrix[2][4]=calculator.summatory(getZ(),getX(),1);
        matrix[3][0]=calculator.summatory(getY(),null,1);
        matrix[3][1]=calculator.summatory(getW(),getY(),1);
        matrix[3][2]=calculator.summatory(getX(),getY(),1);
        matrix[3][3]=calculator.summatory(getY(),null,2);
        matrix[3][4]=calculator.summatory(getZ(),getY(),1);
        setLinearEquationNumbers(matrix);
    }

    public void calculateGauss() {//StartMethod

        double linearEquationNumbers[][] = getLinearEquationNumbers();
        double pivot1 = linearEquationNumbers[0][0];
        double opEaE1Col = linearEquationNumbers[1][0] * (-1);
        double opEaE2Col = linearEquationNumbers[2][0] * (-1);
        double opEaE3Col = linearEquationNumbers[3][0] * (-1);

        if (pivot1 > 0) {

            for (int i = 0; i < 5; i++)
                linearEquationNumbers[0][i] = linearEquationNumbers[0][i] * (1 / pivot1);
        }

        if (pivot1 < 0) {

            for (int i = 0; i < 5; i++) {
                linearEquationNumbers[0][i] = linearEquationNumbers[0][i] * (-1 / pivot1);
            }
        }
        double Aux[] = {
                linearEquationNumbers[0][0] * opEaE1Col + linearEquationNumbers[1][0],
                linearEquationNumbers[0][1] * opEaE1Col + linearEquationNumbers[1][1],
                linearEquationNumbers[0][2] * opEaE1Col + linearEquationNumbers[1][2],
                linearEquationNumbers[0][3] * opEaE1Col + linearEquationNumbers[1][3],
                linearEquationNumbers[0][4] * opEaE1Col + linearEquationNumbers[1][4]};


        linearEquationNumbers[1][0] = Aux[0];
        linearEquationNumbers[1][1] = Aux[1];
        linearEquationNumbers[1][2] = Aux[2];
        linearEquationNumbers[1][3] = Aux[3];
        linearEquationNumbers[1][4] = Aux[4];

        for (int i = 0; i < Aux.length; i++)
            Aux[i] = 0;

        Aux[0] = linearEquationNumbers[0][0] * opEaE2Col + linearEquationNumbers[2][0];
        Aux[1] = linearEquationNumbers[0][1] * opEaE2Col + linearEquationNumbers[2][1];
        Aux[2] = linearEquationNumbers[0][2] * opEaE2Col + linearEquationNumbers[2][2];
        Aux[3] = linearEquationNumbers[0][3] * opEaE2Col + linearEquationNumbers[2][3];
        Aux[4] = linearEquationNumbers[0][4] * opEaE2Col + linearEquationNumbers[2][4];

        linearEquationNumbers[2][0] = Aux[0];
        linearEquationNumbers[2][1] = Aux[1];
        linearEquationNumbers[2][2] = Aux[2];
        linearEquationNumbers[2][3] = Aux[3];
        linearEquationNumbers[2][4] = Aux[4];

        for (int i = 0; i < Aux.length; i++)
            Aux[i] = 0;

        Aux[0] = linearEquationNumbers[0][0] * opEaE3Col + linearEquationNumbers[3][0];
        Aux[1] = linearEquationNumbers[0][1] * opEaE3Col + linearEquationNumbers[3][1];
        Aux[2] = linearEquationNumbers[0][2] * opEaE3Col + linearEquationNumbers[3][2];
        Aux[3] = linearEquationNumbers[0][3] * opEaE3Col + linearEquationNumbers[3][3];
        Aux[4] = linearEquationNumbers[0][4] * opEaE3Col + linearEquationNumbers[3][4];

        linearEquationNumbers[3][0] = Aux[0];
        linearEquationNumbers[3][1] = Aux[1];
        linearEquationNumbers[3][2] = Aux[2];
        linearEquationNumbers[3][3] = Aux[3];
        linearEquationNumbers[3][4] = Aux[4];

        double pivot2 = linearEquationNumbers[1][1];
        double opEaE1Col2 = linearEquationNumbers[2][1] * (-1);
        double opEaE2Col2 = linearEquationNumbers[3][1] * (-1);

        if (pivot2 > 0)
            for (int i = 0; i < 5; i++)
                linearEquationNumbers[1][i] = linearEquationNumbers[1][i] * (1 / pivot2);

        if (pivot2 < 0)
            for (int i = 0; i < 5; i++)
                linearEquationNumbers[1][i] = linearEquationNumbers[1][i] * (-1 / pivot2);

        Aux[0] = linearEquationNumbers[1][0] * opEaE1Col2 + linearEquationNumbers[2][0];
        Aux[1] = linearEquationNumbers[1][1] * opEaE1Col2 + linearEquationNumbers[2][1];
        Aux[2] = linearEquationNumbers[1][2] * opEaE1Col2 + linearEquationNumbers[2][2];
        Aux[3] = linearEquationNumbers[1][3] * opEaE1Col2 + linearEquationNumbers[2][3];
        Aux[4] = linearEquationNumbers[1][4] * opEaE1Col2 + linearEquationNumbers[2][4];

        linearEquationNumbers[2][0] = Aux[0];
        linearEquationNumbers[2][1] = Aux[1];
        linearEquationNumbers[2][2] = Aux[2];
        linearEquationNumbers[2][3] = Aux[3];
        linearEquationNumbers[2][4] = Aux[4];

        for (int i = 0; i < Aux.length; i++)
            Aux[i] = 0;

        Aux[0] = linearEquationNumbers[1][0] * opEaE2Col2 + linearEquationNumbers[3][0];
        Aux[1] = linearEquationNumbers[1][1] * opEaE2Col2 + linearEquationNumbers[3][1];
        Aux[2] = linearEquationNumbers[1][2] * opEaE2Col2 + linearEquationNumbers[3][2];
        Aux[3] = linearEquationNumbers[1][3] * opEaE2Col2 + linearEquationNumbers[3][3];
        Aux[4] = linearEquationNumbers[1][4] * opEaE2Col2 + linearEquationNumbers[3][4];

        linearEquationNumbers[3][0] = Aux[0];
        linearEquationNumbers[3][1] = Aux[1];
        linearEquationNumbers[3][2] = Aux[2];
        linearEquationNumbers[3][3] = Aux[3];
        linearEquationNumbers[3][4] = Aux[4];

        for (int i = 0; i < Aux.length; i++)
            Aux[i] = 0;


        double pivot3 = linearEquationNumbers[2][2];
        double opEaE1Col3 = linearEquationNumbers[3][2] * (-1);

        if (pivot3 > 0)
            for (int i = 0; i < 5; i++)
                linearEquationNumbers[2][i] = linearEquationNumbers[2][i] * (1 / pivot3);


        if (pivot3 < 0)
            for (int i = 0; i < 5; i++)
                linearEquationNumbers[2][i] = linearEquationNumbers[2][i] * (-1 / pivot3);


        Aux[0] = linearEquationNumbers[2][0] * opEaE1Col3 + linearEquationNumbers[3][0];
        Aux[1] = linearEquationNumbers[2][1] * opEaE1Col3 + linearEquationNumbers[3][1];
        Aux[2] = linearEquationNumbers[2][2] * opEaE1Col3 + linearEquationNumbers[3][2];
        Aux[3] = linearEquationNumbers[2][3] * opEaE1Col3 + linearEquationNumbers[3][3];
        Aux[4] = linearEquationNumbers[2][4] * opEaE1Col3 + linearEquationNumbers[3][4];


        linearEquationNumbers[3][0] = Aux[0];
        linearEquationNumbers[3][1] = Aux[1];
        linearEquationNumbers[3][2] = Aux[2];
        linearEquationNumbers[3][3] = Aux[3];
        linearEquationNumbers[3][4] = Aux[4];

        for (int i = 0; i < Aux.length; i++)
            Aux[i] = 0;

        double pivot4 = linearEquationNumbers[3][3];

        if (pivot4 > 0)
            for (int i = 0; i < 5; i++)
                linearEquationNumbers[3][i] = linearEquationNumbers[3][i] * (1 / pivot4);

        if (pivot4 < 0)
            for (int i = 0; i < 5; i++)
                linearEquationNumbers[3][i] = linearEquationNumbers[3][i] * (-1 / pivot4);


        double Beta3 = linearEquationNumbers[3][4];
        double Beta2 = linearEquationNumbers[2][4] + ((linearEquationNumbers[2][3] * -1) * Beta3);
        double Beta1 = linearEquationNumbers[1][4] + ((linearEquationNumbers[1][3] * -1) * Beta3) + ((linearEquationNumbers[1][2] * -1) * Beta2);
        double Beta0 = linearEquationNumbers[0][4] + ((linearEquationNumbers[0][3] * -1) * Beta3) + ((linearEquationNumbers[0][2] * -1) * Beta2) + ((linearEquationNumbers[0][1] * -1) * Beta1);

        setB0(Beta0);
        setB1(Beta1);
        setB2(Beta2);
        setB3(Beta3);

    }

    public double uglyFormula(){//StartMethod
        Calculator calculator = new Calculator();
        double wAvg=calculator.calculateMeanConservingList(getW());
        double xAvg=calculator.calculateMeanConservingList(getX());
        double yAvg=calculator.calculateMeanConservingList(getY());

        return Math.sqrt(1+(1.0/getW().size())+
                (Math.pow(getWk()-wAvg,2)/calculator.summatoryMinusAverageSquare(getW(),wAvg))+
                (Math.pow(getXk()-xAvg,2)/calculator.summatoryMinusAverageSquare(getX(),xAvg))+
                (Math.pow(getYk()-yAvg,2)/calculator.summatoryMinusAverageSquare(getY(),yAvg))
        );
    }

    public void calculateStandardDeviation(){//StartMethod
        double sum=0;
        for(int i=1;i<=getW().size();i++){
            sum+=Math.pow(getZ().getAt(i).getData()-getB0()-getB1()*getW().getAt(i).getData()-getB2()*getX().getAt(i).getData()-getB3()*getY().getAt(i).getData(),2);
        }
        double variance = (1.0/(getW().size()-4))*sum;
        setStandardDeviation(Math.sqrt(variance));
    }

    public void calculateRange(){//StartMethod
        IntegralCalculator integralCalculator = new IntegralCalculator();
        integralCalculator.setDof(getW().size()-4);
        integralCalculator.setP(0.35);
        integralCalculator.calculateUpperLimitOfIntegration();
        setRange(integralCalculator.getX()*getStandardDeviation()*uglyFormula());
    }

    public void calculateZK(){//StartMethod
        setZk(getB0()+getWk()*getB1()+getXk()*getB2()+getYk()*getB3());
    }

    @Override
    public String toString() {//StartMethod
        return "RegressionParametersCalculator{" + '\n' +
                "w=" + w.toString() + '\n' +
                ", x=" + x.toString() + '\n' +
                ", y=" + y.toString() + '\n' +
                ", z=" + z.toString() + '\n' +
                ", wk=" + wk + '\n' +
                ", xk=" + xk + '\n' +
                ", yk=" + yk + '\n' +
                ", zk=" + zk + '\n' +
                ", B0=" + B0 + '\n' +
                ", B1=" + B1 + '\n' +
                ", B2=" + B2 + '\n' +
                ", B3=" + B3 + '\n' +
                ", standardDeviation=" + standardDeviation + '\n' +
                ", range=" + range + '\n' +
                ", Upl=" + Upl + '\n' +
                ", LPI=" + LPI + '\n' +
                '}';
    }
}//EndClass
