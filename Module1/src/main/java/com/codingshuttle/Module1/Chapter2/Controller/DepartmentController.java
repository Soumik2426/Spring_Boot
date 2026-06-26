package com.codingshuttle.Module1.Chapter2.Controller;

import com.codingshuttle.Module1.Chapter2.DTO.CreateDepartmentDTO;
import com.codingshuttle.Module1.Chapter2.DTO.ResponseDepartmentDTO;
import com.codingshuttle.Module1.Chapter2.Service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("Department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    //To get all the departments
    @GetMapping("getDepartments")
    public ResponseEntity<List<ResponseDepartmentDTO>> getAllDepartments(){
        List<ResponseDepartmentDTO> departments=departmentService.getAllDepartments();
        if(departments.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    //To create Department
    @PostMapping("createDepartment")
    public ResponseEntity<ResponseDepartmentDTO> createDepartment(@RequestBody @Valid CreateDepartmentDTO createDepartmentDTO){
        return new ResponseEntity<>(departmentService.createDepartment(createDepartmentDTO), HttpStatus.CREATED);
    }

    //To update the department
    @PutMapping("updateDepartment/{departmentID}")
    public ResponseEntity<ResponseDepartmentDTO> updateDepartment(@RequestBody @Valid CreateDepartmentDTO createDepartmentDTO,
                                                                            @PathVariable Long departmentID){
        if(departmentService.updateDepartment(createDepartmentDTO, departmentID)==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(departmentService.updateDepartment(createDepartmentDTO, departmentID));
    }

    //To delete a department
    @DeleteMapping("deleteDepartment/{departmentID}")
    public ResponseEntity<Boolean> deleteDepartment(@PathVariable Long departmentID){
        if(!departmentService.deleteDepartment(departmentID)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(departmentService.deleteDepartment(departmentID));
    }

    //To get a department using the department ID
    @GetMapping("getDepartment/{departmentID}")
    public ResponseEntity<ResponseDepartmentDTO> getDepartmentByID(@PathVariable Long departmentID){
        if(departmentService.getDepartmentByID(departmentID)==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(departmentService.getDepartmentByID(departmentID));
    }

    //To partially update an already existing department
    @PatchMapping("partialUpdate/{departmentID}")
    public ResponseEntity<ResponseDepartmentDTO> partialUpdate(@RequestBody @Valid Map<String, Object> updates,
                                               @PathVariable Long departmentID){
        if(departmentService.partialUpdate(updates,departmentID)==null){
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(departmentService.partialUpdate(updates, departmentID), HttpStatus.OK);
    }
}
