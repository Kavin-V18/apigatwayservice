package com.example.APIgateway.client;


import com.example.APIgateway.commondtos.CustomerDto;
import com.example.APIgateway.commondtos.EmployeeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(
        name = "EmployeeCustomerModule",
        url = "http://localhost:8085"
)
public interface EmployeeCustomerClient {

    @GetMapping("/employee")
    List<EmployeeDto> getAllEmployee();
    @GetMapping("/employee/{id}")
    EmployeeDto getEmployeeById(@PathVariable int id);
    @PostMapping("/employee")
    void createEmployee(@RequestBody EmployeeDto employeeDto);
    @PostMapping("/employee/{id}")
    EmployeeDto updateEmployeeById(@PathVariable int id,@RequestBody EmployeeDto employeeDto);
    @DeleteMapping("/employee/{id}")
    void deleteEmployee(@PathVariable int id);


    @GetMapping("/customer")
    List<CustomerDto> getAllCustomer();
    @GetMapping("/customer/{id}")
    CustomerDto getCustomerById(@PathVariable int id);
    @PostMapping("/customer")
    void createCustomer(@RequestBody CustomerDto customerDto);
    @PostMapping("/customer/{id}")
    CustomerDto updateCustomerById(@PathVariable int id,@RequestBody CustomerDto customerDto);
    @DeleteMapping("/customer/{id}")
    void deleteCustomer(@PathVariable  int id);
}
