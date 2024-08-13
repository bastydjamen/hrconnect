package fr.afrogeek.geekhrconnect.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.afrogeek.geekhrconnect.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee , UUID>{

}
