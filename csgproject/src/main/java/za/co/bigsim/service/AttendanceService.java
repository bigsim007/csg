package za.co.bigsim.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.co.bigsim.exception.AttetanceFullForDayException;
import za.co.bigsim.model.Attendance;
import za.co.bigsim.model.Class;
import za.co.bigsim.model.EPeriod;
import za.co.bigsim.model.Student;
import za.co.bigsim.repository.AttendanceRepository;

@Service
public class AttendanceService {
	
	@Autowired
	ClassService classService;
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	AttendanceRepository attendanceRepository;
	
	public Attendance saveOrUpdate(Attendance attendance) {
		return attendanceRepository.save(attendance);
	}

	public Iterable<Attendance> createAttendance(String clazz_id) {
		
		Class clazz = classService.findClassById(clazz_id);
		
		Iterable<Student> students = studentService.getListOfStudentsInClass(clazz_id);
		List<Attendance> list = new ArrayList<Attendance>();
		
		for(Student student : students) {
			Attendance att = new Attendance(student, new Date(), clazz);
			EPeriod period = getPeriod(clazz, student, att.getDate());
			if (period == null)
				throw new AttetanceFullForDayException("The students have already register for 6 periods");
			
			att.setPeriod(period);
			attendanceRepository.save(att);  
			list.add(att);
		}
		
		return list;
	}
	
	EPeriod getPeriod(Class clazz, Student student, Date date) {	
		
		if (attendanceRepository.findByClazzAndDateAndPeriodAndStudent(clazz, date, EPeriod.PERIOD_ONE, student) == null)
			return EPeriod.PERIOD_ONE;
		else if (attendanceRepository.findByClazzAndDateAndPeriodAndStudent(clazz, date, EPeriod.PERIOD_TWO, student) == null)
			return EPeriod.PERIOD_TWO;
		else if (attendanceRepository.findByClazzAndDateAndPeriodAndStudent(clazz, date, EPeriod.PERIOD_THREE, student) == null)
			return EPeriod.PERIOD_THREE;
		else if (attendanceRepository.findByClazzAndDateAndPeriodAndStudent(clazz, date, EPeriod.PERIOD_FOUR, student) == null)
			return EPeriod.PERIOD_FOUR;
		else if (attendanceRepository.findByClazzAndDateAndPeriodAndStudent(clazz, date, EPeriod.PERIOD_FIFE, student) == null)
			return EPeriod.PERIOD_FIFE;
		else if (attendanceRepository.findByClazzAndDateAndPeriodAndStudent(clazz, date, EPeriod.PERIOD_SIX, student) == null)
			return EPeriod.PERIOD_SIX; 
		else return null;
	}

	public List<Attendance> updateAttendance(@Valid List<Attendance> att) {

		List<Attendance> att1 = new ArrayList<Attendance>();
		for(Attendance attendance : att) {
			Attendance attendance1 = attendanceRepository.findById(attendance.getId()).orElse(null);
			if(attendance1 != null) {
				attendance.setClazz(attendance1.getClazz());
				attendance.setStudent(attendance1.getStudent());
			}
			saveOrUpdate(attendance);
			att1.add(attendance);
		}
		return att1;
	}
	
	public Attendance findByClazzAndDateAndPeriodAndStudent(Class clazz, Date date, EPeriod period, Student student) {
		return attendanceRepository.findByClazzAndDateAndPeriodAndStudent(clazz, date, EPeriod.PERIOD_ONE, student);
	}
	
	public Long countPresent(Class clazz, EPeriod period, Date start, Date end, boolean present, Student student) {
		return attendanceRepository.countPresent(clazz, period, start, end, present, student);
	}
}
