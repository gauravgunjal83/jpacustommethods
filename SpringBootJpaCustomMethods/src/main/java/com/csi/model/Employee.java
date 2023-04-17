package com.csi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue

    private  int empId;

    private String empFirstName;

    @Size(min = 2,message = "Last Name must be more than 1 character")
    private  String empLastName;

    private  double empSalary;

    @Column(unique = true)
    @Size(min = 10 ,max = 10,message = "Contact Number should be 10 digit")
    private String empContactNumber;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date empDOB;

    @Email(message = "Email Id must be valid")
    private String empEmailId;

    @Size(min = 4, message = "Password included atleast 4 characters ")
    private String empPassword;

}
