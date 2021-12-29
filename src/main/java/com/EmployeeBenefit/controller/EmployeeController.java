package com.EmployeeBenefit.controller;


import com.EmployeeBenefit.model.Employee;
import com.EmployeeBenefit.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController

public class EmployeeController {
    @Autowired
    RegistrationService registrationService;

    @PostMapping("/employees")
    public String createEmployee(@RequestBody @Valid Employee employee) {
        if (!registrationService.validateEmail(employee.getEmail()))
            return RegistrationService.INVALID_EMAIL;
        return registrationService.registerEmployee(employee);
    }

}
