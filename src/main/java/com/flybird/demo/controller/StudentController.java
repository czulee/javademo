package com.flybird.demo.controller;

import com.flybird.demo.model.ResultModel;
import com.flybird.demo.model.StudentModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @RequestMapping("")
    public String sayHello() {
        return "Hello World";
    }

    @RequestMapping("student")
    public ResultModel student() {
        StudentModel student = new StudentModel();
        student.setNo("01");
        student.setName("Jack");
        return ResultModel.data(student);
    }

    @RequestMapping("students")
    public ResultModel students() {
        List<StudentModel> students = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            StudentModel student = new StudentModel();
            student.setNo("01");
            student.setName("Jack");
            students.add(student);
        }
        return ResultModel.data(students);
    }
}
