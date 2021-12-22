package com.flybird.demo.controller;

import com.flybird.demo.model.StudentModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hello")
public class HelloController {

    // hello/path/jack
    @GetMapping("path/{name}")
    public String hello(@PathVariable String name) {
        return "Hello " + name;
    }

    // hello/query?name=jack
    @GetMapping("query")
    public String helloName(@RequestParam("name") String name) {
        return "Hello " + name;
    }

    // hello/object
    @PostMapping("object")
    public String helloObject(StudentModel model) {
        return "Hello " + model.getName();
    }

    // hello/json
    @PostMapping("json")
    public String helloJson(@RequestBody StudentModel model) {
        return "Hello " + model.getName();
    }
}
