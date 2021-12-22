package com.flybird.demo.controller;

import com.flybird.demo.entity.StudentEntity;
import com.flybird.demo.model.ResultModel;
import com.flybird.demo.repository.StudentRepository;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("student")
public class StudentController {

    @Resource
    StudentRepository repository;

    // insert
    @PostMapping("")
    public ResultModel insert(
            @Valid @RequestBody StudentEntity entity,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return ResultModel.error(result.getAllErrors().get(0).getDefaultMessage());
        }
        repository.save(entity);
        return ResultModel.data("OK");
    }

    // update
    @PatchMapping("")
    public ResultModel update(
            @Valid @RequestBody StudentEntity entity,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return ResultModel.error(result.getAllErrors().get(0).getDefaultMessage());
        }
        if (repository.findById(entity.getId()).isPresent()) {
            repository.save(entity);
            return ResultModel.data("OK");
        }
        return ResultModel.error("ID 不存在");

    }

    // delete
    @DeleteMapping("{id}")
    public ResultModel delete(@PathVariable Long id) {
        Optional<StudentEntity> entity = repository.findById(id);
        if (entity.isPresent()) {
            repository.delete(entity.get());
            return ResultModel.data("OK");
        }
        return ResultModel.error("ID 不存在");

    }

    // select One
    @GetMapping("{id}")
    public ResultModel getOne(@PathVariable Long id) {
        Optional<StudentEntity> entity = repository.findById(id);
        if (entity.isPresent()) {
            return ResultModel.data(entity);
        }
        return ResultModel.error("ID 不存在");

    }

    // select All
    @GetMapping("")
    public ResultModel getAll() {
        return ResultModel.data(repository.findAll());
    }
}
