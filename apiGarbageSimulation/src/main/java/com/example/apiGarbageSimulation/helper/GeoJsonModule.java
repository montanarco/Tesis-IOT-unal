/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.apiGarbageSimulation.helper;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.vividsolutions.jts.geom.Geometry;

/**
 *
 * @author roa.fabio
 */
public class GeoJsonModule extends SimpleModule {

    public GeoJsonModule() {
        super("GeoJson", new Version(1, 0, 0, null, "com.bedatadriven", "jackson-geojson"));

        addSerializer(Geometry.class, new GeometrySerializer());
        addDeserializer(Geometry.class, new GeometryDeserializer());
    }
}
