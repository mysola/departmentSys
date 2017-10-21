package domain;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="stu_info")

public class Student {
	@Id @Column(name="stu_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer studentId;
	
	@Column(length=30)
	private String name;
	
	@Column(length=5)
	private String sex;
	
	@Temporal(TemporalType.DATE)
	private Date birth;
	
	@Column(length=30)
	private String college;
	
	@Column(length=30)
	private String major;
	
	@Column(length=30)
	private String _class;
	
	@Column(length=11)
	private int tel;
	
	@ManyToOne(targetEntity=Bedroom.class)
	@JoinColumn(name="bedroom_id",referencedColumnName="bedroom_id",nullable=false)
	private Bedroom bedroom;
	
	@Column(length=30)
	private String studentNum;
	
	@Column(length=30)
	private String password;

	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
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
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String get_class() {
		return _class;
	}
	public void set_class(String _class) {
		this._class = _class;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public Bedroom getBedroom() {
		return bedroom;
	}
	public void setBedroom(Bedroom bedroom) {
		this.bedroom = bedroom;
	}
	public String getStudentNum() {
		return studentNum;
	}
	public void setStudentNum(String studentNum) {
		this.studentNum = studentNum;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
