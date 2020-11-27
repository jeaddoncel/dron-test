package com.dron;

import com.dron.constans.CardinalPoint;

public class Dron
{
    int x = 0;
    
    int y = 0;
    
    String code;
    
    CardinalPoint cardinalPoint = CardinalPoint.NORTH;
        
    public Dron()
    {	
    }
    
    public int getX()
    {
        return x;
    }
    
    public void setX(int x)
    {
        this.x = x;
    }
    
    public int getY()
    {
        return y;
    }
    
    public void setY(int y)
    {
        this.y = y;
    }

    
    public CardinalPoint getCardinalPoint()
    {
        return cardinalPoint;
    }

    
    public void setCardinalPoint(CardinalPoint cardinalPoint)
    {
        this.cardinalPoint = cardinalPoint;
    }

    
    public String getCode()
    {
        return code;
    }

    
    public void setCode(String code)
    {
        this.code = code;
    }
}
