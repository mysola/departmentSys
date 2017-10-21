package domain;
import javax.persistence.*;

@Entity
@Table(name="campus_inf")
public class Campus {
	@Id @Column(name="campus_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer campusId;
	
	@Column(length=30)
	private String campusName;
	
	public Integer getCampusId() {
		return campusId;
	}
	public void setCampusId(Integer campusId) {
		this.campusId = campusId;
	}
	public String getCampusName() {
		return campusName;
	}
	public void setCampusName(String campusName) {
		this.campusName = campusName;
	}
}
