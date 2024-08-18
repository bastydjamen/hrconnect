package fr.afrogeek.geekhrconnect.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;


import fr.afrogeek.geekhrconnect.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import fr.afrogeek.geekhrconnect.dto.EmployeeRequest;
import fr.afrogeek.geekhrconnect.dto.EmployeeResponse;
import  fr.afrogeek.geekhrconnect.entity.Employee;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public List<EmployeeResponse> getAllEmployee() {
        return employeeRepository.findAll().stream().map(Employee::toResponse).toList();
    }

    public EmployeeResponse createEmployee(EmployeeRequest employeeRequest) {
        return employeeRepository.save(this.employeeRequestToEmployee(employeeRequest)).toResponse();
    }

    public EmployeeResponse updateEmployee(java.util.UUID id, EmployeeRequest employeeRequest) {
        Employee employeeToUpdate = getEmployeeById(id);
        
        employeeToUpdate.setGender(employeeRequest.getGender());
        employeeToUpdate.setFirtsname(employeeRequest.getFirstName());
        employeeToUpdate.setLastname(employeeRequest.getLastName());
        employeeToUpdate.setEmail(employeeRequest.getEmail());
        employeeToUpdate.setPhone(employeeRequest.getPhone());
        employeeToUpdate.setDateofBirth(employeeRequest.getDateOfBirth());
        employeeToUpdate.setCity(employeeRequest.getCity());
        employeeToUpdate.setCountry(employeeRequest.getCountry());
        employeeToUpdate.setRemainingVacationDays(employeeRequest.getRemainingVacationDays());
        employeeToUpdate.setOnVacation(employeeRequest.isOnVacation());
        employeeToUpdate.setPosition(employeeRequest.getPosition());
        employeeToUpdate.setImageURL(employeeRequest.getImageURL());
        employeeToUpdate.setSuperior(this.getSuperiorById(employeeRequest.getSuperiorId()));

        return employeeRepository.save(employeeToUpdate).toResponse();
    }

    

    public EmployeeResponse getEmployeeResponseById(UUID id) {
        return this.getEmployeeById(id).toResponse();
    }

    public void deleteEmployeeById(UUID id) {
        employeeRepository.deleteById(id);
    }

    private Employee getEmployeeById(UUID id) {
        return employeeRepository.findById(id).orElseThrow(
            ()-> new EntityNotFoundException("Employee with "+id+" not found")
        );
    }

    private Employee getSuperiorById(UUID id) {
        Employee superior = null;
        if(id !=null){
            superior = this.getEmployeeById(id);
        }
        return superior;
    }

    private Employee employeeRequestToEmployee(EmployeeRequest employeeRequest){
        Employee superior = this.getSuperiorById(employeeRequest.getSuperiorId());
        return Employee.builder()
                .gender(employeeRequest.getGender())
                .firtsname(employeeRequest.getFirstName())
                .lastname(employeeRequest.getLastName())
                .email(employeeRequest.getEmail())
                .phone(employeeRequest.getPhone())
                .dateofBirth(employeeRequest.getDateOfBirth())
                .city(employeeRequest.getCity())
                .country(employeeRequest.getCountry())
                .remainingVacationDays(employeeRequest.getRemainingVacationDays())
                .onVacation(employeeRequest.isOnVacation())
                .position(employeeRequest.getPosition())
                .imageURL(employeeRequest.getImageURL())
                .superior(superior)
                .build();
    }
}