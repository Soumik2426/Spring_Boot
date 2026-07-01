package com.codingshuttle.Module1.Chapter2.Controller;

import com.codingshuttle.Module1.Chapter2.DTO.EmployeeDTO;
import com.codingshuttle.Module1.Chapter2.Entities.EmployeeEntity;
import com.codingshuttle.Module1.Chapter2.Exceptions.ResourceNotFoundException;
import com.codingshuttle.Module1.Chapter2.Service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping ("Employee")
public class EmployeeController {

    private final EmployeeService employeeService;
    public  EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //To get employee by ID
    @GetMapping("getEmployee/{employeeID}")
    public ResponseEntity<EmployeeDTO> getEmployeeByID(@PathVariable Long employeeID){
        EmployeeDTO employee=employeeService.getEmployeeByID(employeeID);
        return ResponseEntity.ok(employee);
    }

    //To get all the employees present in the DB
    @GetMapping("getEmployees")
    public ResponseEntity<List<EmployeeDTO>> getEmployees(){
        List<EmployeeDTO> employee=employeeService.getEmployees();
        return ResponseEntity.ok(employeeService.getEmployees());
    }

    //To create a new employee
    @PostMapping("createEmployee")
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody @Valid EmployeeDTO employeeDTO){
        return new ResponseEntity<>(employeeService.createEmployee(employeeDTO), HttpStatus.CREATED);
    }

    //To update an already existing employee
    @PutMapping("updateEmployee/{employeeID}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody @Valid EmployeeDTO employeeDTO, @PathVariable Long employeeID){
        EmployeeDTO employee=employeeService.updateEmployee(employeeDTO,employeeID);
        return ResponseEntity.ok(employee);
    }

    //To delete an already existing employee from the DB
    @DeleteMapping("deleteEmployee/{employeeID}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable Long employeeID){
        Boolean deleted=employeeService.deleteEmployee(employeeID);
        return ResponseEntity.ok(deleted);
    }

    //To partially update some fields of an existing employee
    @PatchMapping("partialUpdate/{employeeID}")
    public ResponseEntity<Optional<EmployeeDTO>> partialUpdateEmployee(@RequestBody @Valid Map<String, Object> updates, @PathVariable Long employeeID){
        Optional<EmployeeDTO> employee=employeeService.partialUpdateEmployee(updates,employeeID);
        if(employee.isEmpty()){
            throw new ResourceNotFoundException("Employee With ID "+employeeID+" do not exist");
        }
        return ResponseEntity.ok(employee);
    }
}
