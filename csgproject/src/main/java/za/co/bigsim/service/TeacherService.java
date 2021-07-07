package za.co.bigsim.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.co.bigsim.model.Teacher;
import za.co.bigsim.repository.TeacherRepository;

@Service
public class TeacherService {
	
	@Autowired
	TeacherRepository teacherRepository;
	
	public Teacher saveOrUpdate(Teacher teacher) {
		return teacherRepository.save(teacher);
	}
	
	public Iterable<Teacher> findAllTeachers() {
		return teacherRepository.findAll();
	}

	public Teacher findById(Long Id) {
		return teacherRepository.findById(Id).orElse(null);
	}
}
