package za.co.bigsim.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import za.co.bigsim.model.Attendance;
import za.co.bigsim.model.Class;
import za.co.bigsim.model.Student;
import za.co.bigsim.report.DailyReport;
import za.co.bigsim.report.TermReport;
import za.co.bigsim.service.AttendanceService;
import za.co.bigsim.service.ClassService;
import za.co.bigsim.service.MapValidationErrorService;
import za.co.bigsim.service.ReportService;
import za.co.bigsim.service.StudentService;

@RestController
@RequestMapping("api/class")
public class ClassController {
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	ClassService classService;
	
	@Autowired
	AttendanceService attendanceService;
	
	@Autowired
   	private MapValidationErrorService mapValidationErrorService;
	
	@Autowired
	private ReportService reportService;
	
	@GetMapping("{clazz_id}")
	public Iterable<Student> getClassStudents(@PathVariable String clazz_id){
		Class clazz = classService.findClassById(clazz_id);
		return studentService.getListOfStudentsInClass(clazz);
	}
	
	@PostMapping("{clazz_id}")
	public ResponseEntity<?> addStudent(@Valid @RequestBody Student student, @PathVariable String clazz_id, BindingResult result){
		ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap!=null) return errorMap;
        
        Student student1 = studentService.saveForClass(student, clazz_id);
        
        return new ResponseEntity<Student>(student1, HttpStatus.CREATED);
	}
	
	@PostMapping("")
	public ResponseEntity<?> addClass(@Valid @RequestBody Class clazz,
			BindingResult result){
		
		ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap!=null) return errorMap;
        
        Class clazz1 = classService.saveOrUpdate(clazz);
        
        return new ResponseEntity<Class>(clazz1, HttpStatus.CREATED);
        
	}
	
	@GetMapping("")
	public Iterable<Class> getClazzes(){
		return classService.findAllClasses();
	}
	
	@PostMapping("{clazz_id}/attendance")
	public Iterable<Attendance> createAttandance(@PathVariable String clazz_id){	      
		 return attendanceService.createAttendance(clazz_id);
        
	}
	
	@PostMapping("{clazz_id}/attendance/update")
	public ResponseEntity<?> updateAttendance(@Valid @RequestBody List<Attendance> att,
			BindingResult result){
		
		ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap!=null) return errorMap;
        
        List<Attendance> att1 = attendanceService.updateAttendance(att);
        
        return new ResponseEntity<List<Attendance>>(att1, HttpStatus.CREATED);
        
	}
	
	
	@GetMapping("{clazz_id}/attendance/dailyreport")
	public ResponseEntity<?> getClassDailyAttendance(@PathVariable String clazz_id){		

		Class clazz = classService.findClassById(clazz_id);
		DailyReport dailyReport = reportService.getDailyReport(clazz);
		return new ResponseEntity<DailyReport>(dailyReport, HttpStatus.CREATED);
	}
	
	@GetMapping("{clazz_id}/attendance/termreport/{student_id}/{term}")
	public ResponseEntity<?> getStudentTermReport(@PathVariable String clazz_id, @PathVariable String student_id, @PathVariable String term){
		Student student = studentService.findById(student_id);
		TermReport termReport = reportService.getTermReport(student, term);
		return new ResponseEntity<TermReport>(termReport, HttpStatus.CREATED);
	}

}
