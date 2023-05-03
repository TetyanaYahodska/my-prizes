package com.example.demo.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class GoalsDto {
    @NotNull
    @Size(min = 1, message = "{Size.goalsDto.name}")
    private String name;

    @NotNull
    @Size(min = 1, message = "{Size.goalsDto.value}")
    private Integer value;


    @Override
    public String toString() {
        return "GoalsDto{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

}
