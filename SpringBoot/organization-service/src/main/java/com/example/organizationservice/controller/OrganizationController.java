package com.example.organizationservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.organizationservice.dto.OrganizationDto;
import com.example.organizationservice.service.OrganizationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
@Tag(
        name = "Organization Service-Department Controller",
        description = "Organization Controller exposes RESTAPIS for Organization Service"
)
@RestController
@RequestMapping("api/organizations")
@AllArgsConstructor

public class OrganizationController {

	private OrganizationService organizationService;
	@Operation(
            summary = "Create Organization  REST API",
            description = "Create Organization REST API is used to save Organization in a database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )

	@PostMapping
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto){
        OrganizationDto savedOrganization = organizationService.saveOrganization(organizationDto);
        return new ResponseEntity<>(savedOrganization, HttpStatus.CREATED);
    }
	@Operation(
            summary = "Get Organization  REST API",
            description = "Get Organization REST API is used to get Organization from a database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
	 @GetMapping("{code}")
	    public ResponseEntity<OrganizationDto> getOrganization(@PathVariable("code") String organizationCode){
	        OrganizationDto organizationDto = organizationService.getOrganizationByCode(organizationCode);
	        return ResponseEntity.ok(organizationDto);
	    }
	
}
