package za.co.bigsim.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import za.co.bigsim.model.Attendance;
import za.co.bigsim.model.Class;
import za.co.bigsim.model.EPeriod;
import za.co.bigsim.model.Student;

@Repository
public interface AttendanceRepository extends CrudRepository<Attendance, Long>{
	
	Iterable<Attendance> findByClazzAndDate(Class clazz, Date date);
	
	Attendance findByClazzAndDateAndPeriodAndStudent(Class clazz, Date date, EPeriod period, Student student);
	
	@Query(value = "SELECT count(id) FROM Attendance where clazz = :clazz AND period = :period AND date >= :start AND date <= :end AND present = :present AND student = :student ")
	public Long countPresent(Class clazz, EPeriod period, @Param("start") Date start, @Param("end") Date end, boolean present, Student student);

}
