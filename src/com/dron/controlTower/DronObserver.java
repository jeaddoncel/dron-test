package com.dron.controlTower;

import com.app.report.Report;
import com.dron.DronModularized;

public class DronObserver extends ControlTowerObserver
{ 
    private Report report;
    
    public DronObserver(DronModularized dron,Report report) 
    {
	this.dron = dron;	
	this.report = report;
    }
    
    @Override
    public void reportPosition(String position)
    {
	report.sendReport(dron.getCode(),position);
    }    
}
