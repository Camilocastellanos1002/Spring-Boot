package com.riwi.products.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "product") /* Crear tabla en la base de datos de MySQL */
@Data   /* forma de crear getters and setters por medio de la dependencia lombok*/
@AllArgsConstructor /* Anotacion para crear constructor lleno */
@NoArgsConstructor /*Anotacion para crear constructor vacio */
public class Product {


    @Id /* id como llave primaria */
    @GeneratedValue(strategy = GenerationType.IDENTITY) /* auto incrementable */
    private Long id; 
    private String name;
    private int quantity;
    private double price;


}
