package io.h3llo.matriculas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincremental (MySQL, SQLServer, PostgreSQL)
    @EqualsAndHashCode.Include
    private Integer id_student;

    @Column( nullable = false, length = 50)
    private String name;

    @Column( nullable = false, length = 50)
    private String lastname;

    @Column( nullable = false, length = 8)
    private String dni;

    @Column( nullable = false)
    private Integer age;


}
