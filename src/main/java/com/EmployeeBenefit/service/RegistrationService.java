package com.EmployeeBenefit.service;

import com.EmployeeBenefit.model.Employee;
import com.EmployeeBenefit.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class RegistrationService {
    public  static  String INVALID_EMAIL="Invalid Email.";

    @Autowired
    EmployeeRepository employeeRepository;

    public String registerEmployee(Employee employee) {
        employee.setRegistration_id(UUID.randomUUID().toString());
        return employeeRepository.insert(employee);

    }

    public boolean validateEmail(String email) {
        String regex = "^(.+)@(.+)$";
        //Compile regular expression to get the pattern
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

}
