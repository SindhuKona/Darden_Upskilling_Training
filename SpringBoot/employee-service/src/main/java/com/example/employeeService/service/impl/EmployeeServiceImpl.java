package com.example.employeeService.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.employeeService.dto.APIResponseDto;
import com.example.employeeService.dto.DepartmentDto;
import com.example.employeeService.dto.EmployeeDto;
import com.example.employeeService.dto.OrganizationDto;
import com.example.employeeService.entity.Employee;
import com.example.employeeService.mapper.EmployeeMapper;
import com.example.employeeService.repository.EmployeeRepository;
import com.example.employeeService.service.EmployeeService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;

@Service
//@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	@Autowired
	private EmployeeRepository employeeRepo;
//	private RestTemplate restTemplate;
	@Autowired
	private WebClient webClient;
//	private APIClient apiClient;

	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
		Employee savedEmployee = employeeRepo.save(employee);
		EmployeeDto savedEmployeeDto = EmployeeMapper.mapToEmployeeDto(savedEmployee);
		return savedEmployeeDto;
	}

	@Override
	//@CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
	public APIResponseDto getEmployeeById(Long employeeId) {

		Employee employee = employeeRepo.findById(employeeId).get();
//		ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity(
//				"http://localhost:8080/api/departments/" + employee.getDepartmentCode(), DepartmentDto.class);
//
//		DepartmentDto departmentDto = responseEntity.getBody();

		DepartmentDto departmentDto = webClient.get()
				.uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode()).retrieve()
				.bodyToMono(DepartmentDto.class).block();

//		DepartmentDto departmentDto =apiClient.getDepartment(employee.getDepartmentCode());

		OrganizationDto organizationDto = webClient.get()
				.uri("http://localhost:8083/api/organizations/" + employee.getOrganizationCode()).retrieve()
				.bodyToMono(OrganizationDto.class).block();

		EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);

		APIResponseDto apiResponseDto = new APIResponseDto();
		apiResponseDto.setEmployee(employeeDto);
		apiResponseDto.setDepartment(departmentDto);
		apiResponseDto.setOrganization(organizationDto);

		return apiResponseDto;
	}

	public APIResponseDto getDefaultDepartment(Long employeeId, Exception exception) {
		LOGGER.info("inside getEmployeeById() method");
		Employee employee = employeeRepo.findById(employeeId).get();

		DepartmentDto departmentDto = new DepartmentDto();
		departmentDto.setDepartmentName("R&D Department");
		departmentDto.setDepartmentCode("RD001");
		departmentDto.setDepartmentDescription("Research and Development Department");

		EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);

		APIResponseDto apiResponseDto = new APIResponseDto();
		apiResponseDto.setEmployee(employeeDto);
		apiResponseDto.setDepartment(departmentDto);
		return apiResponseDto;
	}
}
