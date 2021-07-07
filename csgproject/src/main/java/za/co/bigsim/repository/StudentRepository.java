package za.co.bigsim.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import za.co.bigsim.model.Class;
import za.co.bigsim.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long>{

	Iterable<Student> findAllByClazz(Class clazz);

}
