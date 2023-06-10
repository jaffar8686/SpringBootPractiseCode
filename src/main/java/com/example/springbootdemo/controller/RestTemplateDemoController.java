package com.example.springbootdemo.controller;


import com.example.springbootdemo.model.Employee;
import com.example.springbootdemo.model.EmployeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.awt.*;

@RestController
@RequestMapping("/rest/template")
public class RestTemplateDemoController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/get/employees")
    public EmployeeResponse getListOfEmployees(){
       return restTemplate.getForObject("https://dummy.restapiexample.com/api/v1/employees", EmployeeResponse.class);
    }

    @PostMapping("/save/employee")
    public Object saveEmployee(@RequestBody Employee employee){
        return restTemplate.postForObject("https://dummy.restapiexample.com/api/v1/create",employee,Object.class);
    }
}
