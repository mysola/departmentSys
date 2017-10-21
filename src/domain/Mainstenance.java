package domain;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="mainst_inf")
public class Mainstenance {
	@Id
	@Column(name = "mainst_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer mainstenanceId;

	@Column(length = 30)
	private String name;

	@Column(length = 5)
	private String sex;

	@Temporal(TemporalType.DATE)
	private Date birth;

	@Column(length = 18)
	private int idCard;

	@Column(length = 11)
	private int tel;

	@Column(length = 30)
	private String username;

	@Column(length = 30)
	private String password;

	@ManyToMany(targetEntity=Building.class,fetch=FetchType.EAGER)
	@JoinTable(name="mainst_building",
		joinColumns=@JoinColumn(name="mainst_id",referencedColumnName="mainst_id"),
		inverseJoinColumns=@JoinColumn(name="building_id",
		referencedColumnName="building_id")			
	)
	private List<Building> buildings;
	
	public Integer getMainstenanceId() {
		return mainstenanceId;
	}

	public void setMainstenanceId(Integer mainstenanceId) {
		this.mainstenanceId = mainstenanceId;
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

	public List<Building> getBuildings() {
		return buildings;
	}

	public void setBuildings(List<Building> buildings) {
		this.buildings = buildings;
	}

}
