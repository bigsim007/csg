package za.co.bigsim.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import za.co.bigsim.model.Teacher;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Long> {

}
