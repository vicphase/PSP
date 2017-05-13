//Base
package Program1.math;
import Program1.collections.List;
import Program3.collections.Node;
/**
 * Created by Víctor Martínez on 1/29/2017 at 4:43.
 * Description: make math calculations
 */
public class Calculator {//StartClass
    
    private double mean;
    private double standardDeviation;
    private double linearRegressionB0;
    private double linearRegressionB1;
    private double coefficientrxy;
    private double coefficientr2;
    private double estimateyk;

    public Calculator() {//StartMethod
    }

    public double getMean() {//StartMethod
        return mean;
    }

    public void setMean(double mean) {//StartMethod
        this.mean = mean;
    }

    public double getStandardDeviation() {//StartMethod
        return standardDeviation;
    }

    public void setStandardDeviation(double standardDeviation) {//StartMethod
        this.standardDeviation = standardDeviation;
    }

    public double getLinearRegressionB0() {//StartMethod
        return linearRegressionB0;
    }

    public void setLinearRegressionB0(double linearRegressionB0) {//StartMethod
        this.linearRegressionB0 = linearRegressionB0;
    }

    public double getLinearRegressionB1() {//StartMethod
        return linearRegressionB1;
    }

    public void setLinearRegressionB1(double linearRegressionB1) {//StartMethod
        this.linearRegressionB1 = linearRegressionB1;
    }

    public double getCoefficientrxy() {//StartMethod
        return coefficientrxy;
    }

    public void setCoefficientrxy(double coefficientrxy) {//StartMethod
        this.coefficientrxy = coefficientrxy;
    }

    public double getCoefficientr2() {//StartMethod
        return coefficientr2;
    }

    public void setCoefficientr2(double coefficientr2) {//StartMethod
        this.coefficientr2 = coefficientr2;
    }

    public double getEstimateyk() {//StartMethod
        return estimateyk;
    }

    public void setEstimateyk(double estimateyk) {//StartMethod
        this.estimateyk = estimateyk;
    }

    public double calculateMean(List list){//StartMethod
        double total=0;
        int n=0;

        while(!list.empty()){
            total+=list.removeFirst();
            n++;
        }
        this.setMean(total/n);
        return(total/n);

    }//EndMethod

    public double calculateMeanConservingList(List list){//StartMethod
        double total=0;
        
        for(int i=0;i<=list.size();i++)
            total+=list.getAt(i).getData();
        this.setMean(total/list.size());
        return(total/list.size());
        
    }
    
    public void calculateStandardDeviation(List list){//StartMethod
        
        double summation=0;
        double n = list.size();
        
        while(!list.empty()){
            summation+=Math.pow((list.removeFirst()-this.mean),2);
        }
        
        this.standardDeviation=Math.sqrt(summation/(n-1));
       
    }

    public void calculateLinearRegressionB1(Program3.collections.List list){//StartMethod
        double summation=0; //First operation
        double x=0;
        double y=0;
        Node temporalNode;
        for(int i=1;i<=list.size();i++){
            temporalNode = list.getAt(i);
            x=temporalNode.getNumber1();
            y=temporalNode.getNumber2();
            summation+=x*y;
        }

        double multiplication = 0; //Second operation
        double averageX=0;
        List temporalList = new List();
        for(int i=1;i<=list.size();i++){
            temporalList.addLast(list.getAt(i).getNumber1());
        }
        averageX=calculateMean(temporalList);
        double averageY=0;
        for(int i=1;i<=list.size();i++){
            temporalList.addLast(list.getAt(i).getNumber2());
        }
        averageY=calculateMean(temporalList);
        multiplication=list.size()*averageX*averageY;

        double summation2=0; //Third operation
        for(int i=1;i<=list.size();i++){
            x=list.getAt(i).getNumber1();
            summation2+=Math.pow(x,2);
        }

        double multiplication2=0; //Fourth operation
        double number=0;
        double averageX2=0;
        for(int i=1;i<=list.size();i++){
            number = list.getAt(i).getNumber1();
            temporalList.addLast(number);
        }
        averageX2=Math.pow(calculateMean(temporalList),2);
        multiplication2=list.size()*averageX2;

        double answer = (summation-multiplication)/(summation2-multiplication2);
        this.setLinearRegressionB1(answer);

    }

