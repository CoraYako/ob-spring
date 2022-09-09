package com.openbootcamp.obspringboot.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "computers")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ComputerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "The CPU can't be null.")
    @NotBlank(message = "Must provide a name for the CPU.")
    private String cpu;

    @NotNull(message = "The RAM can't be null.")
    @Min(value = 1, message = "The amount of RAM can't be zero.")
    private Integer ram;

    private String gpu;
}
