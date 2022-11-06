package com.example.demo.task;

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

    public Tasks(int id, String name) {
        this.id = id;
        this.name =name;
    }



}
