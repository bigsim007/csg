package za.co.bigsim.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import za.co.bigsim.model.Teacher;
import za.co.bigsim.service.MapValidationErrorService;
import za.co.bigsim.service.TeacherService;

@RestController
@RequestMapping("api/teacher")
public class TeacherController {
	
	@Autowired
   	private MapValidationErrorService mapValidationErrorService;
	
	@Autowired
	private TeacherService teacherService;
	
	@PostMapping("")
	public ResponseEntity<?> addTeacher(@Valid @RequestBody Teacher teacher,
			BindingResult result){
		
		ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap!=null) return errorMap;
        
        Teacher teacher1 = teacherService.saveOrUpdate(teacher);
        
        return new ResponseEntity<Teacher>(teacher1, HttpStatus.CREATED);
        
	}
	
	@GetMapping("")
	public Iterable<Teacher> getTeachers(){
		return teacherService.findAllTeachers();
	}
}
