package ru.university.demo.university;

import java.time.LocalDate;
import java.util.List;

public interface UniversityService {
  // todo: pagination
  List<UniversityModel> getUniversityList();
  UniversityModel getUniversity(Long id);
  UniversityModel createUniversity(String name, LocalDate foundationDate);
  UniversityModel updateUniversityName(String newName);
  void deleteUniversity(Long id);
}
