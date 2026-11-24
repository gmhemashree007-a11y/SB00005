package com.example.SB00005;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/learner")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("/insert")
    public Student insert(@RequestBody Student student)
    {
        return studentService.insert(student);
    }
    @PostMapping("/insertmany")
    public List<Student> insertmany(@RequestBody List<Student> student)
    {
        return studentService.insertmany(student);
    }

    @GetMapping("/fetch")
    public List<Student> fetch()
    {
        return studentService.fetch();
    }
    @GetMapping("/fetch/{id}")
    public Student fetchbyid(@PathVariable Integer id)
    {
        return studentService.fetchbyid(id);
    }

    @PutMapping("/update/{id}")
    public Student update(@PathVariable Integer id,@RequestBody Student student)
    {
        return studentService.update(id,student);
    }

    /*@DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id)
    {
        return studentService.delete(id);
    }*/
    @DeleteMapping("/delete/{id}")
    public Student delete(@PathVariable Integer id)
    {
        return studentService.delete(id);
    }
}
