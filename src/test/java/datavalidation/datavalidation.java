package datavalidation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class datavalidation {
	
	public static void main(String[] args) throws FileNotFoundException, IOException, CsvException {
		
		String fileName = "/Users/shaileshsingh/Desktop/untitled folder/Cash Projection.csv";
    
		List<String[]> r;
		
    try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
         r = reader.readAll();
    }

    
//    System.out.println("No. of columns : " + r.get(0).length);
//    System.out.println("No. of rows : " + r.size());
    
    double [][] glValidation = new double [r.get(0).length][r.size()+1];
    
    int listIndex = 0;
    
    Boolean csvFlag = false;
    
    List<Integer> glRows = new ArrayList<Integer>();
    List<Integer> rowsToSkip = new ArrayList<Integer>();
    
    for (String[] arrays : r) {
    	listIndex++;
   //    System.out.println("\nString[" + listIndex++ + "] : " + Arrays.toString(arrays));
        
       if(arrays.length>2) {
    	   if(!(arrays[1].isBlank())) {
    		   
        		   glRows.add(Integer.valueOf(listIndex));
       //        	System.out.println("This is new GL Row");
    		 
           }
           																					
           if((arrays[2].matches("Quota")) || (arrays[2].matches("Employee Commissions"))) {
        	   rowsToSkip.add(Integer.valueOf(listIndex));
    //       	System.out.println("This row is to be skipped");
           }
       }

        int index = 0;
        for (String array : arrays) {
        
        	
        	if (index>2 && listIndex>2) {
        		
        		char [] ch =array.toCharArray() ;
           	 
           	 String str1 = "";
           	 
           	 for(int i =0;i<ch.length;i++) {
           		 
           	//	 System.out.println("Character type for "+ ch[i]+" is "+ Character.getType(ch[i]));
           		 
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
        //  		System.out.println(index++ + " : value in int : " + value);
           	}
      
        	else {
        		index++;
       // 		System.out.println(index++ + " : " + array);
        		
        	}
        	
        	} 
        	else {
        		index++;
        //		System.out.println(index++ + " : " + array);
        	}
        	
        	}
    	}
   
 //  System.out.println(glRows);
    
 //   System.out.println(rowsToSkip);
    
 //   for(int i=0;i<r.size();i++) {
 //   	String str2="";
 //   	for (int j=0;j<r.get(0).length;j++) {
 //   		str2 = str2 +" " + glValidation[j][i];
 //   	}
 //   	System.out.println(str2);
 //   }
    
    
 
    for(int a=0;a<glRows.size()-6;a++) {
    	
   // 	System.out.println("*********************************************************************");
   // 	System.out.println("GL on Row " + glRows.get(a));
   // 	System.out.println("*********************************************************************");
    	
    	for (int i =3;i<r.get(0).length;i++) {
   
    		
        	double sum = 0;
        	
      //  	System.out.println(glRows.get(0));
        	
        	for(int j = (glRows.get(a)+1);j<glRows.get(a+1);j++) {
        		
      //  		System.out.println("Value of j: "+ j);
        		
        		Boolean skipFlag = false;
        		
        		for(int k=0;k<rowsToSkip.size();k++) {
        			
      //  			System.out.println("Value of k: "+ k);
        			
        			if(j == rowsToSkip.get(k)) {
        				skipFlag=true;
      //  				System.out.println("Row number "+ j+ " skipped.");
        			}
        		}
        			if(!skipFlag) {
        				sum = sum + glValidation[i][j];
      //  				System.out.println("Value of sum: "+ sum);
        			}
        		
        	}
        	
     //   	System.out.println("Value of Sum: "+ sum);
     //   	System.out.println("Value of GL: "+ glValidation[i][glRows.get(a)]);
        	
        	if(sum == glValidation[i][glRows.get(a)]) {
      //  		System.out.println("Sum to be matched " + sum);
      //  		System.out.println("Sum Matched for "+ i +"th Column. ");
        	}
        	
        	else if((!((glValidation[i][glRows.get(a)]-sum)> -0.02) || !((glValidation[i][glRows.get(a)]-sum)< 0.02)) && !(r.get(glRows.get(a)-1)[1].matches("Total INCOME")) && !(r.get(glRows.get(a)-1)[1].matches("TOTAL REVENUE")) && !(r.get(glRows.get(a)-1)[1].matches("Total EXPENSE")))  {
               	System.out.println("*********************************************************************");
            	System.out.println("Failed GL name is:  " + r.get(glRows.get(a)-1)[1]);
        		System.out.println("Sum failed to Match for "+ r.get(0)[i] +" Column by $ "+ (glValidation[i][glRows.get(a)]-sum));
        		System.out.println("*********************************************************************");
        	
        		csvFlag=true;
        }
     
        }
    
    }
    if(!csvFlag) {
	 	System.out.println("*********************************************************************");
	 	System.out.println("Data on File matched successfully.");
	 	System.out.println("*********************************************************************");
	 	
	}
    
	}
	
}

	


