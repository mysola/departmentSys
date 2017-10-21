package domain;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="bedroom_inf")
public class Bedroom {
	@Id @Column(name="bedroom_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer bedroomId;
	
	@Column(length=5)
	private int num;

	@Column(length=5)
	private int score;
	
	@Column(length=5)
	private int star;
	
	@Temporal(TemporalType.DATE)
	private Date updateTime;
		
	private boolean used;
	
	@ManyToOne(targetEntity=Building.class)
	@JoinColumn(name="building_id",referencedColumnName="building_id",nullable=false)
	private Building building;
	
	@OneToOne(targetEntity=Meter.class)
	@JoinColumn(name="meter_id",referencedColumnName="meter_id",nullable=false)
	private Meter meter;
	
	public Integer getBedroomId() {
		return bedroomId;
	}
	public void setBedroomId(Integer bedroomId) {
		this.bedroomId = bedroomId;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public boolean isUsed() {
		return used;
	}
	public void setUsed(boolean used) {
		this.used = used;
	}
	public Building getBuilding() {
		return building;
	}
	public void setBuilding(Building building) {
		this.building = building;
	}
	public Meter getMeter() {
		return meter;
	}
	public void setMeter(Meter meter) {
		this.meter = meter;
	}
	
}
