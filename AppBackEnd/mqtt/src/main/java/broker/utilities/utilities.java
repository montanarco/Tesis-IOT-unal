package broker.utilities;

import broker.constants.SimulationConstants;

public class utilities {

	public static Integer caltulateLevel(Integer distance, Integer idDumpsterType) {
		Integer level =0;
		int dumpsterHeight = idDumpsterType == 1? SimulationConstants.RECICLABLE_DUMPSTER_HEIGHT :  SimulationConstants.WASTE_DUMPSTER_HEIGHT;
		float dumpsterFilling = dumpsterHeight - distance;
		if (dumpsterFilling > 0) {
			float division = dumpsterFilling/dumpsterHeight;
			level = (int) Math.ceil((division)*100);
		}
		return level;
	}

}
