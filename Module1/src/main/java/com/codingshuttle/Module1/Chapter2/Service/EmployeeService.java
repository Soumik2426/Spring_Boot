package com.codingshuttle.Module1.Chapter2.Service;

import com.codingshuttle.Module1.Chapter2.DTO.EmployeeDTO;
import com.codingshuttle.Module1.Chapter2.Entities.EmployeeEntity;
import com.codingshuttle.Module1.Chapter2.Exceptions.ResourceNotFoundException;
import com.codingshuttle.Module1.Chapter2.Repositiories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepositorye, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepositorye;
        this.modelMapper = modelMapper;
    }

    //To get employee by ID
    public EmployeeDTO getEmployeeByID(Long employeeID) {
        return employeeRepository.findById(employeeID)
                .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class))
                .orElseThrow(()->
                    new ResourceNotFoundException("Employee not found with id: " + employeeID));
    }

    //To get all the employees present in the DB
    public List<EmployeeDTO> getEmployees() {
        List<EmployeeEntity> employees=employeeRepository.findAll();
        if(employees.isEmpty()){
            throw new ResourceNotFoundException("No employees are present in the DB");
        }
        return employees
                .stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    //To create a new employee
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        return modelMapper.map(employeeRepository.save(employeeEntity), EmployeeDTO.class);
    }

    //To update an already existing employee
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO, Long employeeID) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        if(employeeRepository.findById(employeeID).isEmpty()){
            throw new ResourceNotFoundException("Employee not found with id: " + employeeID);
        }
        employeeEntity.setId(employeeID);
        return modelMapper.map(employeeRepository.save(employeeEntity), EmployeeDTO.class);
    }

    //To delete an already existing employee from the DB
    public Boolean deleteEmployee(Long employeeID) {
        Optional<EmployeeEntity> employee=employeeRepository.findById(employeeID);
        if(employee.isEmpty()){
            throw new ResourceNotFoundException("Employee not found with id: " + employeeID);
        }
        employeeRepository.deleteById(employeeID);
        return true;
    }

    //To partially update some fields of an existing employee
    public Optional<EmployeeDTO> partialUpdateEmployee(Map<String, Object> updates, Long employeeID) {
        Optional<EmployeeEntity> employee=employeeRepository.findById(employeeID);
        if(employee.isEmpty()){
            throw new ResourceNotFoundException("Employee not found with id: " + employeeID);
        }
        return employee
                .map(employeeEntity -> {
                    updates.forEach((field, value)->{
                        Field fieldToBeUpdated=ReflectionUtils.findField(EmployeeEntity.class, field);
                        fieldToBeUpdated.setAccessible(true);
                        ReflectionUtils.setField(fieldToBeUpdated, employeeEntity, value);
                    });
                    return modelMapper.map(employeeRepository.save(employeeEntity), EmployeeDTO.class);
                });
    }
}
