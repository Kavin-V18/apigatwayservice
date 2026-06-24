package com.example.APIgateway.client;

import com.example.EmployeeCustomerModule.dto.CustomerDto;
import com.example.EmployeeCustomerModule.dto.EmployeeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@FeignClient(
        name = "EmployeeCustomerModule",
        url = "http://localhost:8085"
)
public interface EmployeeCustomerClient {

    @GetMapping("/employee")
    List<Optional> getAllEmployee();
    @GetMapping("/employee/id")
    EmployeeDto getEmployeeById(int id);
    @PostMapping("/employee")
    void createEmployee(EmployeeDto employeeDto);
    @PostMapping("/employee/id")
    EmployeeDto updateEmployeeById(int id, EmployeeDto employeeDto);
    @DeleteMapping("/employee/id")
    void deleteEmployee(int id);


    @GetMapping("/customer")
    List<Optional> getAllCustomer();
    @GetMapping("/customer/id")
    CustomerDto getCustomerById(int id);
    @PostMapping("/customer")
    void createCustomer(CustomerDto customerDto);
    @PostMapping("/customer/id")
    CustomerDto updateCustomerById(int id, CustomerDto customerDto);
    @DeleteMapping("/customer/id")
    void deleteCustomer(int id);
}
