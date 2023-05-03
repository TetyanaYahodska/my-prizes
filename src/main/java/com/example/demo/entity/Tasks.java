package com.example.demo.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Setter
@Getter
@Entity
@Table(name = "tasks")
@NoArgsConstructor
@EqualsAndHashCode(of = "tasks")
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "name", length = 350, nullable = false)
    private String name;

    @Column(name = "value", length = 3, nullable = false)
    private Integer value;

    public Tasks(String name, Integer value) {
        this.name = name;
        this.value = value;
    }



}
