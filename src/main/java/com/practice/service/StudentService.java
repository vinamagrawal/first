package com.practice.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.practice.model.Student;
import com.practice.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("Email already taken.");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException("Student with ID " + studentId + " does not exist.");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "Student with ID " + studentId + " does not exist."));
        // update name
        if (name != null && name.length() > 0 && !name.equals(student.getName())) {
            student.setName(name);
        }
        // update email
        if (email != null && email.length() > 0 && !email.equals(student.getEmail())) {
            Optional<Student> studentOptional = studentRepository.findByEmail(email);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("Email already taken.");
            }
            student.setEmail(email);
        }
    }

}
