package com.app;

import java.util.ArrayList;

import com.app.data.ConfigurationApp;
import com.app.data.Data;
import com.app.data.DataFromFile;
import com.app.dto.DronRouteDTO;
import com.app.report.file.FileReport;
import com.dron.DronModularized;
import com.dron.controlTower.ControlTowerObserver;
import com.dron.controlTower.DronObserver;
import com.dron.modules.DronComunicationModule;

public class App
{  	
    public static void main(String[] params)
    {
	createDronRoutes();
    }
    
    public static void createDronRoutes()
    {
	// load Configuration
	ConfigurationApp conf = ConfigurationApp.getInstance();

	// load data from files
	Data data = new DataFromFile(conf.getFolderIn());
	ArrayList<DronRouteDTO> dronRouteList = data.getDronRoutes(conf.getMaxLunches(), conf.getMaxLunches());

	// build drones
	dronRouteList.parallelStream().forEach(dronRoute -> {

	    // init dron with modules
	    DronModularized dron = new DronModularized(dronRoute.getCode());

	    // init observer
	    ControlTowerObserver dronObserver = new DronObserver(dron, new FileReport(conf.getFolderOut()));

	    // add comunication module and observer to dron
	    dron.setComunicationModule(new DronComunicationModule(dronObserver));

	    // init delivery
	    dron.start(dronRoute.getRoutes());
	});
    }
    
    
    public ArrayList<String> createDronRoutesNoSimultaneous(ArrayList<DronRouteDTO> dronRouteList)
    {
	//load Configuration
	ConfigurationApp conf = ConfigurationApp.getInstance();
	
	ArrayList<String> finalPositions = new ArrayList<String>();
		
	//build drones
	dronRouteList.forEach(dronRoute -> {

	    // init dron with modules
	    DronModularized dron = new DronModularized(dronRoute.getCode());

	    // init observer
	    ControlTowerObserver dronObserver = new DronObserver(dron, new FileReport(conf.getFolderOut()));

	    // add comunication module and observer to dron
	    dron.setComunicationModule(new DronComunicationModule(dronObserver));

	    // init delivery
	    finalPositions.addAll(dron.start(dronRoute.getRoutes()));
	});
	
	return finalPositions;
    }
    
    
    public ArrayList<String> createDronRoutes(DronRouteDTO dronRoute)
    {
	//load Configuration
	ConfigurationApp conf = ConfigurationApp.getInstance();

	// init dron with modules
	DronModularized dron = new DronModularized(dronRoute.getCode());

	// init observer
	ControlTowerObserver dronObserver = new DronObserver(dron, new FileReport(conf.getFolderOut()));

	// add comunication module and observer to dron
	dron.setComunicationModule(new DronComunicationModule(dronObserver));

	// init delivery
	return dron.start(dronRoute.getRoutes());	
    }
}
