package com.riwi._05_Api_Vacantes_JPA_DTO.entities;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "company")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID) //forma de generar un ID unico de 32 Caracteres
    private String id;
    //@Column forma de ponerle una configuracion al atributo, donde se pone la longitud maxima y que sea obligatorio
    @Column(length = 40, nullable = false)
    private String name;
    @Column(length = 60, nullable = false)
    private String location;
    @Column(length = 15, nullable = false)
    private String contact;

    /**
     * @OneToMany -> (Uno a muchos) Una empresa puede tener muchas vacantes
     * @ MapedBy -> Debemos especificar en que propiedad se está mapeando en la otra
                    entidad, donde se esta guardando la relacion
     * Cascade.All->Especificamos el tipo cascada, All quiere decir que tendrá todos
                    los tipos de cascada es decir los cambios que sufra la entidad PADRE (eliminacion, actualizacion ), se veran reflejados en la entidad HIJOS
     * fetch EAGER -> genera un join implicito de los atributos de la otra compañia
     * orphanRemoval -> (ON DELETE CASCADE en MySQL) Espeficar que un objeto huerfano (sin llave foranea) sera eliminado
                   *false-> que si al eliminar la entidad padre, el objeto sin llavefornanea no se elimina
                            y dicho atributo queda en valor null
                   *true -> que si al eliminar la entidad padre, el objeto queda sin llave foranea sera eliminado
     
     */

    @OneToMany(mappedBy = "company", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
    @ToString.Exclude // excluimos esta propiedad del to string
    @EqualsAndHashCode.Exclude // excluimos las propiedades dentro la lista
    private List<Vacant> vacants;
}