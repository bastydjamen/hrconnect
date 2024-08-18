package fr.afrogeek.geekhrconnect.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.afrogeek.geekhrconnect.dto.EmployeeRequest;
import fr.afrogeek.geekhrconnect.dto.EmployeeResponse;
import fr.afrogeek.geekhrconnect.entity.Employee;
import fr.afrogeek.geekhrconnect.service.EmployeeService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

     private final EmployeeService employeeService;

    @GetMapping
    public List<EmployeeResponse> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @PostMapping
    public EmployeeResponse createEmployee(@RequestBody EmployeeRequest employeeRequest) {
        return employeeService.createEmployee(employeeRequest);
    }

    @PutMapping("/{id}")
    public EmployeeResponse updateEmployee(@PathVariable UUID id, @RequestBody EmployeeRequest employeeRequest) {
        return employeeService.updateEmployee(id, employeeRequest);
    }

    @GetMapping("/{id}")
    public EmployeeResponse getEmployeeById(@PathVariable UUID id) {
        return employeeService.getEmployeeResponseById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable UUID id) {
        employeeService.deleteEmployeeById(id);
    }
    
}
