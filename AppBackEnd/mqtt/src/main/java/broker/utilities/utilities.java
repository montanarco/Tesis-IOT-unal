package broker.utilities;

import broker.constants.SimulationConstants;

public class utilities {

	public static Integer caltulateLevel(Double distance, Integer idDumpsterType) {
		Integer level =0;
		Integer dumpsterHeight = idDumpsterType == 1? SimulationConstants.RECICLABLE_DUMPSTER_HEIGHT :  SimulationConstants.WASTE_DUMPSTER_HEIGHT;
		Double dumpsterFilling = dumpsterHeight - distance;
		if (dumpsterFilling > 0) {
			level = (int) Math.ceil((dumpsterFilling/dumpsterHeight)*100);
		}
		return level;
	}

}
