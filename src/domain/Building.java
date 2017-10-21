package domain;

import javax.persistence.*;

@Entity
@Table(name="building_inf")
public class Building {
	@Id @Column(name="building_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer buildingId;
	
	@ManyToOne(targetEntity=Campus.class)
	@JoinColumn(name="campus_id",referencedColumnName="campus_id",nullable=false)
	private Campus campus;
	
	@Column(length=30)
	private String buildingName;

	public Integer getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}

	public Campus getCampus() {
		return campus;
	}

	public void setCampus(Campus campus) {
		this.campus = campus;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
}	
