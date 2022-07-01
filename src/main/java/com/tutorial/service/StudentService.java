package com.tutorial.service;

import com.tutorial.data.Student;
import com.tutorial.exception.BadRequestException;
import com.tutorial.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student addStudent(Student student) {
        boolean studentExist = studentRepository.existsByEmail(student.getEmail());
        if (studentExist) {
            throw new BadRequestException("Email " + student.getEmail() + " taken.");
        }
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

}
