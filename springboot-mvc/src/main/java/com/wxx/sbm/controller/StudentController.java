package com.wxx.sbm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class StudentController {

    @GetMapping("/names/{name}")
    public String getName(@PathVariable String name)
    {
        return Objects.isNull(name)?"":"Even";
    }

}
