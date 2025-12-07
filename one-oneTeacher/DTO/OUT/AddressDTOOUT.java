package com.JPARelation.one_oneTeacher.DTO.OUT;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTOOUT {
    private Integer teacher_id;
    private String area;
    private String street;
    private String buildingNumber;

}
