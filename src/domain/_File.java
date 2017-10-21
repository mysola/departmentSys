package domain;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="file_inf")
public class _File {
	@Id @Column(name="file_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer fileId;
	
	@Column(length=30)
	private String title;
	
	@Column(name="save_path",length=200)
	private String savePath;
	
	@Temporal(TemporalType.DATE)
	private Date time;
	
	@ManyToOne(targetEntity=SysManager.class)
	@JoinColumn(name="manager_id",referencedColumnName="manager_id",nullable=false)
	private SysManager publisher;
	
	public Integer getFileId() {
		return fileId;
	}
	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSavePath() {
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public SysManager getPublisher() {
		return publisher;
	}
	public void setPublisher(SysManager publisher) {
		this.publisher = publisher;
	} 
	
}
