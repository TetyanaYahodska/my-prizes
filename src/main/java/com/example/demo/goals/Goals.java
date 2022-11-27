package com.example.demo.goals;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "goals")
@NoArgsConstructor
@EqualsAndHashCode(of = "goals")
public class Goals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "name", length = 350, nullable = false)
    private String name;

    public Goals(int id, String name) {
        this.id = id;
        this.name =name;
    }
}


