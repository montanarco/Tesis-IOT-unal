
package com.example.apiGarbageSimulation.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.apiGarbageSimulation.entities.MeasureDumpter;



public interface MeasureDumpterRepository extends CrudRepository<MeasureDumpter, Integer> {
	
	List<MeasureDumpter> findByMeasureDate(Date date);
	
	//esta consulta recupera la ultima medicion de cada uno de los contenedores que tienen un registro (device_id)
	@Query(value = "SELECT A.id, A.id_dumpster, A.\"level\", A.measure_date, A.priority \r\n" + 
			"FROM measure_dumpter A INNER JOIN (\r\n" + 
			"    SELECT id_dumpster, MAX(measure_date) as measure_date\r\n" + 
			"    FROM measure_dumpter\r\n" + 
			"    GROUP BY id_dumpster) AS B ON A.id_dumpster = B.id_dumpster AND A.measure_date = B.measure_date\r\n" + 
			"INNER join  dumpster D on A.id_dumpster = D.ID\r\n" + 
			"where D.device_id is not NULL;",
			
		   countQuery = "SELECT COUNT (A.id, A.id_dumpster, A.\"level\", A.measure_date, A.priority)\r\n" + 
		   		"FROM measure_dumpter A INNER JOIN (\r\n" + 
		   		"    SELECT id_dumpster, MAX(measure_date) as measure_date\r\n" + 
		   		"    FROM measure_dumpter\r\n" + 
		   		"    GROUP BY id_dumpster) AS B ON A.id_dumpster = B.id_dumpster AND A.measure_date = B.measure_date\r\n" + 
		   		"INNER join  dumpster D on A.id_dumpster = D.ID\r\n" + 
		   		"where D.device_id is not NULL;",
		   nativeQuery = true)
	List<MeasureDumpter> findLastMeasures();
	
}
