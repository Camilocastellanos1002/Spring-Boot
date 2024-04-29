package com.riwi._05_Api_Vacantes_JPA_DTO.utils.dto.response;

import com.riwi._05_Api_Vacantes_JPA_DTO.utils.enums.StatusVacant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VacantToCompanyResponse {
    private Long id;
    private String title;
    private String description;
    private StatusVacant status;
}