package com.riwi._06_Api_Salon_Belleza.api.dto.response;

import com.riwi._06_Api_Salon_Belleza.utils.enums.RoleEmployee;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private RoleEmployee role;
}
