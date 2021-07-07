package za.co.bigsim.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.co.bigsim.model.Class;
import za.co.bigsim.model.Teacher;
import za.co.bigsim.repository.ClassRepository;

@Service
public class ClassService {

	@Autowired
	ClassRepository classRepository;
	
	@Autowired
	TeacherService teacherService;
	
	public Class saveOrUpdate(Class clazz) {
		
		Teacher teacher = teacherService.findById(clazz.getTeacher().getId());
		clazz.setTeacher(teacher);
		return classRepository.save(clazz);
	}
	
	public Class findClassById(String clazz_id) {
		return classRepository.findById(Long.valueOf(clazz_id)).orElse(null);
	}
	
	public Iterable<Class> findAllClasses() {
		return classRepository.findAll();
	}
}
