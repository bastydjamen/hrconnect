package fr.afrogeek.geekhrconnect.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import fr.afrogeek.geekhrconnect.entity.Employee;


@RepositoryRestResource(exported = false)
@Repository
public interface EmployeeRepository extends JpaRepository<Employee , UUID>{

}
