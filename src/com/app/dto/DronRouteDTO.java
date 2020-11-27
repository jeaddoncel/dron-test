package com.app.dto;

import java.util.ArrayList;

public class DronRouteDTO
{
    private String code;
    private ArrayList<RouteDTO> routes;
    
    public String getCode()
    {
        return code;
    }
    
    public void setCode(String code)
    {
        this.code = code;
    }
    
    public ArrayList<RouteDTO> getRoutes()
    {
        return routes;
    }
    
    public void setRoutes(ArrayList<RouteDTO> routes)
    {
        this.routes = routes;
    }
}
