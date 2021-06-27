package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="job_titles")
public class JobTitles {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="title")
	private String jobTitle;
	
	
	public JobTitles() {}
	
	public JobTitles(int id, String jobName) {
		super();
		this.id = id;
		this.jobTitle = jobName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJobName() {
		return jobTitle;
	}

	public void setJobName(String jobName) {
		this.jobTitle = jobName;
	}
	
	
	
	
	

}
