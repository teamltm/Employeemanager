package com.assia.domain;

import com.assia.model.departerment.DepartermentModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departerments")
@Data
public class Departerment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;
    private String name;

    @OneToMany(mappedBy = "departerment", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Employees> employees = new ArrayList<>();

    public com.assia.model.departerment.DepartermentModel toDeparterment() {
        com.assia.model.departerment.DepartermentModel rs = new com.assia.model.departerment.DepartermentModel();
        rs.setId(id);
        rs.setName(name);
        return rs;
    }
}
