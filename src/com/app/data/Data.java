package com.app.data;

import java.util.ArrayList;
import com.app.dto.DronRouteDTO;

public abstract class Data
{
    public abstract ArrayList<DronRouteDTO> getDronRoutes(int maxDrons,int maxLunches); 
}
