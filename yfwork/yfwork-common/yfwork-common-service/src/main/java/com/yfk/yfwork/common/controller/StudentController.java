package com.yfk.yfwork.common.controller;

import com.yfk.yfwork.common.Serrvice.StudentService;
import com.yfk.yfwork.common.entity.Result;
import com.yfk.yfwork.common.entity.Student;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName:StudentController
 * Author:yufukang
 * Version:1.0
 * Time:2022/8/8 14:14
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    @Resource
    private StudentService studentService;

    @PostMapping("/add")
    public Result<Student> add(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @GetMapping("/getStudentByName")
    public Result<List<Student>> getStudent(@RequestParam String name) {
        return studentService.getStudentByName(name);
    }
}
