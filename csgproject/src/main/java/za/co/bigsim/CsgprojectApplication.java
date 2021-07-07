package za.co.bigsim;

import java.util.Calendar;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import za.co.bigsim.model.Class;
import za.co.bigsim.model.Student;
import za.co.bigsim.model.Teacher;
import za.co.bigsim.service.ClassService;
import za.co.bigsim.service.StudentService;
import za.co.bigsim.service.TeacherService;

@SpringBootApplication
public class CsgprojectApplication {
	
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private ClassService classService;
	
	@Autowired
	private StudentService studentService;

	public static void main(String[] args) {
		SpringApplication.run(CsgprojectApplication.class, args);
	}
	
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
    
    @Bean
    InitializingBean sendDatabase() {
        return () -> {
        	Teacher teacher1 = new Teacher(1, "Judith", "Masuku", "FEMALE", "Mrs.");
        	teacherService.saveOrUpdate(teacher1);
        	teacherService.saveOrUpdate(new Teacher(2, "Grace", "Musa", "FEMALE", "Ms."));
        	teacherService.saveOrUpdate(new Teacher(3, "Carlos", "Moyo", "MALE", "Mr."));
        	teacherService.saveOrUpdate(new Teacher(4, "Charles", "Kunut", "MALE", "Mr."));
        	teacherService.saveOrUpdate(new Teacher(5, "Nomsa", "Phiri", "FEMALE", "Mrs."));
        	Calendar calndr = Calendar.getInstance();
        	
        	Class clazz1  = new Class(1,"IT011", teacher1, "ENGLISH", calndr.get(Calendar.YEAR), "GRADE 1");
        	Class clazz2  = new Class(2,"IT012", teacher1, "ENGLISH", calndr.get(Calendar.YEAR), "GRADE 2");
        	classService.saveOrUpdate(clazz1);
        	classService.saveOrUpdate(clazz2);
        	classService.saveOrUpdate(new Class(3,"IT013", teacher1, "ENGLISH", calndr.get(Calendar.YEAR), "GRADE 3"));
        	classService.saveOrUpdate(new Class(4,"IT014", teacher1, "ENGLISH", calndr.get(Calendar.YEAR), "GRADE 4"));
        	classService.saveOrUpdate(new Class(5,"IT015", teacher1, "ENGLISH", calndr.get(Calendar.YEAR), "GRADE 5"));
       
        	studentService.saveForClass(new Student(clazz1, "Maria", "Mupande", "Female"), "1");
        	studentService.saveForClass(new Student(clazz1, "Maria1", "Mupande1", "Female"), "1");
        	studentService.saveForClass(new Student(clazz1, "Maria2", "Mupande2", "Female"), "1");
        	studentService.saveForClass(new Student(clazz1, "Maria3", "Mupande3", "Female"), "1");
        	studentService.saveForClass(new Student(clazz2, "Maria4", "Mupande4", "Female"), "2");
        	studentService.saveForClass(new Student(clazz2, "Maria5", "Mupande5", "Female"), "2");
        	studentService.saveForClass(new Student(clazz2, "Maria6", "Mupande6", "Female"), "2");
        	studentService.saveForClass(new Student(clazz2, "Maria7", "Mupande7", "Female"), "2");
        	studentService.saveForClass(new Student(clazz2, "Maria8", "Mupande8", "Female"), "2");
        	studentService.saveForClass(new Student(clazz1, "Maria9", "Mupande9", "Female"), "3");
        	studentService.saveForClass(new Student(clazz1, "Maria10", "Mupande10", "Female"), "3");
        	studentService.saveForClass(new Student(clazz1, "Maria11", "Mupande11", "Female"), "3");
        };
       }

}
