package fr.afrogeek.geekhrconnect;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import fr.afrogeek.geekhrconnect.dto.EmployeeRequest;
import fr.afrogeek.geekhrconnect.dto.EmployeeResponse;
import fr.afrogeek.geekhrconnect.entity.Employee;
import fr.afrogeek.geekhrconnect.enums.Gender;
import fr.afrogeek.geekhrconnect.enums.Position;
import fr.afrogeek.geekhrconnect.repository.EmployeeRepository;
import fr.afrogeek.geekhrconnect.service.EmployeeService;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

@Mock
    private EmployeeRepository employeeRepository;

   @InjectMocks
    private EmployeeService employeeService;

    private Employee employee;
    private EmployeeRequest employeeRequest;


    @BeforeEach
    public void setUp() {
        employee = Employee.builder()
                .id(UUID.randomUUID())
                .gender(Gender.men)
                .firstname("John")
                .lastname("Doe")
                .email("john.doe@example.com")
                .phone("+1234567890")
                .dateofBirth(LocalDateTime.of(1970, 1, 1, 0, 0))
                .city("New York")
                .country("USA")
                .remainingVacationDays(20L)
                .onVacation(false)
                .position(Position.CEO)
                .imageURL("https://example.com/images/john_doe.jpg")
                .superior(null)
                .build();

        employeeRequest = EmployeeRequest.builder()
                .gender(Gender.men)
                .firstName("John")
                .lastName("Doe")
                .email("john.doe@example.com")
                .phone("+1234567890")
                .dateOfBirth(LocalDateTime.of(1970, 1, 1, 0, 0))
                .city("New York")
                .country("USA")
                .remainingVacationDays(20L)
                .onVacation(false)
                .position(Position.CEO)
                .imageURL("https://example.com/images/john_doe.jpg")
                .superiorId(null).build();
    }

     @Test
    void testGetAllEmployee() {
        //arrange
        when(employeeRepository.findAll()).thenReturn(List.of(employee));

        //act
        List<EmployeeResponse> employees = employeeService.getAllEmployee();

        //assert
        assertEquals(1, employees.size());
        assertEquals(employee.toResponse().toString(), employees.get(0).toString());

        verify(employeeRepository, times(1)).findAll();
    }

    @Test
    void testDeleteEmployeeById(){
        //Arrange
        when(employeeRepository.findById(employee.getId())).thenReturn(Optional.of(employee));

        //Act
         employeeService.deleteEmployeeById(employee.getId());

        //Assert
        verify(employeeRepository, times(1)).delete(employee);
        verify(employeeRepository, times(1)).findById(employee.getId());
    }

    @Test
    void testCreateEmployee(){
        //Arrange
        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);

        //Act
        EmployeeResponse employeeResponse = employeeService.createEmployee(employeeRequest);

        //Assert
        assertNotNull(employeeResponse);
        assertEquals(employee.toResponse().toString(), employeeResponse.toString());

        verify(employeeRepository, times(1)).save(any(Employee.class));
    }

    @Test
    void testUpdateEmployee(){
        //arrange
        when(employeeRepository.findById(employee.getId())).thenReturn(Optional.of(employee));
        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);

        //act
        EmployeeResponse employeeResponse = employeeService.updateEmployee(employee.getId(), employeeRequest);

        //assert
        assertNotNull(employeeResponse);
        assertEquals(employee.toResponse().toString(), employeeResponse.toString());
        verify(employeeRepository, times(1)).findById(employee.getId());
        verify(employeeRepository, times(1)).save(any(Employee.class));
    }

    @Test
    void testGetEmployeeResponseById() {
        //arrange
        when(employeeRepository.findById(employee.getId())).thenReturn(Optional.of(employee));

        //act
        EmployeeResponse employeeResponse = employeeService.getEmployeeResponseById(employee.getId());

        //assert
        assertNotNull(employeeResponse);
        assertEquals(employee.toResponse().toString(), employeeResponse.toString());

        verify(employeeRepository, times(1)).findById(employee.getId());
    }
}
