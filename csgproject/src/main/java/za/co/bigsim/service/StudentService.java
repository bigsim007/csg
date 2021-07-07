package za.co.bigsim.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.co.bigsim.model.Class;
import za.co.bigsim.model.Student;
import za.co.bigsim.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	ClassService classService;
	
	public Student saveOrUpdate(Student student) {
		return studentRepository.save(student);
	}
	
	public Student findById(String Id) {
		return studentRepository.findById(Long.valueOf(Id)).orElse(null);
	}
	
	public Iterable<Student> getListOfStudentsInClass(Class clazz){
		return studentRepository.findAllByClazz(clazz);
	}
	
	public Iterable<Student> getListOfStudentsInClass(String clazz_Id){
		return getListOfStudentsInClass(classService.findClassById(clazz_Id));
	}
	
	public Iterable<Student> getAllClasses(){
		return studentRepository.findAll();
	}

	public Student saveForClass(Student student,String clazz_id) {	
		student.setClazz(classService.findClassById(clazz_id));
		
		return saveOrUpdate(student);		
	}

}
