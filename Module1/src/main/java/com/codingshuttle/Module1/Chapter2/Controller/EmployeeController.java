package com.codingshuttle.Module1.Chapter2.Controller;

import com.codingshuttle.Module1.Chapter2.DTO.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping ("Employee")
public class EmployeeController {
    /*@GetMapping(path="/getSecretMessage")
    public String getSecretMessage(){
        return "Secret Message: @DFGTY%";
    }*/

    @GetMapping("{EmployeeID}")
    public EmployeeDTO getEmployee(@PathVariable(name="EmployeeID") Long ID){
        return new EmployeeDTO(ID, "Soumik", "Maity", "Soumik@1234gmail.com", "9681931113", LocalDate.of(2018, 5, 2), true);
    }

    @GetMapping
    public String getEmployees(@RequestParam(required=false) Integer age, @RequestParam(required = false) Integer Index_No){
        return "Hi age "+age+" index= "+Index_No;
    }

    @PostMapping("/createemployee")
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO inputemployee){
        return inputemployee;
    }
}
