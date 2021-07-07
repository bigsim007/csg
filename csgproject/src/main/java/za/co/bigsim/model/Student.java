/**
 * 
 */
package za.co.bigsim.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author simba
 *
 */
@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="clazz_id")
	@JsonIgnore
	private Class clazz;
	private String name;

	private String surname;
	private String gender;
	
	@OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, mappedBy = "student", orphanRemoval = true)
	@JsonIgnore
	private List<Attendance> attendance;
	
	public Student() {}
	
	

	public Student(Class clazz, String name, String surname, String gender) {
		super();
		this.clazz = clazz;
		this.name = name;
		this.surname = surname;
		this.gender = gender;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getFullName() {
		return getName() + " " + getSurname();
	}
	
	public Class getClazz() { return clazz; }
	
	public void setClazz(Class clazz) { this.clazz = clazz; }
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<Attendance> getAttendance() {
		return attendance;
	}

	public void setAttendance(List<Attendance> attendance) {
		this.attendance = attendance;
	}

	@Override
	public String toString() {
		return "Student [Id=" + Id + ", class=" + //clazz + 
				", name=" + name + ", surname=" + surname
				+ ", gender=" + gender + "]";
	}
	
}
