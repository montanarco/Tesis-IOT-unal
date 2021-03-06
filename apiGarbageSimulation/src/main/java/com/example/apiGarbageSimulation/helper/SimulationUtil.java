package com.example.apiGarbageSimulation.helper;

import java.util.Random;
import java.util.Arrays;

public class SimulationUtil {
	
	Random rand = new Random();
	/**generating levels acording to the reference distribution found in Autin Texas
	*mean:1250  std: 110 litters turning this data into percentages based in 2000 l capacities
	*the mean must be 62,5 % and std: 5,5%
	*/
	public int[] generateFillement(int numValues,  boolean filled) {
		int[] level=new int[numValues];
		
		for (int x=0;x<level.length;x++) {			
			//rand.nextGaussian() * 63 + 5 generacion de un numero aleatorio 
			//con distribucion gaussiana de media 63y desviacion standart 5
			do {
				level [x]=filled?(int) Math.abs(Math.round(rand.nextGaussian() * 37 + 63)):0;
			}while(level [x]>100);
		}
		return level;
	}
}
