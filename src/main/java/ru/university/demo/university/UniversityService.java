package ru.university.demo.university;

import ru.university.demo.university.dto.CreateUniversityDTO;
import ru.university.demo.university.dto.UpdateUniversityDTO;

import java.util.List;
import java.util.Optional;

public interface UniversityService {
  // todo: pagination
  List<UniversityModel> getUniversityList();
  Optional<UniversityModel> getUniversity(Long id);
  UniversityModel createUniversity(CreateUniversityDTO dto);
  UniversityModel updateUniversity(Long id, UpdateUniversityDTO dto);
  void deleteUniversity(Long id);
}
