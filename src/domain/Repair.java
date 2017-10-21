package domain;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
@Entity
@Table(name="repair_inf")
public class Repair {
	@Id @Column(name="repair_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer repairId;
	
	@ManyToOne(targetEntity=Bedroom.class)
	@JoinColumn(name="bedroom_id",referencedColumnName="bedroom_id",nullable=false)
	private Bedroom bedroom;
	
	@ManyToOne(targetEntity=Student.class)
	@JoinColumn(name="stu_id",referencedColumnName="stu_id",nullable=false)
	private Student student;
	
	@ManyToOne(targetEntity=Type.class)
	@JoinColumn(name="type_id",referencedColumnName="type_id",nullable=false)
	private Type type;
	
	@Column(length=50)
	private String note;
	
	@Temporal(TemporalType.DATE)
	private Date repairTime;
	
	private boolean received;
	
	@Temporal(TemporalType.DATE)
	private Date receiveTime;
	
	@ManyToOne(targetEntity=Mainstenance.class)
	@JoinColumn(name="mainst_id",referencedColumnName="mainst_id")
	private Mainstenance receiver;
	
	private boolean finished;
	
	@Temporal(TemporalType.DATE)
	private Date finishTime;
	
	public Integer getRepairId() {
		return repairId;
	}
	public void setRepairId(Integer repairId) {
		this.repairId = repairId;
	}
	public Bedroom getBedroom() {
		return bedroom;
	}
	public void setBedroom(Bedroom bedroom) {
		this.bedroom = bedroom;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Date getRepairTime() {
		return repairTime;
	}
	public void setRepairTime(Date repairTime) {
		this.repairTime = repairTime;
	}
	public boolean isReceived() {
		return received;
	}
	public void setReceived(boolean received) {
		this.received = received;
	}
	public Date getReceiveTime() {
		return receiveTime;
	}
	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}
	public Mainstenance getReceiver() {
		return receiver;
	}
	public void setReceiver(Mainstenance receiver) {
		this.receiver = receiver;
	}
	public boolean isFinished() {
		return finished;
	}
	public void setFinished(boolean finished) {
		this.finished = finished;
	}
	public Date getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}
	
	
}
