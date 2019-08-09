package az.com.alakbar.model;

import java.util.Date;

public abstract class CourseModel {

	private Long r;
	private Long id;
	private Date dataDate;
	private int active;
	
	
	public Long getR() {
		return r;
	}
	public void setR(Long r) {
		this.r = r;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDataDate() {
		return dataDate;
	}
	public void setDataDate(Date dataDate) {
		this.dataDate = dataDate;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	
	
}
