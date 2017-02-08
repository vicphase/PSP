package Program1.math;


import Program1.collections.List;

/**
 * Created by Víctor Martínez on 1/29/2017 at 4:43 PM.
 */

public class Calculator {
    
    private double mean;
    private double standardDeviation;

    public Calculator() {
    }

    public double getMean() {
        return mean;
    }

    public void setMean(double mean) {
        this.mean = mean;
    }

    public double getStandardDeviation() {
        return standardDeviation;
    }

    public void setStandardDeviation(double standardDeviation) {
        this.standardDeviation = standardDeviation;
    }
    
    public void calculateMean(List list){
        double total=0;
        int n=0;
        
        while(!list.empty()){
            total+=list.removeFirst();
                    n++;
        }
        
        this.setMean(total/n);
        
    }
    
    public void calculateStandardDeviation(List list){
        
        double summation=0;
        double n = list.size();
        
        while(!list.empty()){
            summation+=Math.pow((list.removeFirst()-this.mean),2);
        }
        
        this.standardDeviation=Math.sqrt(summation/(n-1));
       
    }
    
}
