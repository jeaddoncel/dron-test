package com.app.junit;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.app.App;
import com.app.dto.DronRouteDTO;
import com.app.dto.RouteDTO;


public class AppDronJunit
{

    @Test
    public void testCreateDronRoutesNoSimultaneous()
    {
	App test = new App();
	ArrayList<DronRouteDTO> dronRouteList = new ArrayList<DronRouteDTO>();
	
	DronRouteDTO routeA = new DronRouteDTO();
	routeA.setCode("100");	
	routeA.setRoutes(new ArrayList<RouteDTO>());	
	routeA.getRoutes().add(new RouteDTO("AAAAAAA"));
	routeA.getRoutes().add(new RouteDTO("DAAAAAAA"));
	routeA.getRoutes().add(new RouteDTO("DAAAAAAA"));	
	routeA.getRoutes().add(new RouteDTO("DAAAAAAA"));
	dronRouteList.add(routeA);
	
	DronRouteDTO routeB = new DronRouteDTO();
	routeB.setCode("101");	
	routeB.setRoutes(new ArrayList<RouteDTO>());	
	routeB.getRoutes().add(new RouteDTO("IAAAAAAA"));	
	dronRouteList.add(routeB);
	
	List<String> expected = new ArrayList<String>();
	expected.add("0,7,Norte");
	expected.add("7,7,Oriente");
	expected.add("7,0,Sur");
	expected.add("0,0,Occidente");
	expected.add("-7,0,Occidente");
	
	List<String> result = test.createDronRoutesNoSimultaneous(dronRouteList);
	
	assertTrue(expected.equals(result));
    }





    @Test
    public void testCreateDronRoutesDronRouteDTO()
    {
	App test = new App();
	DronRouteDTO route = new DronRouteDTO();
	route.setCode("100");
	
	route.setRoutes(new ArrayList<RouteDTO>());	
	route.getRoutes().add(new RouteDTO("AAAAIAA"));
	route.getRoutes().add(new RouteDTO("DDDAIAD"));
	route.getRoutes().add(new RouteDTO("AAIADAD"));
	
	List<String> expected = new ArrayList<String>();
	expected.add("-2,4,Occidente");
	expected.add("-1,3,Sur");
	expected.add("0,0,Occidente");

	List<String> result = test.createDronRoutes(route);
	assertTrue(expected.equals(result));
    }

}
