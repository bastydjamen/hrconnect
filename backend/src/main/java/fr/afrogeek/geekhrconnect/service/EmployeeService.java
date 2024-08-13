package fr.afrogeek.geekhrconnect.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import fr.afrogeek.geekhrconnect.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import  fr.afrogeek.geekhrconnect.entity.Employee;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    
   
    public List<Employee> getAllEmployee(){
        return  employeeRepository.findAll();
    }
   
    public Employee cretaEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
    
    public Employee updateEmployee(UUID id, Employee employee){
        Employee employeeToUpdate = employeeRepository.findById(id).orElseThrow();
        employeeToUpdate.setFirtsname(employee.getFirtsname());
        employeeToUpdate.setLastname(employee.getLastname());
        employeeToUpdate.setEmail(employee.getEmail());
        employeeToUpdate.setPhone(employee.getPhone());
        employeeToUpdate.setGender(employee.getGender());
        employeeToUpdate.setDateofBirth(employee.getDateofBirth());
        employeeToUpdate.setCity(employee.getCity());
        employeeToUpdate.setCountry(employee.getCountry());
        employeeToUpdate.setRemainingVacationDays(employee.getRemainingVacationDays());
        employeeToUpdate.setOnVacation(employee.isOnVacation());
        employeeToUpdate.setPosition(employee.getPosition());
        return employeeRepository.save(employeeToUpdate);
    }
    
    public Employee getEmployeeById(UUID id){
        return employeeRepository.findById(id).orElseThrow();

    }
    
   
    public void deleteEmployeeById(UUID id){
        employeeRepository.deleteById(id);
    }



}
