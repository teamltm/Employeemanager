package com.assia.repository;

import com.assia.domain.Employees;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employees, BigInteger> {
    Optional<Employees> getById(BigInteger id);

}
