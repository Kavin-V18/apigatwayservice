package com.example.api_gateway.controller;

import com.example.api_gateway.client.EmployeeCustomerClient;
import com.example.api_gateway.commondtos.CustomerDto;
import com.example.api_gateway.commondtos.EmployeeDto;
import com.example.api_gateway.responsedtos.EmployeeResponse;
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
    public EmployeeResponse getEmployeeById(@PathVariable int id){
        return employeeCustomerClient.getEmployeeById(id);
    }
    @PostMapping("/employee")
    public String createEmployee(@Valid @RequestBody EmployeeDto employeeDto){
        employeeCustomerClient.createEmployee(employeeDto);
        return "Employee created successfully";
    }
    @PutMapping("/employee/{id}")
    public EmployeeDto updateEmployee(@PathVariable int id,@Valid  @RequestBody EmployeeDto employeeDto){
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
    @PutMapping("/customer/{id}")
    public CustomerDto updateCarModel(@PathVariable int id, @Valid  @RequestBody CustomerDto customerDto){
        return  employeeCustomerClient.updateCustomerById(id,customerDto);
    }
    @DeleteMapping("/customer/{id}")
    public  String deleteCarModel(@PathVariable int id){
        employeeCustomerClient.deleteCustomer(id);
        return "Customer deleted Successfully";
    }
}