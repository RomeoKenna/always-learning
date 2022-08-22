package com.yfk.yfwork.common.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yfk.yfwork.common.Serrvice.StudentService;
import com.yfk.yfwork.common.entity.Result;
import com.yfk.yfwork.common.entity.Student;
import com.yfk.yfwork.common.mapper.StudentMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName:StudentServiceImpl
 * Author:yufukang
 * Version:1.0
 * Time:2022/8/8 14:04
 */
@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;


    /**
     * get student by name
     * @param name 姓名
     * @return Student
     */
    @Override
    public Result<List<Student>> getStudentByName(String name) {
        Result<List<Student>> result;
        try {
            QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
            queryWrapper.like("name", name);
            List<Student> studentList = studentMapper.selectList(queryWrapper);
            result = Result.success("查询成功", studentList);
        } catch (Exception e) {
            return Result.fail(e.getMessage(), null);
        }
        return result;
    }

    /**
     * add student
     * @param student 学生实体
     * @return Student
     */
    @Override
    @Transactional
    public Result<Student> addStudent(Student student) {
        Result<Student> result;
        try {
            studentMapper.insert(student);
            result = Result.success("添加成功", student);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Result.fail(e.getMessage(), null);
        }
        return result;
    }
}