    public void calculateLinearRegressionB0(Program3.collections.List list){//StartMethod
        double averageY=0; //First operation
        List temporalList = new List();
        for(int i=1;i<=list.size();i++){
            temporalList.addLast(list.getAt(i).getNumber2());
        }
        averageY=calculateMean(temporalList);

        double multiplication = 0; //Second operation
        double averageX = 0;
        for(int i=1;i<=list.size();i++){
            temporalList.addLast(list.getAt(i).getNumber1());
        }
        averageX=calculateMean(temporalList);

        multiplication = this.getLinearRegressionB1() * averageX;

        this.setLinearRegressionB0(averageY - multiplication);

    }

    public void calculateCoefficientrxy(Program3.collections.List list){//StartMethod
        double summation=0; //First operation
        double x=0;
        double y=0;
        Node temporalNode;
        for(int i=1;i<=list.size();i++){
            temporalNode = list.getAt(i);
            x=temporalNode.getNumber1();
            y=temporalNode.getNumber2();
            summation+=x*y;
        }
        summation=summation*list.size();

        double multiplication = 0; //Second operation
        double summationx = 0;
        double summationy = 0;
        for(int i=1;i<=list.size();i++){
            temporalNode = list.getAt(i);
            x=temporalNode.getNumber1();
            y=temporalNode.getNumber2();
            summationx+=x;
            summationy+=y;
        }
        multiplication=summationx*summationy;

        double subtraction = 0; //Third operation
        double summationx2=0;
        x=0;
        for(int i=1;i<=list.size();i++){
            x=list.getAt(i).getNumber1();
            summationx2+=Math.pow(x,2);
        }


        subtraction = list.size()*summationx2-Math.pow(summationx,2);

        double subtraction2 = 0; //Fourth
        double summationy2=0;
        y=0;
        for(int i=1;i<=list.size();i++){
            y=list.getAt(i).getNumber2();
            summationy2+=Math.pow(y,2);
        }

        subtraction2 = list.size()*summationy2-Math.pow(summationy,2);

        double answer = 0;

        answer= (summation-multiplication)/Math.sqrt(subtraction*subtraction2);

        this.setCoefficientrxy(answer);

    }

    public void calculateCoefficientr2(){//StartMethod
        this.setCoefficientr2(Math.pow(this.getCoefficientrxy(),2));
    }

    public void calculateEstimateyk(double xk) {//StartMethod
        double answer = 0;
        answer = getLinearRegressionB0() + getLinearRegressionB1()*xk;
        this.setEstimateyk(answer);
    }

    public double calculateLogaritmicMean(List list){//StartMethod
        double total=0;
        int n=0;
        for(int i=0;i<list.size();i++){
            total+=Math.log(list.getAt(i+1).getData());
            n++;
        }
        return(total/n);
    }

    public double calculateVariance(List list, double mean){//StartMethod
        double summation=0;
        for(int i=0;i<list.size();i++){
            summation+=Math.pow((Math.log(list.getAt(i+1).getData())-mean),2);
        }
        return summation/(list.size()-1);
    }

    //Added
    public double summatory(List list1, List list2, int pow){
        double sum=0;
        if(list2==null){
           for(int i=1;i<=list1.size();i++)
               sum+=Math.pow(list1.getAt(i).getData(),pow);
        }else{
            for(int i=1;i<=list1.size();i++)
                sum+=Math.pow(list1.getAt(i).getData()*list2.getAt(i).getData(),pow);
        }
      return sum;
    }

    public double summatoryMinusAverageSquare(List list, double average){
        double sum = 0;
        for(int i=1;i<=list.size();i++)
            sum+=Math.pow(list.getAt(i).getData()-average,2);
        return sum;
    }

    //Base
    @Override
    public String toString() {
        return "Calculator{" +
                "linearRegressionB0=" + linearRegressionB0 + '\n'+
                ", linearRegressionB1=" + linearRegressionB1 + '\n'+
                ", coefficientrxy=" + coefficientrxy + '\n'+
                ", coefficientr2=" + coefficientr2 + '\n'+
                ", estimateyk=" + estimateyk +
                '}';
    }
}//EndClass