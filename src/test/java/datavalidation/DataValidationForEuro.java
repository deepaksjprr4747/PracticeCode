package datavalidation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

public class DataValidationForEuro {

public static void main(String[] args) throws FileNotFoundException, IOException, CsvException {
		
	String fileX = "Cash Projection (1).csv";
	
	String fileName = "/Users/shaileshsingh/Downloads/" + fileX;

	List<String[]> r;

	
	String filePath = "/Users/shaileshsingh/Downloads/Csv Output/Output_" + fileX;	
		
    try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
         r = reader.readAll();
    }
    
    double [][] glValidation = new double [r.get(0).length][r.size()+1];
    
    int listIndex = 0;
  
    Boolean csvFlag = false;
    
    List<Integer> glRows = new ArrayList<Integer>();
    List<Integer> failedGlRows = new ArrayList<Integer>();
    List<Integer> nextGlRows = new ArrayList<Integer>();
    List<Integer> rowsToSkip = new ArrayList<Integer>();
    
    for (String[] arrays : r) {
    	listIndex++;
        
       if(arrays.length>2) {
    	   if(!(arrays[1].isBlank())) {
    		   
        		   glRows.add(Integer.valueOf(listIndex));
    		 
           }
           																					
           if((arrays[2].matches("Quota")) || (arrays[2].matches("Employee Commissions"))) {
        	   rowsToSkip.add(Integer.valueOf(listIndex));
           }
       }

        int index = 0;
        for (String array : arrays) {
        
        	
        	if (index>2 && listIndex>2) {
        		
        		char [] ch =array.toCharArray() ;
           	 
           	 String str1 = "";
           	 
           	 for(int i =0;i<ch.length;i++) {
           		 
           		 if(!(Character.getType(ch[i]) == 12)) {
           			 str1 = str1 + ch[i];
           		 }
           	 }
           
           	DecimalFormat df = new DecimalFormat("0.00");
           	df.setMaximumFractionDigits(2);
           	 
           	 
           	str1 = str1.replaceAll("€", "");
           	str1 = str1.replaceAll(",", ".");
           	
           	if(!str1.isBlank()) {
           		
           		double value1 = Double.parseDouble(str1);
           		double value = Double.parseDouble(df.format(value1));
           		glValidation[index][listIndex] = value;
           		index++;
           	}
      
        	else {
        		index++;
        		
        	}
        	
        	} 
        	else {
        		index++;
        	}
        	
        	}
    	}
    
    for(int a=0;a<glRows.size()-6;a++) {
    	
    	for (int i =3;i<r.get(0).length;i++) {
   
    		
        	double sum = 0;
        	
        	for(int j = (glRows.get(a)+1);j<glRows.get(a+1);j++) {
        		
        		Boolean skipFlag = false;
        		
        		for(int k=0;k<rowsToSkip.size();k++) {
        			
        			if(j == rowsToSkip.get(k)) {
        				skipFlag=true;
        			}
        		}
        			if(!skipFlag) {
        				sum = sum + glValidation[i][j];
        			}
        		
        	}
        	
        	if(sum == glValidation[i][glRows.get(a)]) {
      //  		System.out.println("Sum to be matched " + sum);
      //  		System.out.println("Sum Matched for "+ i +"th Column. ");
        	}
        	
        	else if((!((glRows.get(a+1) - glRows.get(a) == 1)) && !((glValidation[i][glRows.get(a)]-sum)> -0.02) || !((glValidation[i][glRows.get(a)]-sum)< 0.02)) && !(r.get(glRows.get(a)-1)[1].matches("Total INCOME")) && !(r.get(glRows.get(a)-1)[1].matches("TOTAL REVENUE")) && !(r.get(glRows.get(a)-1)[1].matches("Total EXPENSE")))  {
            	System.out.println("*********************************************************************");
            	System.out.println("Failed GL name is:  " + r.get(glRows.get(a)-1)[1]);
        		System.out.println("Sum failed to Match for "+ r.get(0)[i] +" Column by $ "+ (glValidation[i][glRows.get(a)]-sum));
        		System.out.println("*********************************************************************");
        	csvFlag = true;
        	
        	failedGlRows.add(Integer.valueOf(glRows.get(a)-1));
        	nextGlRows.add(Integer.valueOf(glRows.get(a+1)-1));
        
        	
        }
     
        }
    }
    
    if(!csvFlag) {
	 	System.out.println("*********************************************************************");
	 	System.out.println("Data on File matched successfully.");
	 	System.out.println("*********************************************************************");
	 	
	}
    
    List<Integer> removedDuplicates = failedGlRows.stream()
            .distinct()
            .collect(Collectors.toList());
    
    List<Integer> removedDuplicates1 = nextGlRows.stream()
            .distinct()
            .collect(Collectors.toList());
    
	
	File file1 = new File(filePath); 
	try { 
    // create FileWriter object with file as parameter 
    FileWriter outputfile = new FileWriter(file1); 

    // create CSVWriter object filewriter object as parameter 
    CSVWriter writer = new CSVWriter(outputfile); 

    // adding header to csv 
    String[] header = r.get(0); 
    writer.writeNext(header); 
    writer.writeNext(r.get(1));

    // add data to csv 
    for(int i =0;i<removedDuplicates.size();i++) {
    	for (int k= removedDuplicates.get(i);k<removedDuplicates1.get(i);k++) {
    		writer.writeNext(r.get(k));
    	}
    }

    // closing writer connection 
    writer.close();
	} 
	catch (IOException e) { 
    // TODO Auto-generated catch block 
    e.printStackTrace();
	}
	}
}
