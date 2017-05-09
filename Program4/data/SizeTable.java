//Added
package Program4.data;

/**
 * Created by Víctor Martínez on 3/12/2017 at 2:03 PM.
 * Description:
 */
public class SizeTable { //StartClass

    private double vs;
    private  double s;
    private double m;
    private double l;
    private double vl;
    private double logMean;
    private double variance;
    private double standardDesviation;

    public SizeTable() { //StartMethod
    }

    public double getVs() { //StartMethod
        return vs;
    }

    public void setVs(double vs) { //StartMethod
        this.vs = vs;
    }

    public double getS() { //StartMethod
        return s;
    }

    public void setS(double s) { //StartMethod
        this.s = s;
    }

    public double getM() { //StartMethod
        return m;
    }

    public void setM(double m) { //StartMethod
        this.m = m;
    }

    public double getL() { //StartMethod
        return l;
    }

    public void setL(double l) { //StartMethod
        this.l = l;
    }

    public double getVl() { //StartMethod
        return vl;
    }

    public void setVl(double vl) { //StartMethod
        this.vl = vl;
    }

    public double getLogMean() { //StartMethod
        return logMean;
    }

    public void setLogMean(double logMean) { //StartMethod
        this.logMean = logMean;
    }

    public double getVariance() { //StartMethod
        return variance;
    }

    public void setVariance(double variance) { //StartMethod
        this.variance = variance;
    }

    public double getStandardDesviation() { //StartMethod
        return standardDesviation;
    }

    public void setStandardDesviation(double standardDesviation) { //StartMethod
        this.standardDesviation = standardDesviation;
    }

    public void calculateLogarithmicRanges(){ //StartMethod
        this.vs=Math.pow(Math.E, getLogMean()-(2*getStandardDesviation()));
        this.s=Math.pow(Math.E, getLogMean()-getStandardDesviation());
        this.m=Math.pow(Math.E, getLogMean());
        this.l=Math.pow(Math.E, getLogMean()+getStandardDesviation());
        this.vl=Math.pow(Math.E, getLogMean()+(2*getStandardDesviation()));
    }

    @Override
    public String toString() { //StartMethod
        return "SizeTable{" + '\n'+
                "vs=" + vs + '\n'+
                "s=" + s + '\n'+
                "m=" + m + '\n'+
                "l=" + l + '\n'+
                "vl=" + vl + '\n'+
                '}';
    }
}
//EndClass
