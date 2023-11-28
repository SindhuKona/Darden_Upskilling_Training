package com.example.organizationservice.dto;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "OrganizationDto model Information"
)

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDto {

	private Long id;
	@Schema(
	        description = "organization Name"
	)

    private String organizationName;
	@Schema(
	        description = "organization Description"
	)
    private String organizationDescription;
	@Schema(
	        description = "organization Code"
	)
    private String organizationCode;
	@Schema(
	        description = "organization Created Date"
	)

    private LocalDateTime createdDate;

}
