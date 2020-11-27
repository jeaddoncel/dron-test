package com.dron.controlTower;

import com.dron.DronModularized;

public abstract class ControlTowerObserver
{
    protected DronModularized dron;
    public abstract void reportPosition(String position); 
}
