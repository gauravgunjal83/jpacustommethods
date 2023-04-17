package com.csi.controller;

import com.csi.exception.RecordNotFoundException;
import com.csi.model.Employee;
import com.csi.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @PostMapping("/signup")
    public ResponseEntity<Employee> signUp(@Valid @RequestBody Employee employee){
        return new ResponseEntity<>(employeeServiceImpl.signUp(employee), HttpStatus.CREATED);
    }
    @GetMapping("/signin/{empEmailId}/{empPassword}")
    public ResponseEntity<Boolean> signIn(@PathVariable String empEmailId, @PathVariable String empPassword){
        return new ResponseEntity<>(employeeServiceImpl.signIn(empEmailId,empPassword),HttpStatus.CREATED);
    }
    @GetMapping("/getdatabyid/{empId}")

    public ResponseEntity<Optional<Employee>> getDataById(@PathVariable int empId){
    return  ResponseEntity.ok(employeeServiceImpl.getDataById(empId));
    }

    @GetMapping("/getdatabyfirstname/{empFirstName}")

    public  ResponseEntity<List<Employee>> getDataByFirstName(@PathVariable String empFirstName){
        return  ResponseEntity.ok(employeeServiceImpl.getDataByFirstName(empFirstName));
    }

    @GetMapping("/getdatabycontactnumber/{empContactNumber}")

    public ResponseEntity<Employee> getDataByContactNumber(@PathVariable String empContactNumber){
        return ResponseEntity.ok(employeeServiceImpl.getDataByContactNumber(empContactNumber));
    }
    @GetMapping("/getdatabyemailid/{empEmailId}")

    public ResponseEntity<Employee> getDataByEmailId(@PathVariable String empEmailId){
        return ResponseEntity.ok(employeeServiceImpl.getDataByEmailId(empEmailId));
    }

    @PutMapping("/updatedata/{empId}")
    public ResponseEntity<Employee>updateData(@PathVariable int empId ,@Valid @RequestBody Employee employee){
        Employee employee1=employeeServiceImpl.getDataById(empId).orElseThrow(()-> new RecordNotFoundException("Employee id does not exist "));

        employee1.setEmpFirstName(employee.getEmpFirstName());
        employee1.setEmpLastName(employee.getEmpLastName());
        employee1.setEmpSalary(employee.getEmpSalary());
        employee1.setEmpDOB(employee.getEmpDOB());
        employee1.setEmpContactNumber(employee.getEmpContactNumber());
        employee1.setEmpEmailId(employee.getEmpEmailId());
        employee1.setEmpPassword(employee.getEmpPassword());

        employeeServiceImpl.updateData(employee1);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping("/deletedatabyid/{empId}")

    public ResponseEntity<String> deleteDataById(@PathVariable int empId){
        employeeServiceImpl.deleteDataById(empId);
        return ResponseEntity.ok("Data Deleted Successfully");
    }
    @DeleteMapping("/deletealldata")

    public ResponseEntity<String> deleteAllData(){
        employeeServiceImpl.deleteAllData();
        return ResponseEntity.ok("ALl Data Deleted Successfully");
    }
}
