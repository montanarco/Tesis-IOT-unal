/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.apiGarbageSimulation.helper;

import com.vividsolutions.jts.geom.Point;

/**
 *
 * @author roa.fabio
 */
public class PointHelper {

    public static Float[] pointFloat(Point p) {
        Float[] data = new Float[2];
        double lat = p.getY();
        double lon = p.getX();
        data[0] = (float) lat;
        data[1] = (float) lon;
        return data;
    }
}
