package com.nishintgoyal.Caching.Services;

import com.nishintgoyal.Caching.DTOs.StudentDto;
import com.nishintgoyal.Caching.Entites.Student;
import com.nishintgoyal.Caching.Repositories.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService
{
    private final ModelMapper modelMapper;
    private final StudentRepo studentRepo;

    public String save(StudentDto s)
    {
        Student str=modelMapper.map(s, Student.class);
        studentRepo.save(str);
        return "Saved";
    }

    public List<StudentDto> getAllNames()
    {
        List<Student> studentList = studentRepo.findAll();
        List<StudentDto> studentDtos = studentList.stream().map(record -> modelMapper.map(record, StudentDto.class)).toList();
        return studentDtos;
    }

    @Cacheable(cacheNames = "student",key = "#id")
    public StudentDto getById(Long id)
    {
        Student student = studentRepo.findById(id).orElse(null);
        StudentDto studentDto = modelMapper.map(student, StudentDto.class);
        return  studentDto;
    }
}
