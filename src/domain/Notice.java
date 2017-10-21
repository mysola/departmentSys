package domain;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="notice_inf")
public class Notice {
	@Id @Column(name="notice_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer noticeId;
	
	@Column(length=50)
	private String title;
	
	@Lob
	@Basic(fetch=FetchType.LAZY)
	private String text;
	
	@Temporal(TemporalType.DATE)
	private Date time;
	
	@ManyToOne(targetEntity=SysManager.class)
	@JoinColumn(name="manager_id",referencedColumnName="manager_id",nullable=false)
	private SysManager publisher;

	public Integer getNoticeId() {
		return noticeId;
	}


	public void setNoticeId(Integer noticeId) {
		this.noticeId = noticeId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
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
