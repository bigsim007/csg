/** 
 * 
 */
package za.co.bigsim.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author simba
 *
 */
@Entity
public class Attendance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Student student;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date date;
	
	@ColumnDefault("true")
	private boolean present = true;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="clazz_id")
	@JsonIgnore
	private Class clazz;
	
	@Enumerated(EnumType.STRING)
	private EPeriod period;
	
	public Attendance() {}	
	
	public Attendance(Student student, Date date,Class clazz) {
		super();
		this.student = student;
		this.date = date;
		this.clazz = clazz;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public boolean isPresent() {
		return present;
	}

	public void setPresent(boolean present) {
		this.present = present;
	}

	public Student getStudent() {
		return student;
	}

	public Class getClazz() {
		return clazz;
	}

	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}

	
	public EPeriod getPeriod() {
		return period;
	}

	public void setPeriod(EPeriod period) {
		this.period = period;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Attendance [Id=" + Id + ", student=" + student + ", date=" + date
				+ ", classRegister="; //+ clazz + "]";
	}
	
}
