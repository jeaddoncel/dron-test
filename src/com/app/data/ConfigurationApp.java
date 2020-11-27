
package com.app.data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationApp
{

    private static ConfigurationApp conf;

    private int			    maxDrones	   = 20;

    private int			    maxLunches	   = 3;

    private int			    maxSquareBlock = 10;
    
    private String		    folderOut ;
    
    private String		    folderIn ;

    public static ConfigurationApp getInstance()
    {
	if (conf == null)
	{
	    conf = new ConfigurationApp();
	}

	return conf;
    }





    private ConfigurationApp( ) {
	this.loadConfiguration();
    }





    public void loadConfiguration()
    {
	String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
	String appConfigPath = rootPath + "config.properties";

	Properties appProps = new Properties();

	try
	{
	    appProps.load(new FileInputStream(appConfigPath));
	    maxDrones = Integer.parseInt(appProps.get("maxDrones").toString());
	    maxLunches = Integer.parseInt(appProps.get("maxLunches").toString());
	    maxSquareBlock = Integer.parseInt(appProps.get("maxSquareBlock").toString());
	    folderIn = "C:\\tests4njead\\in\\";
	    folderOut = "C:\\tests4njead\\out\\";
	}
	catch (FileNotFoundException e)
	{
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	catch (IOException e)
	{
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }





    public int getMaxDrones()
    {
	return maxDrones;
    }





    public void setMaxDrones(int maxDrones)
    {
	this.maxDrones = maxDrones;
    }





    public int getMaxLunches()
    {
	return maxLunches;
    }





    public void setMaxLunches(int maxLunches)
    {
	this.maxLunches = maxLunches;
    }





    public int getMaxSquareBlock()
    {
	return maxSquareBlock;
    }





    public void setMaxSquareBlock(int maxSquareBlock)
    {
	this.maxSquareBlock = maxSquareBlock;
    }





    
    public String getFolderOut()
    {
        return folderOut;
    }





    
    public void setFolderOut(String folderOut)
    {
        this.folderOut = folderOut;
    }





    
    public String getFolderIn()
    {
        return folderIn;
    }





    
    public void setFolderIn(String folderIn)
    {
        this.folderIn = folderIn;
    }
    
    
}
