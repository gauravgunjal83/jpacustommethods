package com.csi.repo;

import com.csi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

    public List<Employee> findByEmpFirstName(String empFirstName);

    public Employee findByEmpContactNumber(String empContactNumber);

    public  Employee findByEmpEmailId(String empEmailId);

    public List<Employee> findByEmpEmailIdAndEmpPassword(String empEmailId,String empPassword);

}
