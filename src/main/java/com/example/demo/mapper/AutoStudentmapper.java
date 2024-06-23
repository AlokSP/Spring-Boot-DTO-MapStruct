package com.example.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Student;

@Mapper
public interface AutoStudentmapper {
    AutoStudentmapper Mapper = Mappers.getMapper(AutoStudentmapper.class);

    public Student MapToStudent(StudentDto studentDto);

    public StudentDto MapToStudentDto(Student student);

}
