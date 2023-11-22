package ru.university.demo.business.university;

import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "universities")
public class UniversityModel {
  @Id
  @GeneratedValue
  private Long id;

  @Column(unique = true)
  @Size(min = 3, max = 255)
  private String name;

  @Temporal(TemporalType.DATE)
  @PastOrPresent
  private LocalDate foundationDate;
}
