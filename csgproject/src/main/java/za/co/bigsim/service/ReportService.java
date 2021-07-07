package za.co.bigsim.service;

import java.sql.Date;
import java.sql.Time;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.co.bigsim.model.Attendance;
import za.co.bigsim.model.Class;
import za.co.bigsim.model.EPeriod;
import za.co.bigsim.model.Student;
import za.co.bigsim.report.DailyReport;
import za.co.bigsim.report.TermReport;

@Service
public class ReportService {
	
	public static String TERM_ONE = "1";
	public static String TERM_TWO = "2";
	public static String TERM_THREE = "3";
	public static String TERM_FOUR = "4";
	
	@Autowired
	AttendanceService attendanceService;
	
	public DailyReport getDailyReport(Class clazz) {
		
		DailyReport dailyReport = new DailyReport();
		dailyReport.setClassName(clazz.getName());
		dailyReport.setGrade(clazz.getGrade());
		long now = System.currentTimeMillis();
		dailyReport.setDate(new Date(now));
		dailyReport.setTime(new Time(now));
		
		Map<String, Boolean> students = new HashMap<String, Boolean>();;
		
		for(Student student : clazz.getStudents()) {
			String studentName = student.getFullName();
			Attendance attendance = attendanceService.findByClazzAndDateAndPeriodAndStudent(clazz, new java.util.Date(), EPeriod.PERIOD_ONE, student);
			students.put(studentName, attendance.isPresent());
		}
		
		dailyReport.setStudents(students);
		
		return dailyReport;
	}

	public TermReport getTermReport(Student student, String term) {
		Class clazz = student.getClazz();
		TermReport tempReport = new TermReport();
		tempReport.setClassName(clazz.getName());
		tempReport.setGrade(clazz.getGrade());
		tempReport.setStudentName(student.getFullName());
		
		String[] termdates = termDates(term);
		
		Date from = Date.valueOf(termdates[0]);
		Date to = Date.valueOf(termdates[1]);
		
		tempReport.setAttended(attendanceService.countPresent(clazz, EPeriod.PERIOD_ONE, from, to, true, student));
		
		tempReport.setMissed(attendanceService.countPresent(clazz, EPeriod.PERIOD_ONE, from, to, false, student));
		
		return tempReport;
	}
	
	public String[] termDates(String term) {
		
		String[] dates = new String[2];
		if(TERM_ONE.equalsIgnoreCase(term)) {
			  dates[0] = "2021-01-01";
			  dates[1] = "2021-03-31";
		}else if(TERM_TWO.equalsIgnoreCase(term)) {
			  dates[0] = "2021-04-01";
			  dates[1] = "2021-07-05";
		}else if(TERM_THREE.equalsIgnoreCase(term)) {
			  dates[0] = "2021-07-06";
			  dates[1] = "2021-09-20";
		}else if(TERM_TWO.equalsIgnoreCase(term)) {
			  dates[0] = "2021-09-21";
			  dates[1] = "2021-12-31";
		}
		
		return dates;
	}
}
