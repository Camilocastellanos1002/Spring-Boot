package com.riwi._05_Api_Vacantes_JPA_DTO.utils.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyToVancantResponse {
    private String id;
    private String name;
    private String location;
    private String contact;
}
