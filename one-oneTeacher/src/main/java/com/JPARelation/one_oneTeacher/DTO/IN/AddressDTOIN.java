package com.JPARelation.one_oneTeacher.DTO.IN;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTOIN {
    private Integer teacher_id;
    @NotBlank(message = "area must not be blank")
    @Size(max = 100, message = "area must not be more than 100 characters")
    private String area;
    @NotBlank(message = "street should not be empty")
    @Size(max = 100, message = "street must not be more than 100 characters")
    private String street;
    @NotBlank(message = "buildingNumber must not be blank")
    @Size(max = 100, message = "buildingNumber must not be more than 100 characters")
    private String buildingNumber;

}
