package studentmanagement.StudentManagement;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StudentManagementApplication {

	@Autowired
	private StudentRepository repository;

//	private String name = "Enami Kouji";
//	private String age = "37";

	public static void main(String[] args) {
		//localhost:8080
		SpringApplication.run( StudentManagementApplication.class, args);
	}
	@GetMapping("/student")
//	@GetMapping("/studentInfo")
	public String getStudent(@RequestParam String name){
//	public String getStudentInfo(){
		student student = repository.searchByName(name);
//		student student = new student();
//		student.setName("EnamiKouji");
//		String name = student.getName();
		return student.getName() + " " + student.getAge() + "歳";
//		return name + " " + age + "歳";
	}
	@PostMapping("/student")
//	@PostMapping("/studentInfo")
	public void registerStudent(@RequestBody student student){
//	public void setStudentInfo(String name,String age){
//		this.name = name;
//		this.age = age;
		repository.registerStudent(student.getName(),student.getAge());
	}

	@PatchMapping ("/student")
	public void updateStudentName(String name,int age){
//		this.name = name;
		repository.updateStudent(name,age);
	}

	@DeleteMapping("/student")
	public void deleteStudent(String name){
		repository.deleteStudent(name);
	}

//	@GetMapping("/name")
//	public String getName() {
//		return name;
//	}
//
//	@GetMapping("/age")
//	public String getAge(){
//		return age;
//	}


//データ一覧
	@GetMapping("/students")
	public String getAllStudents(){
		List<student> students = repository.findAll();
		StringBuilder result = new StringBuilder();
		for (student student : students){
			result.append(student.getName())
					.append(" ")
					.append(student.getAge())
					.append("歳");
		}
		return result.toString();
	}
}
