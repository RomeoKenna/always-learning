package com.yfk.yfwork.common.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yfk.yfwork.common.entity.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {
}