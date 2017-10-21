package domain;

import java.util.Date;

import javax.persistence.*;

import domain.Building;

@Entity
@Table(name="master_inf")
public class HouseMaster {
	@Id @Column(name="master_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer MasterId;

	@Column(length=30)
	private String name;
	
	@Column(length=5)
	private String sex;
	
	@Temporal(TemporalType.DATE)
	private Date birth;
	
	@Column(length=18)
	private int idCard;
	
	@Column(length=11)
	private int tel;
	
	@Column(length=30)
	private String username;
	
	@Column(length=30)
	private String password;
	
	@ManyToOne(targetEntity=Building.class)
	@JoinColumn(name="building_id",referencedColumnName="building_id",nullable=false)
	private Building building;

	public Integer getMasterId() {
		return MasterId;
	}

	public void setMasterId(Integer masterId) {
		MasterId = masterId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public int getIdCard() {
		return idCard;
	}

	public void setIdCard(int idCard) {
		this.idCard = idCard;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	} 
	
}
