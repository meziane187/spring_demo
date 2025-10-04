package com.meziane.springboottuto.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    public final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/allstudents")
    public List<Student> getAllStudent ()
    {
       return  studentService.getAllStudent();
    }

    @PostMapping("/add")
    public void RegisterNewStudent(@RequestBody Student student){
      studentService.AddNewStudent(student) ;

    }
    @DeleteMapping("/delete/{studentId}")
    public void DeleteStudentById(@PathVariable("studentId") Long id){
        studentService.deleteStudent(id);
    }

    @PutMapping("/update/{studentId}")
    public void UpdateStudentById(@PathVariable("studentId") Long id
            ,@RequestParam(required = false) String name
            ,@RequestParam(required = false) String email){
            studentService.updateStudent(id,name,email);
    }

}
