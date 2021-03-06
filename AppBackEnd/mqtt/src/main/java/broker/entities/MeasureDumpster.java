package broker.entities;

import java.util.Date;

public class MeasureDumpster {
	 private Integer id;
	 private Integer idDumpster;
	 private Integer level;
	 private Date measureDate;
	 private Integer priority;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdDumpster() {
		return idDumpster;
	}
	public void setIdDumpster(Integer idDumpster) {
		this.idDumpster = idDumpster;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Date getMeasureDate() {
		return measureDate;
	}
	public void setMeasureDate(Date measureDate) {
		this.measureDate = measureDate;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	
	public void computePriority() {
        if (this.level >= 80) {
            this.priority = 4;
        }
        if (this.level >= 55 && this.level < 80) {
            this.priority = 1;
        }
        if (this.level >= 30 && this.level < 55) {
            this.priority = 2;
        }
        if (this.level < 30) {
            this.priority = 3;
        }
        if (this.level == 0) {
            this.priority = 5;
        }
    }
}
