package com.ddlab.rnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ddlab.rnd.entity.Employee;
import com.ddlab.rnd.service.EmpService;

@RestController
@RequestMapping("/home")
@CrossOrigin
public class EmployeeController {

  @Autowired private EmpService empService;

  //http://localhost:8082/emp/home/id/11
  @GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Employee> getLocationByPincode(@PathVariable("id") String id) {
    System.out.println("Org Service :::" + empService);
    return new ResponseEntity<Employee>(empService.getEmployeeByid(id), HttpStatus.OK);
  }
}
