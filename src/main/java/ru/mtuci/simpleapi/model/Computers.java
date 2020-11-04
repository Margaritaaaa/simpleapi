package ru.mtuci.simpleapi.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
//import org.hibernate.validator.constraints.SafeHtml;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Computers extends AbstractBaseEntity {
    @NotBlank
    //@SafeHtml
    private String type;
    @NotBlank
    //@SafeHtml
    private String cpu;
    @NotBlank
    //@SafeHtml
    private String name;
    @NotBlank
    //@SafeHtml
    private String employee;
}
