package com.assia.service;

import com.assia.domain.Departerment;
import com.assia.domain.Employees;
import com.assia.model.employee.EmployeeForm;
import com.assia.repository.DepartermentRepository;
import com.assia.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public List<com.assia.model.employee.EmployeeModel> getAll(){
            List<com.assia.model.employee.EmployeeModel> rs = new ArrayList<>();
            this.employeeRepository.findAll().forEach(departerment -> {rs.add(departerment.toEmployeeModel());
            });
            return rs;
}
    public Optional<Employees> getById(BigInteger id) {
        return this.employeeRepository.getById(id);
    }
    public void delete(BigInteger id){
        getById(id).ifPresent(this.employeeRepository::delete);
    }
    public Optional<Employees> update(BigInteger id, EmployeeForm employeeForm){
        return getById(id).map(employees -> {
            employees.setFull_name(employeeForm.getName());
            return this.employeeRepository.save(employees);
        });
    }
    public Employees create(EmployeeForm employeeForm){
        Employees employees = new Employees();
        employees.setFull_name(employeeForm.getName());
        return this.employeeRepository.save(employees);
    }
}
