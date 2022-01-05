package com.local.dao;

import com.local.domain.Student;

import java.util.List;

public interface IStudentDao {

    // 动态SQL，要使用java对象作为参数
    List<Student> selectStudentIf(Student student);

    // 动态sql，使用where标签
    List<Student> selectStudentWhere(Student student);

    // foreach用法1
    List<Student> selectStudentForeachOne(List<Integer> integerList);

    // foreach用法2
    List<Student> selectStudentForeachTwo(List<Student> studentList);
}
