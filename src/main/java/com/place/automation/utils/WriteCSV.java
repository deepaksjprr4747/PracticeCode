package com.place.automation.utils;

import java.io.File;
import java.io.FileWriter;

import com.opencsv.CSVWriter;

public class WriteCSV {
	
	CSVWriter writer;
	
	public WriteCSV(String filePath) {
		
		File file1 = new File(filePath); 
		try { 
	    // create FileWriter object with file as parameter 
	    FileWriter outputfile = new FileWriter(file1); 

	    // create CSVWriter object filewriter object as parameter 
	    writer = new CSVWriter(outputfile); 
		}
		catch(Exception e) {
			Log.info(e.getMessage());
		}
	}
	
	public void addLines (String[] message) {
		writer.writeNext(message);
		Log.info("Line added in output CSV");
	}
	
	public void closeFile() {
		try {
			writer.close();
			Log.info("CSV closed");
		} catch (Exception e) {
			Log.info(e.getMessage());
		}
	}

}
