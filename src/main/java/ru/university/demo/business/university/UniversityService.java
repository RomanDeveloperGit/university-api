package ru.university.demo.business.university;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.university.demo.business.university.dto.CreateUniversityDTO;
import ru.university.demo.business.university.dto.UpdateUniversityDTO;

import java.util.Optional;

public interface UniversityService {
  Page<UniversityModel> getUniversityList(Pageable pageable);
  Optional<UniversityModel> getUniversity(Long id);
  UniversityModel createUniversity(CreateUniversityDTO dto);
  UniversityModel updateUniversity(Long id, UpdateUniversityDTO dto);
  void deleteUniversity(Long id);
}
