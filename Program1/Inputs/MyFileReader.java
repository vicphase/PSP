package Program1.Inputs;


import Program1.collections.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Víctor Martínez on 1/29/2017 at 4:43 PM.
 */


public class MyFileReader {
    
    public MyFileReader(){
        
    }
    
    public List readNumbersFromFile(String fileName){
        BufferedReader br = null;
	FileReader fr = null;
        List list = new List();

		try {

			fr = new FileReader(fileName);
			br = new BufferedReader(fr);

			String sCurrentLine;

			br = new BufferedReader(new FileReader(fileName));

			while ((sCurrentLine = br.readLine()) != null) {
			    list.addLast(Double.parseDouble(sCurrentLine));            
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
          return list;      
    }
}
