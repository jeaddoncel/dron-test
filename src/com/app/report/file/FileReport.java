
package com.app.report.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import com.app.report.Report;

public class FileReport extends Report
{   
    private String folderOut;
    
    public FileReport(String folderOut) 
    {
	this.folderOut = folderOut;
	
	File directory = new File(folderOut);
	if(!directory.exists()) {
	    directory.mkdir();
	}
    }

    @Override
    public void sendReport(String origin, String message)
    {
	try
	{  	    
	    String path = folderOut+("out"+origin+".txt");
	    File file = new File(path);
	    
	    if(!file.exists())	    
		file.createNewFile();	    
	    
	    FileWriter fileWriter = new FileWriter(file,true);
	    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
	    bufferedWriter.write(message);
	    bufferedWriter.newLine();
	    bufferedWriter.close();
	    
	}
	catch (IOException e)
	{
	    e.printStackTrace();
	}
    }

}
