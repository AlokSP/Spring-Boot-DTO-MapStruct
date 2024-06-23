package com.example.demo.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Student;
import com.example.demo.mapper.AutoStudentmapper;
import com.example.demo.repo.StudentRepository;
import com.example.demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repo;

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student = AutoStudentmapper.Mapper.MapToStudent(studentDto);
        Student savedStudent = repo.save(student);
        return AutoStudentmapper.Mapper.MapToStudentDto(savedStudent);
    }

    @Override
    public StudentDto findByRollNo(int rollNo) {
        Student student = repo.findById(rollNo).get();
        return AutoStudentmapper.Mapper.MapToStudentDto(student);
    }

    @Override
    public List<StudentDto> findAllStudents() {
        List<Student> students = repo.findAll();
        List<StudentDto> studentDtoes = students.stream()
                .map((student) -> AutoStudentmapper.Mapper.MapToStudentDto(student)).collect(Collectors.toList());
        return studentDtoes;
    }

    @Override
    public StudentDto updateSudent(int rollNo, StudentDto studentDto) {
        Student student = repo.findById(rollNo).get();
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setEmail(studentDto.getEmail());
        Student savedStudent = repo.save(student);
        return AutoStudentmapper.Mapper.MapToStudentDto(savedStudent);
    }

    @Override
    public String deleteStudent(int rollNo) {
        Student student = repo.findById(rollNo).get();
        repo.delete(student);
        return "Deleted Succesfully";
    }

}
