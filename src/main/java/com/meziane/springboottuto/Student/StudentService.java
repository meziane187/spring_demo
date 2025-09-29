package com.meziane.springboottuto.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    public final StudentRepository studentRepository;


    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    public void  AddNewStudent(Student student){
       Optional<Student> found=   studentRepository.findStudentByEmail(student.getEmail());
       if (found.isPresent()){
           throw new IllegalArgumentException("Email taken");
       }
       studentRepository.save(student);

    }

    public void deleteStudent(Long id) {

        boolean exist=studentRepository.existsById(id);
        if(!exist){
            throw new IllegalArgumentException("Student not found");

        }
        studentRepository.deleteById(id);
    }
}
