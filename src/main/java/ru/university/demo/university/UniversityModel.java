package ru.university.demo.university;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  @PastOrPresent
  private LocalDate foundationDate;
}
