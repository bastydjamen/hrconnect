package fr.afrogeek.geekhrconnect.dto;
import fr.afrogeek.geekhrconnect.enums.Gender;
import fr.afrogeek.geekhrconnect.enums.Position;
import java.util.*;
import java.time.LocalDateTime;
import lombok.*;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeRequest { 
    private Gender gender;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private LocalDateTime dateOfBirth;
    private String city;
    private String country;
    private Long remainingVacationDays;
    private boolean onVacation;
    private Position position;
    private String imageURL;
    private UUID superiorId;

}
