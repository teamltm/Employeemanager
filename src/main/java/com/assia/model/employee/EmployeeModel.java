package com.assia.model.employee;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.math.BigInteger;
import java.time.LocalDateTime;
@Data
public class EmployeeModel {
    private BigInteger id;
    private String name;
    private String age;
    private Float salary;
    private String phone;
    private String email;
    private String sex;
    private String address;
    private String image;
    private LocalDateTime start_day_work;

}
