package com.riwi._05_Api_Vacantes_JPA_DTO.entities;

import com.riwi._05_Api_Vacantes_JPA_DTO.utils.enums.StatusVacant;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "vacant")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vacant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    //anotacion que describe la variable tipo enum con el typo string, que tendra dos valores ACTIVE ó INACTIVE
    @Enumerated(EnumType.STRING) // Especificar que el enúmero será de tipo String
    private StatusVacant status;

    /*
     *Vacantes como es la relacion debil
     * @ManyToOne: Muchos a uno / Muchas vacantes pertenecer a una empresa
     */
    @ManyToOne(fetch = FetchType.LAZY) //no trae los atributos de company, no genera el join implicito
    @JoinColumn(name = "company_id", referencedColumnName = "id") //forma de declarar la llave foranea
    private Company company;
}