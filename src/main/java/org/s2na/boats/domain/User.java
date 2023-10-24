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
@Table(name = "my_user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "role")
    private String role;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name  = "lastName", nullable = true)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

}
