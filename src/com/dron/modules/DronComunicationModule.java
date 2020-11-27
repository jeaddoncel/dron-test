package com.dron.modules;

import com.dron.controlTower.ControlTowerObserver;

public class DronComunicationModule
{
    private ControlTowerObserver controlTowerObserver;    
    
    public DronComunicationModule(ControlTowerObserver controlTowerObserver ) 
    {	
	this.controlTowerObserver = controlTowerObserver;
    }

    public ControlTowerObserver getControlTowerObserver()
    {
        return controlTowerObserver;
    }
    
    public void setControlTowerObserver(ControlTowerObserver controlTowerObserver)
    {
        this.controlTowerObserver = controlTowerObserver;
    }
    
    public void setPosition(String position)
    {
        this.controlTowerObserver.reportPosition(position);
    }    
}