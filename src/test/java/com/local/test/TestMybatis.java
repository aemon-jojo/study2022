package com.local.test;

import com.local.dao.IStudentDao;
import com.local.domain.Student;
import com.local.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestMybatis {

    @Test
    public void testSelectStudentIf(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        IStudentDao dao = sqlSession.getMapper(IStudentDao.class);
        Student student = new Student();
        //student.setAge(20);
        //student.setName("李四");

        //student.setName("王五");
        student.setName("");
        student.setAge(20);
        List<Student> students = dao.selectStudentIf(student);
        for (Student stu : students){
            System.out.println(stu);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectStudentWhere(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        IStudentDao dao = sqlSession.getMapper(IStudentDao.class);
        Student student = new Student();
        //student.setName("");
        //student.setAge(20);
        student.setName("黄七");
        student.setAge(0);
        List<Student> students = dao.selectStudentWhere(student);
        for (Student stu : students){
            System.out.println(stu);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectStudentForeachOne(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        IStudentDao dao = sqlSession.getMapper(IStudentDao.class);
        List<Integer> list = new ArrayList<>();
        list.add(1001);
        list.add(1002);
        list.add(1003);
        List<Student> students = dao.selectStudentForeachOne(list);
        for (Student stu : students){
            System.out.println(stu);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectStudentForeachTwo(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        IStudentDao dao = sqlSession.getMapper(IStudentDao.class);
        List<Student> list = new ArrayList<>();
        for(int i = 1; i < 4; i++){
            Student student = new Student();
            student.setId(1000 + i);
            list.add(student);
        }
        Student student = new Student();
        student.setId(1006);
        list.add(student);
        List<Student> students = dao.selectStudentForeachTwo(list);
        for (Student stu : students){
            System.out.println(stu);
        }
        sqlSession.close();
    }

}
