package com.meziane.springboottuto.Student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
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
    @Transactional
    public void updateStudent(Long id,String name,String email) {
        Student found=studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student with the id "+ id+"don't exist"));

        if (name != null && !name.isEmpty() && !Objects.equals(found.getName(),name)){
            found.setName(name);
        }

        if (email != null && !email.isEmpty() && !Objects.equals(found.getEmail(),email)){
            Optional<Student> optionalStudent = studentRepository.findStudentByEmail(email);
            if (optionalStudent.isPresent()){
                throw new IllegalArgumentException("Email taken");
            }
            found.setEmail(email);
        }


    }
}
