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
public class RegistrationDetail {

    @Id
    @GeneratedValue(strategy = GenerationType. IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id_reg_detail;

    @ManyToOne
    @JoinColumn(name="id_course", nullable = false, foreignKey = @ForeignKey(name = "FK_REGDET_COURSE"))
    private Course course;

    @Column(nullable = false)
    private String room;

    @ManyToOne
    @JoinColumn(name = "id_registration", nullable = false, foreignKey = @ForeignKey(name = "FK_REGDET_REGISTRATION"))
    private Registration registration;


}
