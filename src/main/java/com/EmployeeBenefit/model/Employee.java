
package com.EmployeeBenefit.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@Data
@Builder
public class Employee {
    private String registration_id;
    private String id;
    private String name;
    private String dept;
    private String email;

}
