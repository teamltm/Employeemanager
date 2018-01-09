package com.assia.domain;

import com.assia.model.departerment.DepartermentForm;
import com.assia.model.departerment.DepartermentModel;
import com.assia.model.employee.EmployeeModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employees")
@Data
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)    private BigInteger id;
    private String full_name;
    private String age;
    private Float salary;
    private String phone;
    private String email;
    private String sex;
    private String address;
    private String image;
    private LocalDateTime start_day_work;

    @ManyToOne
    @JoinColumn(name = "departerment_id")
    private Departerment departerment;

    public EmployeeModel toEmployeeModel() {
        EmployeeModel rs = new EmployeeModel();
        rs.setId(id);
        rs.setName(full_name);
        rs.setAge(age);
        rs.setSalary(salary);
        rs.setPhone(phone);
        rs.setEmail(email);
        rs.setSex(sex);
        rs.setAddress(address);
        rs.setImage(image);
        rs.setStart_day_work(start_day_work);
        return rs;
    }
}
