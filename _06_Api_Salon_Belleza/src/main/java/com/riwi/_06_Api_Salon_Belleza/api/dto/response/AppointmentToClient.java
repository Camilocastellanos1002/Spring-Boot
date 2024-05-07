package com.riwi._06_Api_Salon_Belleza.api.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentToClient {
    private Long id;
    private LocalDateTime dateTime;
    private Integer duration;
    private String comments;
    private EmployeeResponse employee;
    private ServiceResponse service;
}