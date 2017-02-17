package Program1.math;


import Program1.collections.List;

/**
 * Created by Víctor Martínez on 1/29/2017 at 4:43.
 * Description: class used to make math calculations
 */

public class Calculator {//StartClass
    
    private double mean;
    private double standardDeviation;

    public Calculator() {//StartMethod
    }//EndMethod

    public double getMean() {//StartMethod
        return mean;
    }//EndMethod

    public void setMean(double mean) {//StartMethod
        this.mean = mean;
    }//EndMethod

    public double getStandardDeviation() {//StartMethod
        return standardDeviation;
    }//EndMethod

    public void setStandardDeviation(double standardDeviation) {//StartMethod
        this.standardDeviation = standardDeviation;
    }//EndMethod
    
    public void calculateMean(List list){//StartMethod
        double total=0;
        int n=0;
        
        while(!list.empty()){
            total+=list.removeFirst();
                    n++;
        }
        
        this.setMean(total/n);
        
    }//EndMethod
    
    public void calculateStandardDeviation(List list){//StartMethod
        
        double summation=0;
        double n = list.size();
        
        while(!list.empty()){
            summation+=Math.pow((list.removeFirst()-this.mean),2);
        }
        
        this.standardDeviation=Math.sqrt(summation/(n-1));
       
    }//EndMethod
    
}//EndClass
