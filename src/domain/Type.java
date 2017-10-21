package domain;

import javax.persistence.*;

@Entity
@Table(name="type_inf")
public class Type {
	@Id @Column(name="type_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer typeId;
	
	@Column(length=30)
	private String type;

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
