package com.example.api_gateway.client;


import com.example.api_gateway.commondtos.CustomerDto;
import com.example.api_gateway.commondtos.EmployeeDto;
import com.example.api_gateway.config.FeignConfig;
import com.example.api_gateway.responsedtos.EmployeeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(
        name = "EmployeeCustomerModule",
        url = "http://localhost:8085",configuration = FeignConfig.class
)
public interface EmployeeCustomerClient {

    @GetMapping("/employee")
    List<EmployeeDto> getAllEmployee();
    @GetMapping("/employee/{id}")
    EmployeeResponse getEmployeeById(@PathVariable int id);
    @PostMapping("/employee")
    void createEmployee(@RequestBody EmployeeDto employeeDto);
    @PutMapping("/employee/{id}")
    EmployeeDto updateEmployeeById(@PathVariable int id,@RequestBody EmployeeDto employeeDto);
    @DeleteMapping("/employee/{id}")
    void deleteEmployee(@PathVariable int id);


    @GetMapping("/customer")
    List<CustomerDto> getAllCustomer();
    @GetMapping("/customer/{id}")
    CustomerDto getCustomerById(@PathVariable int id);
    @PostMapping("/customer")
    void createCustomer(@RequestBody CustomerDto customerDto);
    @PutMapping("/customer/{id}")
    CustomerDto updateCustomerById(@PathVariable int id,@RequestBody CustomerDto customerDto);
    @DeleteMapping("/customer/{id}")
    void deleteCustomer(@PathVariable  int id);
}
