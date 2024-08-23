package fr.afrogeek.geekhrconnect.util;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;

import fr.afrogeek.geekhrconnect.entity.Employee;
import fr.afrogeek.geekhrconnect.enums.Gender;
import fr.afrogeek.geekhrconnect.enums.Position;
import fr.afrogeek.geekhrconnect.repository.EmployeeRepository;

public class DataBaseInitializer  implements CommandLineRunner{
    private final EmployeeRepository employeeRepository = null;
    
    
    @Override
    public void run(String... args) throws Exception {
        this.createEmployee();
    }

    public void createEmployee() {
        Employee ceo = Employee.builder()
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
                .build();

        Employee cto = Employee.builder()
                .gender(Gender.women)
                .firstname("Jane")
                .lastname("Smith")
                .email("jane.smith@example.com")
                .phone("+1234567891")
                .dateofBirth(LocalDateTime.of(1980, 2, 2, 0, 0))
                .city("San Francisco")
                .country("USA")
                .remainingVacationDays(25L)
                .onVacation(false)
                .position(Position.CTO)
                .imageURL("https://example.com/images/jane_smith.jpg")
                .superior(ceo)
                .build();

        Employee coo = Employee.builder()
                .gender(Gender.men)
                .firstname("Robert")
                .lastname("Johnson")
                .email("robert.johnson@example.com")
                .phone("+1234567892")
                .dateofBirth(LocalDateTime.of(1985, 3, 3, 0, 0))
                .city("Chicago")
                .country("USA")
                .remainingVacationDays(15L)
                .onVacation(false)
                .position(Position.COO)
                .imageURL("https://afrogeek.fr/assets/img/hrconnect/men/2.png")
                .superior(ceo)
                .build();

        Employee teamManager = Employee.builder()
                .gender(Gender.women)
                .firstname("Emily")
                .lastname("Davis")
                .email("emily.davis@example.com")
                .phone("+1234567893")
                .dateofBirth(LocalDateTime.of(1990, 4, 4, 0, 0))
                .city("Los Angeles")
                .country("USA")
                .remainingVacationDays(10L)
                .onVacation(false)
                .position(Position.TEAM_MANAGER_SOFTWARE)
                .imageURL("https://afrogeek.fr/assets/img/hrconnect/women/1.png")
                .superior(coo)
                .build();

        Employee seniorDeveloper = Employee.builder()
                .gender(Gender.men)
                .firstname("Michael")
                .lastname("Brown")
                .email("michael.brown@example.com")
                .phone("+1234567894")
                .dateofBirth(LocalDateTime.of(1992, 5, 5, 0, 0))
                .city("Seattle")
                .country("USA")
                .remainingVacationDays(12L)
                .onVacation(false)
                .position(Position.SENIOR_SOFTWARE_DEVELOPER)
                .imageURL("https://example.com/images/michael_brown.jpg")
                .superior(teamManager)
                .build();

        Employee developer = Employee.builder()
                .gender(Gender.women)
                .firstname("Olivia")
                .lastname("Williams")
                .email("olivia.williams@example.com")
                .phone("+1234567895")
                .dateofBirth(LocalDateTime.of(1994, 6, 6, 0, 0))
                .city("Austin")
                .country("USA")
                .remainingVacationDays(18L)
                .onVacation(false)
                .position(Position.SOFTWARE_DEVELOPER)
                .imageURL("https://example.com/images/olivia_williams.jpg")
                .superior(seniorDeveloper)
                .build();

        Employee juniorDeveloper = Employee.builder()
                .gender(Gender.men)
                .firstname("David")
                .lastname("Miller")
                .email("david.miller@example.com")
                .phone("+1234567896")
                .dateofBirth(LocalDateTime.of(1996, 7, 7, 0, 0))
                .city("Boston")
                .country("USA")
                .remainingVacationDays(14L)
                .onVacation(false)
                .position(Position.JUNIOR_SOFTWARE_DEVELOPER)
                .imageURL("https://example.com/images/david_miller.jpg")
                .superior(developer)
                .build();

        Employee workingStudent = Employee.builder()
                .gender(Gender.women)
                .firstname("Sophia")
                .lastname("Garcia")
                .email("sophia.garcia@example.com")
                .phone("+1234567897")
                .dateofBirth(LocalDateTime.of(1998, 8, 8, 0, 0))
                .city("Miami")
                .country("USA")
                .remainingVacationDays(8L)
                .onVacation(false)
                .position(Position.WORKING_STUDENT)
                .imageURL("https://example.com/images/sophia_garcia.jpg")
                .superior(juniorDeveloper)
                .build();

        employeeRepository.saveAll(Arrays.asList(ceo, cto, coo, teamManager, seniorDeveloper, developer, juniorDeveloper, workingStudent));
    }

    
    
}


