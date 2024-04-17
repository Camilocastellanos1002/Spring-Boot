package com.riwi.primerWeb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//Entity indica que esta clase sera una entidad y podra ser mapeada
@Entity
//Table nos permite dar configuraciones a la tabla MySQL
@Table(name="coder")
public class Coder {
    //parametros
        //Id indica que el atributo siguiente sera la llave primaria (libreria jakarta)
        @Id
        //Permite generar id auto incrementables (AUTO_INCREMENT EN MySQL)
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private int age;
        private String clan;
    
    //constructores
    public Coder() {
    }

    public Coder(String name, int age, String clan) {
        this.name = name;
        this.age = age;
        this.clan = clan;
    }

    //getter and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getClan() {
        return clan;
    }

    public void setClan(String clan) {
        this.clan = clan;
    }

    //toString
    @Override
    public String toString() {
        return "Coder [id=" + id + ", name=" + name + ", age=" + age + ", clan=" + clan + "]";
    }

    
    
}
