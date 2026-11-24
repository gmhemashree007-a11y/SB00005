package com.example.SB00005;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Student insert(Student student)
    {
        return studentRepository.save(student);
    }

    public List<Student> insertmany(List<Student> student)
    {
        return studentRepository.saveAll(student);
    }

    public List<Student> fetch()
    {
        return studentRepository.findAll();
    }

    public Student fetchbyid(Integer id)
    {
        return studentRepository.findById(id).orElse(null);
    }

    public Student update(Integer id, Student student)
    {
        Student student1=studentRepository.findById(id).orElse(null);
        if(student1 !=null)
        {
            student1.setAge(student.getAge());
            student1.setName(student.getName());
            student1.setBranch(student.getBranch());
            return studentRepository.save(student1);
        }
        return null;
    }

    /*public String delete(Integer id)
    {
        if(studentRepository.existsById(id))
        {
            studentRepository.deleteById(id);
            return "data deleted";
        }
        return "data not deleted";
    }*/

    public Student delete(Integer id)
    {
        if(studentRepository.existsById(id))
        {
            studentRepository.deleteById(id);
            return null;
        }
        return null;
    }
}
