package fr.afrogeek.geekhrconnect.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import fr.afrogeek.geekhrconnect.dto.EmployeeResponse;
import fr.afrogeek.geekhrconnect.enums.Gender;
import fr.afrogeek.geekhrconnect.enums.Position;



@Entity
@Table(name="employees")
@Data 
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor 
public class Employee {
@Id
@GeneratedValue
private UUID id;

@Enumerated(EnumType.STRING)
@Column(nullable = false)
private Gender gender;

@Column(nullable = false)
private String firtsname;

@Column(nullable = false)
private String lastname;

@Column(nullable = false, unique = true)
private String email;

@Column(nullable = false, unique = true)
private String phone;

@Column(nullable = false)
private LocalDateTime dateofBirth;

@Column(nullable = false)
private String city; 

@Column(nullable = false)
private String country;

@Column(nullable = false)
private Long remainingVacationDays;

@Column(nullable = false)
private boolean onVacation;

@Enumerated(EnumType.STRING)
@Column(nullable = false)
private Position position;

@Column(nullable = false)
private String imageURL;

@ManyToOne
private Employee superior;

public EmployeeResponse toResponse(){
        EmployeeResponse employeeResponse = EmployeeResponse.builder()
                                            .id(this.id)
                                            .gender(this.gender)
                                            .firstName(this.firtsname)
                                            .lastName(this.lastname)
                                            .email(this.email)
                                            .phone(this.phone)
                                            .dateOfBirth(this.dateofBirth)
                                            .city(this.city)
                                            .country(this.country)
                                            .remainingVacationDays(this.remainingVacationDays)
                                            .onVacation(this.onVacation)
                                            .position(this.position)
                                            .imageURL(this.imageURL)
                                            .build();

        if(this.superior!= null){
            String gender = this.superior.gender==Gender.men?"Mr. ":"Mlle ";
            String superiorName = gender + this.superior.lastname + " "+ this.superior.firtsname;
            employeeResponse.setSuperiorName(superiorName);
            employeeResponse.setSuperiorId(this.superior.getId());
        }

        return employeeResponse;
    }

}
