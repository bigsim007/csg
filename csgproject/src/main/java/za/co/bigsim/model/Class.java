package za.co.bigsim.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Class {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	
	private String name;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="teacher_id")
	@JsonIgnore
	private Teacher teacher;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy =  "clazz", orphanRemoval = true)
	@JsonIgnore
    Set < Student > students = new HashSet < Student > ();
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy =  "clazz", orphanRemoval = true)
	@JsonIgnore
    Set < Attendance > attendance = new HashSet < Attendance > ();
	
	private String subject;
	
	private String grade;
	
	@JsonFormat( pattern = "yyyy")
	private int year;
	
	@JsonFormat( pattern = "yyyy-mm-dd")
	@Column(updatable = false)
    private Date created_At;
    
	@JsonFormat(pattern = "yyyy-mm-dd")
    private Date updated_At;
	
	public Class() {}	
	
	public Class(long id, String name, Teacher teacher, String subject, int year, String grade) {
		super();
		Id = id;
		this.name = name;
		this.teacher = teacher;
		this.subject = subject;
		this.year = year;
		this.grade = grade;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	public Set<Attendance> getAttendance() {
		return attendance;
	}

	public void setAttendance(Set<Attendance> attendance) {
		this.attendance = attendance;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	
	public Set<Student> getStudents() { return students; }
	  
	public void setStudents(Set<Student> students) { this.students = students; }


	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Date getCreated_At() {
		return created_At;
	}

	public void setCreated_At(Date created_At) {
		this.created_At = created_At;
	}

	public Date getUpdated_At() {
		return updated_At;
	}

	public void setUpdated_At(Date updated_At) {
		this.updated_At = updated_At;
	}
	
	@PrePersist protected void onCreate(){ this.created_At = new Date(); }
	  
	@PreUpdate protected void onUpdate() { this.updated_At = new Date(); }

	@Override
	public String toString() {
		return "Class [Id=" + Id + ", name=" + name + ", teacher=" + teacher + ", students=" + //students+
				 ", subject=" + subject + ", year=" + year + ", created_At=" + created_At + ", updated_At="
				+ updated_At + "]";
	}
}
