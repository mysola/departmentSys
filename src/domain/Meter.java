package domain;

import javax.persistence.*;

@Entity
@Table(name="meter_inf")
public class Meter {
	@Id @Column(name="meter_id")
	private Integer meterId;
	
	@Column(length=20)
	private int meterNum;
	
	@Column(length=20)
	private String status;
		
	private double costMonth;
	private double costAll;
	
	public Integer getMeterId() {
		return meterId;
	}

	public void setMeterId(Integer meterId) {
		this.meterId = meterId;
	}

	public int getMeterNum() {
		return meterNum;
	}

	public void setMeterNum(int meterNum) {
		this.meterNum = meterNum;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getCostMonth() {
		return costMonth;
	}

	public void setCostMonth(double costMonth) {
		this.costMonth = costMonth;
	}

	public double getCostAll() {
		return costAll;
	}

	public void setCostAll(double costAll) {
		this.costAll = costAll;
	}
}
