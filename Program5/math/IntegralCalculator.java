//Added
package Program5.math;

import static java.lang.StrictMath.abs;

/**
 * Created by Víctor Martínez on 5/2/2017 at 6:07 PM.
 * Description:
 */
public class IntegralCalculator { //StartClass

    private double x;
    private double dof;
    private double num_seg;
    private double W;
    private double E;
    private double p;

    public IntegralCalculator() { //StartMethod
        setNum_seg(10);
        setE(.00001);
    }

    public double getX() { //StartMethod
        return x;
    }

    public void setX(double x) { //StartMethod
        this.x = x;
    }

    public double getDof() { //StartMethod
        return dof;
    }

    public void setDof(double dof) { //StartMethod
        this.dof = dof;
    }

    public double getNum_seg() { //StartMethod
        return num_seg;
    }

    public void setNum_seg(double num_seg) { //StartMethod
        this.num_seg = num_seg;
    }

    public double getW() { //StartMethod
        return W;
    }

    public void setW(double w) { //StartMethod
        this.W = w;
    }

    public double getE() { //StartMethod
        return E;
    }

    public void setE(double e) { //StartMethod
        E = e;
    }

    public double getP() { //StartMethod
        return p;
    }

    public void setP(double p) { //StartMethod
        this.p = p;
    }

    public double calculateP(){ //StartMethod
        double newP=0;
        double oldP=Integer.MAX_VALUE;
        while(oldP-newP>getE()){
            oldP=integrate();
            setNum_seg(getNum_seg()+10);
            newP=integrate();
        }
        return newP;
    }

    public double integrate(){ //StartMethod
        setW(getX()/getNum_seg());
        return (getW()/3)*(F(0)+firstSummatory()+secondSummatory()+F(getX()));
    }

    public double firstSummatory(){ //StartMethod
        double result=0;
       for(int i=1;i<=getNum_seg()-1;i+=2){
         result+=4*F(i*getW());
       }
       return result;
    }

    public double secondSummatory(){ //StartMethod
        double result=0;
        for(int i=2;i<=getNum_seg()-2;i+=2){
            result+=2*F(i*getW());
        }
        return result;
    }

    public double F(double x){ //StartMethod
      return  (gamma((getDof()+1)/2) / (Math.sqrt(getDof()*Math.PI)*gamma(getDof()/2))) * Math.pow(1+(Math.pow(x,2)/getDof()),-(getDof()+1)/2);
    }



    public static double logGamma(double x) { //StartMethod
        double tmp = (x - 0.5) * Math.log(x + 4.5) - (x + 4.5);
        double ser = 1.0 + 76.18009173    / (x + 0)   - 86.50532033    / (x + 1)
                + 24.01409822    / (x + 2)   -  1.231739516   / (x + 3)
                +  0.00120858003 / (x + 4)   -  0.00000536382 / (x + 5);
        return tmp + Math.log(ser * Math.sqrt(2 * Math.PI));
    }

    public static double gamma(double x) { //StartMethod
        return Math.exp(logGamma(x));
    }

    public void calculateUpperLimitOfIntegration(){
        //Start with a trial value of x (for example 1)
        setX(1);
        double temporalP,error;
        temporalP = calculateP();
        error=temporalP-getP();
        while((abs(error)>getE())) {
            //Make an initial integral and test to see if it gives the proper value; if not, continue.
            temporalP = calculateP();
            error=temporalP-getP();
                //IF P is too low
            if((abs(error)>getE())){
                if (temporalP < getP()) {
                    setX(getX() + (getX() / 2.0));
                } else {
                    //IF P is too high
                    if (temporalP > getP()) {
                        setX(getX() - (getX() / 2.0));
                    }
                }
            }
           // System.out.println(temporalP + " " + getX() + " " + (temporalP - getP()));
            }

            }



    @Override
    public String toString() { //StartMethod
        return "IntegralCalculator{" + '\n'+
                "x=" + x + '\n'+
                ", dof=" + dof + '\n'+
                ", num_seg=" + num_seg + '\n'+
                ", W=" + W + '\n'+
                ", E=" + E + '\n'+
                ", p=" + p + '\n'+
                '}';
    }
}
//EndClass
