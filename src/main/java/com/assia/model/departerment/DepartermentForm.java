package com.assia.model.departerment;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class DepartermentForm {
    @NotBlank
    private String name;
}
