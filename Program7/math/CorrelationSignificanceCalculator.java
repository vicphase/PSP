//Added
package Program7.math;

import Program1.math.Calculator;
import Program3.collections.List;
import Program5.math.IntegralCalculator;

/**
 * Created by Víctor Martínez on 5/9/2017 at 8:17 PM.
 * Description:
 */
public class CorrelationSignificanceCalculator {//StartClass
    private double x;
    private Calculator calculator;
    private IntegralCalculator integralCalculator;
    private double n;
    private double tailArea;
    private double range;
    private double upi;
    private double lpi;
    private double standardDeviation;
    private double t;
    private List setOfNumbers;
    private double xk;

    public CorrelationSignificanceCalculator() {//StartMethod
        setCalculator(new Calculator());
        setIntegralCalculator(new IntegralCalculator());
    }

    public double getX() { //StartMethod
        return x;
    }

    public void setX(double x) { //StartMethod
        this.x = x;
    }

    public Calculator getCalculator() { //StartMethod
        return calculator;
    }

    public void setCalculator(Calculator calculator) { //StartMethod
        this.calculator = calculator;
    }

    public IntegralCalculator getIntegralCalculator() { //StartMethod
        return integralCalculator;
    }

    public void setIntegralCalculator(IntegralCalculator integralCalculator) { //StartMethod
        this.integralCalculator = integralCalculator;
    }

    public double getN() { //StartMethod
        return n;
    }

    public void setN(double n) { //StartMethod
        this.n = n;
    }

    public double getTailArea() { //StartMethod
        return tailArea;
    }

    public void setTailArea(double tailArea) { //StartMethod
        this.tailArea = tailArea;
    }

    public double getRange() { //StartMethod
        return range;
    }

    public void setRange(double range) { //StartMethod
        this.range = range;
    }

    public double getUpi() { //StartMethod
        return upi;
    }

    public void setUpi(double upi) { //StartMethod
        this.upi = upi;
    }

    public double getLpi() { //StartMethod
        return lpi;
    }

    public void setLpi(double lpi) { //StartMethod
        this.lpi = lpi;
    }

    public double getStandardDeviation() { //StartMethod
        return standardDeviation;
    }

    public void setStandardDeviation(double standardDeviation) { //StartMethod
        this.standardDeviation = standardDeviation;
    }

    public double getT() { //StartMethod
        return t;
    }

    public void setT(double t) { //StartMethod
        this.t = t;
    }

    public List getSetOfNumbers() { //StartMethod
        return setOfNumbers;
    }

    public void setSetOfNumbers(List setOfNumbers) { //StartMethod
        this.setOfNumbers = setOfNumbers;
    }

    public double getXk() { //StartMethod
        return xk;
    }

    public void setXk(double xk) { //StartMethod
        this.xk = xk;
    }

    public void calculateCorrelationSignificance(){ //StartMethod
        x();
        //Step 2
        getIntegralCalculator().setDof(getN()-2);
        getIntegralCalculator().setX(getX());
        getIntegralCalculator().setP(getIntegralCalculator().calculateP());
        //Step 3
        setTailArea(1-2*getIntegralCalculator().getP());
        // Step 4
        calculateRange();
        // Step 5
        getCalculator().calculateEstimateyk(getXk());
        setUpi(getCalculator().getEstimateyk()+getRange());
        // Step 6
        setLpi(getCalculator().getEstimateyk()-getRange());
    }

    public void x(){ //StartMethod
        getCalculator().calculateCoefficientrxy(getSetOfNumbers());
        getCalculator().calculateCoefficientr2();
        setN(getSetOfNumbers().size());
        setX((Math.abs(getCalculator().getCoefficientrxy())*Math.sqrt(getN()-2))/Math.sqrt(1-Math.pow(getCalculator().getCoefficientrxy(),2)));
    }

    public void calculateRange(){ //StartMethod
        calculateStandardDeviation();
        getIntegralCalculator().setDof(getN()-2);
        getIntegralCalculator().setP(0.35);
        getIntegralCalculator().calculateUpperLimitOfIntegration();
        setRange(getIntegralCalculator().getX()*getStandardDeviation()*uglyFormula());
    }

    public double uglyFormula(){ //StartMethod
        Program1.collections.List temporalList = new Program1.collections.List();
        double averageX;
        for(int i=1;i<=getSetOfNumbers().size();i++){
            temporalList.add(i,getSetOfNumbers().getAt(i).getNumber1());
        }

        averageX=getCalculator().calculateMean(temporalList);

        for(int i=1;i<=getSetOfNumbers().size();i++){
            temporalList.addLast(getSetOfNumbers().getAt(i).getNumber1());
        }

        double summation=0;

        for(int i=1;i<=getSetOfNumbers().size();i++){
            summation+=Math.pow(getSetOfNumbers().getAt(i).getNumber1()-averageX,2);
        }

        return Math.sqrt(1+(1/getN())+((Math.pow((getXk()-averageX),2))/summation));

    }

    public void calculateStandardDeviation(){ //StartMethod
        getCalculator().calculateLinearRegressionB1(getSetOfNumbers());
        getCalculator().calculateLinearRegressionB0(getSetOfNumbers());
        double sum = 0;
        for(int i=1;i<=getSetOfNumbers().size();i++){
           sum+=Math.pow(getSetOfNumbers().getAt(i).getNumber2()-getCalculator().getLinearRegressionB0()-(getCalculator().getLinearRegressionB1()*getSetOfNumbers().getAt(i).getNumber1()),2);
        }
        setStandardDeviation(Math.sqrt((1/(getN()-2))*sum));
    }

    @Override
    public String toString() { //StartMethod
        return "CorrelationSignificanceCalculator{" + '\n' +
                "Rxy=" + getCalculator().getCoefficientrxy() + '\n' +
                "R2=" + getCalculator().getCoefficientr2() + '\n' +
                "TailArea=" + tailArea + '\n' +
                "B0=" + getCalculator().getLinearRegressionB0() + '\n' +
                "B1=" + getCalculator().getLinearRegressionB1() + '\n' +
                "Yk=" + getCalculator().getEstimateyk() + '\n' +
                "Range=" + range + '\n' +
                "Upi=" + upi + '\n' +
                "Lpi=" + lpi + '\n' +
                '}';
    }
}
//EndClass