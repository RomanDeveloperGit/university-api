package ru.university.demo.university.dto;

import java.time.LocalDate;

public record CreateUniversityDTO(
  String name,
  LocalDate foundationDate
) { }
