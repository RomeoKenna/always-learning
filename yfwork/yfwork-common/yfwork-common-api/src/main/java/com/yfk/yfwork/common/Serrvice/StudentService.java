package com.yfk.yfwork.common.Serrvice;

import com.yfk.yfwork.common.entity.Result;
import com.yfk.yfwork.common.entity.Student;

import java.util.List;

/**
 * InterfaceName:StudentService
 * Author:yufukang
 * Version:1.0
 * Time:2022/8/8 11:04
 */
public interface StudentService {
    /**
     * get student by name
     * @param name 姓名
     * @return List<Student>
     */
    Result<List<Student>> getStudentByName(String name);

    /**
     * add student
     * @param student 学生实体
     * @return Student
     */
    Result<Student> addStudent(Student student);
}
