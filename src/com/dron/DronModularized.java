
package com.dron;

import java.util.ArrayList;

import com.app.dto.RouteDTO;
import com.dron.constans.CardinalPoint;
import com.dron.modules.DronComunicationModule;

public class DronModularized extends Dron
{

    private DronComunicationModule comunicationModule;

    CardinalPoint []		   cardinalPointMap = new CardinalPoint[]
    { CardinalPoint.NORTH, CardinalPoint.ORI, CardinalPoint.SOUTH, CardinalPoint.OCC };

    public DronModularized(String code ) {
	this.code = code;
    }





    public ArrayList<String> start(ArrayList<RouteDTO> routes)
    {
	this.x = 0;
	this.y = 0;
	this.cardinalPoint = CardinalPoint.NORTH;
	
	ArrayList<String> finalPositions = new ArrayList<String>();

	routes.stream().forEach(route -> {
	    char [] positions = route.getRoute().toCharArray();

	    for (char position : positions)
	    {
		if (position == 'A')
		{
		    if (this.cardinalPoint.equals(CardinalPoint.NORTH))
		    {
			this.y++;
		    }
		    else if (this.cardinalPoint.equals(CardinalPoint.ORI))
		    {
			this.x++;
		    }
		    else if (this.cardinalPoint.equals(CardinalPoint.SOUTH))
		    {
			this.y--;
		    }
		    if (this.cardinalPoint.equals(CardinalPoint.OCC))
		    {
			this.x--;
		    }
		}
		else
		{
		    this.cardinalPoint = calculateCardinalPoint(this.cardinalPoint.getCardinal(), position);
		}
	    }

	    String finalPosition = this.x + "," + this.y+","+this.cardinalPoint.getLabel();
	    finalPositions.add(finalPosition);
	    this.comunicationModule.setPosition("(" + this.x + "," + this.y + ") direccion " + this.cardinalPoint.getLabel());

	});
	
	return finalPositions;

    }





    private CardinalPoint calculateCardinalPoint(int currentCardinal, char position)
    {
	if (position == 'D')
	{
	    if (currentCardinal == 3)
		return cardinalPointMap[0];
	    else
		return cardinalPointMap[currentCardinal + 1];
	}
	else if (position == 'I')
	{
	    if (currentCardinal == 0)
		return cardinalPointMap[3];
	    else
		return cardinalPointMap[currentCardinal - 1];
	}

	return cardinalPointMap[currentCardinal];
    }





    public DronComunicationModule getComunicationModule()
    {
	return comunicationModule;
    }





    public void setComunicationModule(DronComunicationModule comunicationModule)
    {
	this.comunicationModule = comunicationModule;
    }
}
