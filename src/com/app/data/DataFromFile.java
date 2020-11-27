package com.app.data;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;
import com.app.dto.DronRouteDTO;
import com.app.dto.RouteDTO;

public class DataFromFile extends Data
{
    private String folderIn;
     
    public DataFromFile(String folderIn) 
    {
	this.folderIn = folderIn;
	File directory = new File(this.folderIn);
	if(!directory.exists()) {
	    directory.mkdir();
	}
    }
    
    @Override
    public ArrayList<DronRouteDTO> getDronRoutes(int maxDrons,int maxLunches)
    {
	ArrayList<DronRouteDTO> routes = new ArrayList<DronRouteDTO>();
	
	try (Stream<Path> paths = Files.walk(Paths.get(folderIn))) 
	{   
	    paths.limit(maxDrons).filter(Files::isRegularFile).forEach(file->
	    {    
		try
		{
		    DronRouteDTO dronRoute = new DronRouteDTO();
		    dronRoute.setCode(file.getFileName().toString().subSequence(2,4).toString());
		    dronRoute.setRoutes(new ArrayList<RouteDTO>());
			
		    Path path = Paths.get(file.toUri());
		    Stream<String> lines = Files.lines(path);
		    lines.limit(maxLunches).forEach(line->{dronRoute.getRoutes().add(new RouteDTO(line));});
		    lines.close();
		    
		    routes.add(dronRoute);
		}
		catch (IOException e)
		{
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}		
	    });
	}	
	catch (IOException e)
	{
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} 
	
	return routes;
    }
}
