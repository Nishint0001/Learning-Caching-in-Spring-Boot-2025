package com.nishintgoyal.Caching.Controllers;
import com.nishintgoyal.Caching.DTOs.StudentDto;
import com.nishintgoyal.Caching.Entites.Student;
import com.nishintgoyal.Caching.Services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController
{
    private final StudentService studentService;

    @GetMapping("/all")
    public List<StudentDto> getAll()
    {
        return studentService.getAllNames();
    }

    @GetMapping("/{id}")
    public StudentDto getById(@PathVariable  Long id)
    {
        return studentService.getById(id);
    }


    @PostMapping("/new")
    public String save(@RequestBody StudentDto s)
    {
        return studentService.save(s);
    }


}
