package za.co.bigsim.report;

import java.sql.Date;
import java.sql.Time;
import java.util.Map;

public class DailyReport {

	private String className; 
	private String grade; 
	private Date date; 
	private Time time;
	private Map<String, Boolean> students ;
	
	public DailyReport() {
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Map<String, Boolean> getStudents() {
		return students;
	}

	public void setStudents(Map<String, Boolean> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "DailyReport [className=" + className + ", grade=" + grade + ", date=" + date + ", time=" + time
				+ ", students=" + students + "]";
	}

}
