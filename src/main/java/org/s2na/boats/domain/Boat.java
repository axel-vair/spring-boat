package org.s2na.boats.domain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "boat")
public class Boat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "length")
    private Float length;

    @Column(name = "tonnage")
    private Integer tonnage;

    @ManyToOne
    @JoinColumn(name = "classe_id")
    private Classe classe;
}
