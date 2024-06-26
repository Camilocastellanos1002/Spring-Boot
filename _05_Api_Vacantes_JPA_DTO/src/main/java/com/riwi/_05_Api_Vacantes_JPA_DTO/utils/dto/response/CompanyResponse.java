package com.riwi._05_Api_Vacantes_JPA_DTO.utils.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//Respuesta de que genera la compañia
public class CompanyResponse {
    private String id;
    private String name;
    private String location;
    private String contact;
    private List<VacantToCompanyResponse> vacants;
}
