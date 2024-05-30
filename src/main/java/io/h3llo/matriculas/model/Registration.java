package io.h3llo.matriculas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id_registration;

    @Column(nullable = false)
    private LocalDateTime enroll_date;

    //relacion con estudiante
    @ManyToOne
    @JoinColumn(name="id_student",nullable = false, foreignKey = @ForeignKey(name = "FK_REGISTRATION_STUDENT"))
    private Student student;

    //LISTA de "detalle de la matricula"
    @OneToMany(mappedBy = "registration", cascade = CascadeType.ALL)  // o sea el @ManyToOne de la table Registration Detail  EL ATRIBUTO QUE EN EL OTRO LADO SE ENLAZA CON ESTA TABLA
//    private List<RegistrationDetail> registration_detail_array;
    private List<RegistrationDetail> details;

    @Column(nullable = false)
    private boolean status;





}
