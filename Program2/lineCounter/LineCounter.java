package Program2.lineCounter;

import Program1.collections.List;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by Víctor Martínez on 2/16/2017 at 6:02 PM.
 * Description: class that counts lines of code of a program
 */
public class LineCounter {//StartClass

    private int numberOfMethods; //The number of methods of a class
    private LinkedList<Integer> linesPerClass; //The number of lines of code per class
    private LinkedList<String> nameOfClasses; //The name of the different classes of the program
    private LinkedList<Integer> methodPerClass; //The number of methods per class of the program
    private int numberOfClasses; //The total number of classes of the program
    private int totalOfLines; //The total number of lines of the program
    private String fileName; //The name of the file we are going to read
    private int indexOfClass; //Used to know which number of class we are working with
    private int linesOfClass; //The number of lines of the class to insert in the list linesPerClass
    private int methodsOfClass; //The number of methods of the class to insert in the list methodsPerClass

    public LineCounter() {//StartMethod
        this.numberOfClasses=0;
        this.numberOfMethods=0;
        this.totalOfLines=0;
        this.fileName="";
        this.linesPerClass = new LinkedList<>();
        this.nameOfClasses = new LinkedList<>();
        this.methodPerClass = new LinkedList<>();
        this.indexOfClass=0;
        this.linesOfClass=0;
        this.methodsOfClass=0;
    }

    public int getNumberOfMethods() {//StartMethod
        return numberOfMethods;
    }//EndMethod

    public void setNumberOfMethods(int numberOfMethods) {//StartMethod
        this.numberOfMethods = numberOfMethods;
    }//EndMethod

    public LinkedList<Integer> getLinesPerClass() {//StartMethod
        return linesPerClass;
    }//EndMethod

    public void setLinesPerClass(LinkedList<Integer> linesPerClass) {//StartMethod
        this.linesPerClass = linesPerClass;
    }//EndMethod

    public LinkedList<String> getNameOfClasses() {//StartMethod
        return nameOfClasses;
    }//EndMethod

    public void setNameOfClasses(LinkedList<String> nameOfClasses) {//StartMethod
        this.nameOfClasses = nameOfClasses;
    }//EndMethod

    public LinkedList<Integer> getMethodPerClass() {//StartMethod
        return methodPerClass;
    }//EndMethod

    public void setMethodPerClass(LinkedList<Integer> methodPerClass) {//StartMethod
        this.methodPerClass = methodPerClass;
    }//EndMethod

    public int getNumberOfClasses() {//StartMethod
        return numberOfClasses;
    }//EndMethod

    public void setNumberOfClasses(int numberOfClasses) {//StartMethod
        this.numberOfClasses = numberOfClasses;
    }//EndMethod

    public int getTotalOfLines() {//StartMethod
        return totalOfLines;
    }//EndMethod

    public void setTotalOfLines(int totalOfLines) {//StartMethod
        this.totalOfLines = totalOfLines;
    }//EndMethod

    public String getFileName() {//StartMethod
        return fileName;
    }//EndMethod

    public int getIndexOfClass() {//StartMethod
        return indexOfClass;
    }//EndMethod

    public void setIndexOfClass(int indexOfClass) {//StartMethod
        this.indexOfClass = indexOfClass;
    }//EndMethod

    public int getLinesOfClass() {//StartMethod
        return linesOfClass;
    }//EndMethod

    public void setLinesOfClass(int linesOfClass) {//StartMethod
        this.linesOfClass = linesOfClass;
    }//EndMethod

    public void setFileName(String fileName) {//StartMethod
        this.fileName = fileName;
    }//EndMethod

//Counts the logical lines of the file
    public void countLines(){//StartMethod

        BufferedReader br = null;
        FileReader fr = null;
        List list = new List();

        try {

            fr = new FileReader(this.fileName);
            br = new BufferedReader(fr);

            String sCurrentLine;

            br = new BufferedReader(new FileReader(this.fileName));

            while ((sCurrentLine = br.readLine()) != null) {
                this.classifyLine(sCurrentLine);
            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }

    }//EndMethod

//Checks if the lines is going to be counted or not
    public void classifyLine(String line) {//StartMethod

      if (line.length() == 0) {
          return;
       }

        if (line.contains("//Start"+"Class")) {
            nameOfClasses.add(line.trim());
            this.numberOfClasses++;
        }

        if (line.contains("//EndClass")) {
            this.linesOfClass = 0;
            this.indexOfClass++;
            this.methodsOfClass = 0;
        }

        if (line.contains("//StartMethod")) {
            this.methodPerClass.add(indexOfClass, ++methodsOfClass);
            this.numberOfMethods++;
        }

        if(line.contains("while") ||
           line.contains("else") ||
           line.contains("null") ||
           line.contains("if") ||
           line.contains("System") ||
           line.contains("catch") ||
           line.contains("try") ||
           line.contains("return") ||
           line.contains("finally") ||
           line.contains("()") ||
           line.contains("do") ||
           line.contains("switch") ||
           line.contains("private") ||
           line.contains("public") ||
           line.contains("class") ||
           line.contains("+") ||
           line.contains("=") ||
           line.contains(";")
                ){
            this.totalOfLines++;
            this.linesPerClass.add(indexOfClass, ++linesOfClass);
        }
    }//EndMethod

    public void print(){ //StartMethod
        for(int i=0;i<numberOfClasses;i++){
            System.out.println("Name of class: "+nameOfClasses.get(i));
            System.out.println("Number of methods: "+methodPerClass.get(i));
            System.out.println("Lines of code: "+linesPerClass.get(i));
        }
        System.out.println("Total size of program: "+this.totalOfLines);

    }//EndMethod

}//EndClass
