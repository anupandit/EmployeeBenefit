package com.EmployeeBenefit;

import com.EmployeeBenefit.controller.EmployeeController;
import com.EmployeeBenefit.model.Employee;
import com.EmployeeBenefit.repository.EmployeeRepository;
import com.EmployeeBenefit.service.RegistrationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;
import java.util.UUID;

import static org.mockito.Mockito.when;

@SpringBootTest
class EmployeeBenefitApplicationTests {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private EmployeeController employeeController;
	@Autowired
	private RegistrationService registrationService;

	@Test
	public void createEmployeeTest() {
		Employee emp1 = Employee.builder().id("1101").dept("Emp_dept").name("Emp_Name").registration_id(UUID.randomUUID().toString()).email("Emp_email.com").build();
		String employee = employeeController.createEmployee(emp1);
		Assertions.assertNotNull(employee);
	}

	@Test
	public void registerEmployeeTest(){
		Employee emp2 = Employee.builder().registration_id(UUID.randomUUID().toString()).build();
		String employee = registrationService.registerEmployee(emp2);
		Assertions.assertNotNull(employee);
	}

	@Test
	public void setEmployeeRepository(){
		Employee emp3 = Employee.builder().registration_id(UUID.randomUUID().toString()).id("11002").name("empName").email("empEMail@email.com").dept("empDept").build();
		String employee = registrationService.registerEmployee(emp3);
		Assertions.assertNotNull(employee);

	}

	@Test
	public void validateEmailTest(){
		String e1="abc@domain.co.in";
		String e2="abc@domain.com";
		String e3="abc.name@domain.com";
		String e4="abc#@domain.co.in";
		String e5="abc@domain.com";
		String e6="abc@domaincom";
		String e7="@yahoo.com";
		String e8="v#domain.com";
		Assertions.assertTrue(registrationService.validateEmail(e1));
		Assertions.assertTrue(registrationService.validateEmail(e2));
		Assertions.assertTrue(registrationService.validateEmail(e3));
		Assertions.assertTrue(registrationService.validateEmail(e4));
		Assertions.assertTrue(registrationService.validateEmail(e5));
		Assertions.assertTrue(registrationService.validateEmail(e6));
		Assertions.assertFalse(registrationService.validateEmail(e7));
		Assertions.assertFalse(registrationService.validateEmail(e8));
	}

}
