package com.codingshuttle.Module1.Chapter2.Service;

import com.codingshuttle.Module1.Chapter2.DTO.CreateDepartmentDTO;
import com.codingshuttle.Module1.Chapter2.DTO.ResponseDepartmentDTO;
import com.codingshuttle.Module1.Chapter2.Entities.DepartmentEntity;
import com.codingshuttle.Module1.Chapter2.Exceptions.ResourceNotFoundException;
import com.codingshuttle.Module1.Chapter2.Repositiories.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;
    private ModelMapper modelMapper;

    public DepartmentService(DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }

    //To get all the departments
    public List<ResponseDepartmentDTO> getAllDepartments() {
        List<DepartmentEntity> departments = departmentRepository.findAll();
        if(departments.isEmpty()){
            throw new ResourceNotFoundException("No departments found");
        }
        return departments
                .stream()
                .map(departmentEntity->modelMapper.map(departmentEntity, ResponseDepartmentDTO.class))
                .collect(Collectors.toList());
    }

    //To create Department
    public ResponseDepartmentDTO createDepartment(CreateDepartmentDTO createDepartmentDTO) {
        DepartmentEntity departmentEntity = modelMapper.map(createDepartmentDTO, DepartmentEntity.class);
        return modelMapper.map(departmentRepository.save(departmentEntity), ResponseDepartmentDTO.class);
    }

    //To update the department
    public ResponseDepartmentDTO updateDepartment(CreateDepartmentDTO createDepartmentDTO, Long departmentID) {
        Optional<DepartmentEntity> department=departmentRepository.findById(departmentID);
        if(department.isEmpty()){
            throw new ResourceNotFoundException("Department not found with id: " + departmentID);
        }
        DepartmentEntity newdept=modelMapper.map(createDepartmentDTO, DepartmentEntity.class);
        newdept.setID(departmentID);
        newdept.setCreatedAt(department.get().getCreatedAt());
        return modelMapper.map(departmentRepository.save(newdept), ResponseDepartmentDTO.class);
    }

    //To delete a department
    public boolean deleteDepartment(Long departmentID) {
        Optional<DepartmentEntity> department=departmentRepository.findById(departmentID);
        if(department.isEmpty()){
            throw new ResourceNotFoundException("Department not found with id: " + departmentID);
        }
        departmentRepository.delete(department.get());
        return true;
    }

    //To get a department using the department ID
    public ResponseDepartmentDTO getDepartmentByID(Long departmentID) {
        Optional<DepartmentEntity> department=departmentRepository.findById(departmentID);
        if(department.isEmpty()){
            throw new ResourceNotFoundException("Department not found with id: " + departmentID);
        }
        return modelMapper.map(department, ResponseDepartmentDTO.class);
    }

    //To partially update an already existing department
    public ResponseDepartmentDTO partialUpdate(Map<String, Object> updates, Long departmentID) {
        Optional<DepartmentEntity> departmentEntity=departmentRepository.findById(departmentID);
        if(departmentEntity.isEmpty()){
            throw new ResourceNotFoundException("Department not found with id: " + departmentID);
        }
        DepartmentEntity dept=departmentEntity.get();
        updates.forEach((field, value)->{
            Field fieldToBeUpdated=ReflectionUtils.findField(DepartmentEntity.class, field);
            fieldToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldToBeUpdated, dept, value);
        });
        return modelMapper.map(departmentRepository.save(dept),ResponseDepartmentDTO.class);
    }
}
