//Base
package Program1.Inputs;

import Program1.collections.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Víctor Martínez on 1/29/2017 at 4:43 PM.
 * Description: has different methods to read text files
 */

public class MyFileReader { //StartClass

    public MyFileReader(){ //StartMethod
        
    }

	public List readNumbersFromFile(String fileName){ //StartMethod
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
    }//End Method

	public Program3.collections.List readTwoNumbersFromFile(String fileName){ //StartMethod
		BufferedReader br = null;
		FileReader fr = null;
		Program3.collections.List list = new Program3.collections.List();

		try {

			fr = new FileReader(fileName);
			br = new BufferedReader(fr);

			String sCurrentLine;

			br = new BufferedReader(new FileReader(fileName));

			while ((sCurrentLine = br.readLine()) != null) {
				String[] strs = sCurrentLine.trim().split(" ");
				list.addLast(Double.parseDouble(strs[0]), Double.parseDouble(strs[1]));
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

	//Added
	public List readNumbersAndDivide(String fileName){ //StartMethod
		BufferedReader br = null;
		FileReader fr = null;
		List list = new List();

		try {

			fr = new FileReader(fileName);
			br = new BufferedReader(fr);

			String sCurrentLine;

			br = new BufferedReader(new FileReader(fileName));

			while ((sCurrentLine = br.readLine()) != null) {
				String[] strs = sCurrentLine.trim().split(" ");
				list.addLast(Double.parseDouble(strs[0]) / Double.parseDouble(strs[1]));
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
	}//End Method
}//EndClass