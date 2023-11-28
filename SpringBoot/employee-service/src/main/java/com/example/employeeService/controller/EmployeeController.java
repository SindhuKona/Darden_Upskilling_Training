package com.example.employeeService.controller;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeeService.dto.APIResponseDto;
import com.example.employeeService.dto.EmployeeDto;
import com.example.employeeService.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
@Tag(
        name = "Employee Service-Department Controller",
        description = "Employee Controller exposes RESTAPIS for Employee Service"
)
@RestController
@AllArgsConstructor
@RequestMapping("api/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;
	@Operation(
            summary = "Create Employee REST API",
            description = "Create Employee REST API is used to save Employee in a database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )


	@PostMapping
	public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
		
		 EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
		return new ResponseEntity<>(savedEmployee,HttpStatus.CREATED);
		
	}
	
	@Operation(
            summary = "Get Employee REST API ",
            description = " Get Employee REST API is used to get Employee from a database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )

     @GetMapping("{id}")
    public ResponseEntity<APIResponseDto> getEmployee(@PathVariable("id") Long employeeId){
    	 APIResponseDto apiResponseDto = employeeService.getEmployeeById(employeeId);
		return new ResponseEntity<>(apiResponseDto,HttpStatus.OK);
    	
    }
}
