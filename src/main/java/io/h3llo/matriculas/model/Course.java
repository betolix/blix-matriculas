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
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincremental (MySQL, SQLServer, PostgreSQL)
    @EqualsAndHashCode.Include
    private Integer id_course;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false, length = 5)
    private String abbr;

    @Column(nullable = false)
    private boolean status;

}
