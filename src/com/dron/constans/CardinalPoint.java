package com.dron.constans;


public enum CardinalPoint
{   
    NORTH("N","Norte",0),    
    ORI("OR","Oriente",1),
    SOUTH("S","Sur",2),
    OCC("OC","Occidente",3);
    
    String code;
    String label;
    int cardinal;
    
    private CardinalPoint(String code,String label,int cardinal) 
    {
	this.code = code;
	this.label = label;
	this.cardinal = cardinal;
    }

    
    public String getCode()
    {
        return code;
    }

    
    public void setCode(String code)
    {
        this.code = code;
    }

    
    public String getLabel()
    {
        return label;
    }

    
    public void setLabel(String label)
    {
        this.label = label;
    }

    
    public int getCardinal()
    {
        return cardinal;
    }

    
    public void setCardinal(int cardinal)
    {
        this.cardinal = cardinal;
    }
    
    
}
