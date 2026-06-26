package com.codingshuttle.Module1.Chapter2.Repositiories;

import com.codingshuttle.Module1.Chapter2.Entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}
