package za.co.bigsim.report;

public class TermReport {

	private String className; 
	private String grade;
	private String studentName; 
	private Long attended; 
	private Long missed;
	
	public TermReport() {}

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

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Long getAttended() {
		return attended;
	}

	public void setAttended(Long attended) {
		this.attended = attended;
	}

	public Long getMissed() {
		return missed;
	}

	public void setMissed(Long missed) {
		this.missed = missed;
	}

	@Override
	public String toString() {
		return "TermReport [className=" + className + ", grade=" + grade + ", studentName=" + studentName
				+ ", attended=" + attended + ", missed=" + missed + "]";
	}

}
