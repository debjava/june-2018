package com.ddlab.rnd.service;

import org.springframework.stereotype.Service;

import com.ddlab.rnd.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmpService {
  @Override
  public Employee getEmployeeByid(String id) {
    Employee emp = new Employee();
    emp.setId(id);
    emp.setName("John Abraham");
    return emp;
  }
}
