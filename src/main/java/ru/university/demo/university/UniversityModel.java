package ru.university.demo.university;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "universities")
public class UniversityModel {
  @Id
  @GeneratedValue
  private Long id;

  @NotNull
  @NotBlank
  private String name;

  @NotNull
  private LocalDate foundationDate;
}
