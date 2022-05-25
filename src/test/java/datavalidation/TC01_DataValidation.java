package datavalidation;

import org.testng.annotations.Test;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.place.automation.cpm.base.BaseTest;
import com.place.automation.utils.WriteCSV;

public class TC01_DataValidation extends BaseTest{

	WriteCSV csvWrite;
	String fileName;
	List<String[]> r;
	
	
	
	@BeforeTest
	public void navigatePLPage() throws Exception
	{	
		
		final String currentDir = System.getProperty("user.dir");
		
		String fileX = "Cash Projection (1).csv";
		
		String fileName = "/Users/shaileshsingh/Downloads/" + fileX;
	
		
		String filePath = currentDir + "//src//test//resources//dataValidationCsvOutputFiles//Output_" + fileX;	
		
		try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
	         r = reader.readAll();
	    }
		
		csvWrite = new WriteCSV(filePath);
	}
	
	@Test
	public void plTabExpand() throws InterruptedException, FileNotFoundException, IOException
	{
		

	    double [][] glValidation = new double [r.get(0).length][r.size()+1];
	    
	    int listIndex = 0;
	  
	    Boolean csvFlag=false;
	    
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
	              		
	              		 
	              		 if(!((Character.getType(ch[i]) == 26) || (Character.getType(ch[i]) == 24) || (Character.getType(ch[i]) == 12) )) {
	              			 str1 = str1 + ch[i];
	              		 }
	              	 }
	       
	           	
	           	if(!str1.isBlank()) {
	           		
	           		double value = Double.parseDouble(str1);
	           		
	           		glValidation[index][listIndex] = value/100;
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
	      
	       // System.out.println(glRows);	
	        	
	        	if(sum == glValidation[i][glRows.get(a)]) {
	      //  		System.out.println("Sum to be matched " + sum);
	      //  		System.out.println("Sum Matched for "+ i +"th Column. ");
	        	}
	        	
	        	else if((!((glRows.get(a+1) - glRows.get(a) == 1)) && (!((glValidation[i][glRows.get(a)]-sum)> -0.02) || !((glValidation[i][glRows.get(a)]-sum)< 0.02))) && !(r.get(glRows.get(a)-1)[1].matches("Total INCOME")) && !(r.get(glRows.get(a)-1)[1].matches("TOTAL REVENUE")) && !(r.get(glRows.get(a)-1)[1].matches("Total EXPENSE")))  {
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
	    
		
		
	    String[] header = r.get(0); 
	    csvWrite.addLines(header);
	    csvWrite.addLines(r.get(1));

	    // add data to csv 
	    for(int i =0;i<removedDuplicates.size();i++) {
	    	for (int k= removedDuplicates.get(i);k<removedDuplicates1.get(i);k++) {
	    		csvWrite.addLines(r.get(k));
	    	}
	    }

	    // closing writer connection 
	    csvWrite.closeFile();
		} 

	}

