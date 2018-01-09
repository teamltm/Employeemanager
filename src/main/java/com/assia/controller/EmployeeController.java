package com.assia.controller;

import com.assia.domain.Employees;
import com.assia.exception.NotFoundException;
import com.assia.model.employee.EmployeeForm;
import com.assia.model.employee.EmployeeModel;
import com.assia.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET)
    public List<EmployeeModel> getAll(){
        return this.employeeService.getAll();
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public EmployeeModel getById(@PathVariable("id") BigInteger id){
        return  this.employeeService.getById(id).map(Employees::toEmployeeModel).orElseThrow(NotFoundException::new);
    }
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Employees create(@Valid @RequestBody EmployeeForm employeeForm){
        return this.employeeService.create(employeeForm);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Employees update(@PathVariable("id")BigInteger id, @Valid @RequestBody EmployeeForm employeeForm){
        return  this.employeeService.update(id, employeeForm).orElseThrow(NotFoundException::new);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id")BigInteger id){
        this.employeeService.delete(id);
    }
}
