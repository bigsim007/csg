package za.co.bigsim.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;

	@NotBlank(message = "Please enter your name")
	private String name;

	@NotBlank(message = "Please enter your name")
	private String surname;

	private String gender;
	private String title;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy =  "teacher", orphanRemoval = true)
	@JsonIgnore
	private List<Class> clazz;

	public Teacher() {}
	
	

	public Teacher(long id, String name,
			String surname, String gender, String title) {
		super();
		Id = id;
		this.name = name;
		this.surname = surname;
		this.gender = gender;
		this.title = title;
	}



	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public List<Class> getClazz() {
		return clazz;
	}

	public void setClazz(List<Class> clazz) {
		this.clazz = clazz;
	}

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Teacher [Id=" + Id + ", name=" + name + ", surname=" + surname + ", gender=" + gender + ", title="
				+ title + "]";
	}



}
