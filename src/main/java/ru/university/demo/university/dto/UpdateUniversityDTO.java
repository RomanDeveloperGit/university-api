package ru.university.demo.university.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateUniversityDTO {
  @Size(min = 3, max = 255)
  private String newName;
}
