package com.assia.repository;

import com.assia.domain.Departerment;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface DepartermentRepository extends CrudRepository <Departerment, BigInteger>{
    Optional<Departerment> getById(BigInteger id);
}
