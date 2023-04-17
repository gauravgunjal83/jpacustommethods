package com.csi.dao;

import com.csi.model.Employee;
import com.csi.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeDaoImpl {

    @Autowired
    EmployeeRepository employeeRepositoryImpl;


    public Employee signUp(Employee employee){
        return  employeeRepositoryImpl.save(employee);
    }

    public boolean signIn(String empEmailId,String empPassword){
        boolean flag =false;
        if (employeeRepositoryImpl.findByEmpEmailIdAndEmpPassword(empEmailId,empPassword).size()>=1){
            flag=true;
        }
        return flag;
    }

    public Optional<Employee> getDataById(int empId){
        return employeeRepositoryImpl.findById(empId);
    }

    public List<Employee> getDataByFirstName(String empFirstName){
        return  employeeRepositoryImpl.findByEmpFirstName(empFirstName);
    }
    public Employee getDataByContactNumber(String empContactNumber){
        return employeeRepositoryImpl.findByEmpContactNumber(empContactNumber);
    }
    public  Employee getDataByEmailId(String empEmailId){
        return employeeRepositoryImpl.findByEmpEmailId(empEmailId);
    }

    public Employee updateData(Employee employee){
         return  employeeRepositoryImpl.save(employee);
    }
    public void deleteDataById(int empId){
         employeeRepositoryImpl.deleteById(empId);
    }
    public void deleteAllData(){
        employeeRepositoryImpl.deleteAll();
    }
}
