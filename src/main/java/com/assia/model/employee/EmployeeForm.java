package com.assia.model.employee;

import com.assia.model.departerment.DepartermentForm;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class EmployeeForm {
    @NotBlank
    private String name;
    @NotBlank
    private String age;
    @NotBlank
    private Float salary;
    @NotBlank
    private String phone;
    @NotBlank
    private String email;
    @NotBlank
    private String sex;
    @NotBlank
    private String address;
    @NotBlank
    private String image;
    @NotBlank
    private LocalDateTime start_day_work;

    private List<DepartermentForm> departermentForms;
}
