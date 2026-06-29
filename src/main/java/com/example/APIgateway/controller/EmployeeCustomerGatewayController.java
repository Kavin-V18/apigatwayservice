package com.example.APIgateway.controller;

import com.example.APIgateway.client.EmployeeCustomerClient;
import com.example.APIgateway.commondtos.CustomerDto;
import com.example.APIgateway.commondtos.EmployeeDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class EmployeeCustomerGatewayController {

    private final EmployeeCustomerClient employeeCustomerClient;

    @GetMapping("/employee")
    public List<EmployeeDto> getEmployee() {
        return employeeCustomerClient.getAllEmployee();
    }
    @GetMapping("/employee/{id}")
    public EmployeeDto getEmployeeById(@PathVariable int id){
        return employeeCustomerClient.getEmployeeById(id);
    }
    @PostMapping("/employee")
    public String createEmployee(@Valid @RequestBody EmployeeDto employeeDto){
        employeeCustomerClient.createEmployee(employeeDto);
        return "Employee created successfully";
    }
    @PostMapping("/employee/{id}")
    public EmployeeDto UpdateEmployee(@PathVariable int id,@Valid  @RequestBody EmployeeDto employeeDto){
        return  employeeCustomerClient.updateEmployeeById(id,employeeDto);
    }
    @DeleteMapping("/employee/{id}")
    public  String deleteEmployee(@PathVariable int id){
        employeeCustomerClient.deleteEmployee(id);
        return "Employee deleted Successfully";
    }


    @GetMapping("/customer")
    public List<CustomerDto> getCustomer() {
        return employeeCustomerClient.getAllCustomer();
    }
    @GetMapping("/customer/{id}")
    public CustomerDto getCarModelById(@PathVariable int id){
        return employeeCustomerClient.getCustomerById(id);
    }
    @PostMapping("/customer")
    public String createCarModel(@Valid @RequestBody CustomerDto customerDto){
        employeeCustomerClient.createCustomer(customerDto);
        return "Customer created successfully";
    }
    @PostMapping("/customer/{id}")
    public CustomerDto UpdateCarModel(@PathVariable int id, @Valid  @RequestBody CustomerDto customerDto){
        return  employeeCustomerClient.updateCustomerById(id,customerDto);
    }
    @DeleteMapping("/customer/{id}")
    public  String deleteCarModel(@PathVariable int id){
        employeeCustomerClient.deleteCustomer(id);
        return "Customer deleted Successfully";
    }
}