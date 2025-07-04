package studentmanagement.StudentManagement;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StudentManagementApplication {

	@Autowired
	private StudentRepository repository;

	@Autowired
	private Students_CoursesRepository coursesRepository;


	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApplication.class, args);
	}

	@GetMapping("/studentList")

	public List<Student> getStudentList() {
		return repository.search();
	}

	@GetMapping("/students_coursesList")

	public List<Students_Courses> getStudents_CoursesList(){
		return coursesRepository.search();
	}
}
